package com.dyaod.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dyaod.api.entity.ApiAgent;
import com.dyaod.api.service.ApiAgentService;
import com.dyaod.sys.controller.BaseController;


/**
 * @作者: wang.jianhua
 * @创建于: 2012-12-8
 * @概述: 
 */
@Controller
@RequestMapping( "/api/agent")
public class ApiAgentController extends BaseController{

	@Autowired
	private ApiAgentService apiAgentService;

	
	@RequestMapping(value="list")
	public String list(HttpServletRequest request,Model model,@RequestParam(value = "page", defaultValue = "1")int pageNumber){
		
		Page<ApiAgent> page = apiAgentService.list(pageNumber);
		
		model.addAttribute("page", page);
        model.addAttribute("sum", apiAgentService.getSum());
		model.addAttribute("sortType", "name");
		
		return "api/agentlist";
	}
	
	@RequestMapping(value = "view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		model.addAttribute("form", apiAgentService.get(id));
		model.addAttribute("action", "view");
		return "api/agentview";
	}
	
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("form", new ApiAgent());
		model.addAttribute("action", "create");
		return "api/agentedit";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid ApiAgent apiAgent, RedirectAttributes redirectAttributes) {

		apiAgent.setUser(getCurrentUser());

		apiAgentService.save(apiAgent);
		
		redirectAttributes.addFlashAttribute("message", "创建Agent Api 成功");
		
		return "redirect:/api/agent/list.do";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("form", apiAgentService.get(id));
		model.addAttribute("action", "update");
		return "api/agentedit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("preload") ApiAgent apiAgent, RedirectAttributes redirectAttributes) {
		apiAgentService.save(apiAgent);
		redirectAttributes.addFlashAttribute("message", "更新Agent Api成功");
		return "redirect:/api/agent/list.do";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		apiAgentService.delete(id);
		redirectAttributes.addFlashAttribute("message", "删除Agent Api成功");
		return "redirect:/api/agent/list.do";
	}

	/**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
	 */
	@ModelAttribute("preload")
	public ApiAgent get(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return apiAgentService.get(id);
		}
		return null;
	}
	
	

	
}
