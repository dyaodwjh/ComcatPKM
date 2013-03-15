package com.dyaod.api.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dyaod.api.entity.ApiAgent;

import java.util.List;

public interface ApiAgentDao extends PagingAndSortingRepository<ApiAgent, Long> {
	
	Page<ApiAgent> findByStatusNot(String status, Pageable pageRequest);
    List<ApiAgent> findByStatusNot(String name);
    
}
