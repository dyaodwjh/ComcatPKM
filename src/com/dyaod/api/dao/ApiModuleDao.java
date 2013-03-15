package com.dyaod.api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dyaod.api.entity.ApiModule;

public interface ApiModuleDao extends PagingAndSortingRepository<ApiModule, Long> {
	
}
