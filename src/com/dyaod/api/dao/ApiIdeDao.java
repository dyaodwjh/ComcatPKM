package com.dyaod.api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dyaod.api.entity.ApiIde;

public interface ApiIdeDao extends PagingAndSortingRepository<ApiIde, Long> {
	
}
