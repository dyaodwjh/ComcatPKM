package com.dyaod.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dyaod.sys.entity.User;
import com.dyaod.sys.service.AccountService;
import com.dyaod.sys.service.ShiroDbRealm.ShiroUser;

public abstract class BaseController {
	

	@Autowired
	private AccountService accountService;
	
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	protected Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}


	protected User getCurrentUser() {
		
		User user = accountService.getUser(getCurrentUserId());
		return user;
	}
	
	
}
