package com.dyaod.sys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.util.StringUtils;

public class ComcatFilter  implements Filter {
	private FilterConfig fc;

	/**
	 * 设置Filter在web.xml中定义的所有参数到Response.
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,ServletException {
		
         HttpServletRequest httpReq = (HttpServletRequest)req;
		
         HttpSession session =  httpReq.getSession();
         
         String current = httpReq.getParameter("current");
         
         if(StringUtils.hasText(current))
         {
        	 session.setAttribute("current", current);
         }

		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) {
		this.fc = filterConfig;
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
}
