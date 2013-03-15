package com.dyaod.api.service;


import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyaod.api.APIConstant;
import com.dyaod.api.dao.ApiAgentDao;
import com.dyaod.api.entity.ApiAgent;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiAgentService {

	@Autowired
	private ApiAgentDao apiAgentDao;

    @Transactional(readOnly = true)
	public Page<ApiAgent> list(int pageNumber){
        List<Sort.Order> orderList = new ArrayList<Sort.Order>();
        orderList.add(new Sort.Order(Direction.ASC, "type"));
        orderList.add(new Sort.Order(Direction.ASC, "name"));
		PageRequest pageRequest = new PageRequest(pageNumber-1, APIConstant.PAGE_SIZE, new Sort(orderList));
		Page<ApiAgent> page =  apiAgentDao.findByStatusNot(APIConstant.STATUS.删除.name(),pageRequest);
		return page;
	}

    @Transactional(readOnly = true)
	public ApiAgent get(Long id) {
		return apiAgentDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void save(ApiAgent entity) {
		entity.setUpdateTime(new DateTime());
		apiAgentDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		ApiAgent apiAgent = get(id);
		apiAgent.setStatus(APIConstant.STATUS.删除.name());
		this.save(apiAgent);
	}


    public Integer getSum() {
       return apiAgentDao.findByStatusNot(APIConstant.STATUS.删除.name()).size();
    }
}
