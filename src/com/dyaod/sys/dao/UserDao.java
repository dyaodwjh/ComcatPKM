package com.dyaod.sys.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dyaod.sys.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
