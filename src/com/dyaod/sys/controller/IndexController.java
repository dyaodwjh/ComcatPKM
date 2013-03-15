package com.dyaod.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author dyaod
 * 首页控制器
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request){
		request.getSession().setAttribute("current", "0");
		return "index";
	}
}
