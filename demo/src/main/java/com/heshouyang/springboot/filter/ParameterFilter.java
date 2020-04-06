package com.heshouyang.springboot.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "ParmeterFilter",urlPatterns = "/**")
public class ParameterFilter implements Filter{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ParameterFilter.class);
	/**
	 * 过滤器不能获取其中的注入Bean
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.debug("过滤器初始化！！！！！！！！！！！");
		Filter.super.init(filterConfig);
	}

	//过滤器
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//将父类型强转成子类型
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		/*
		 * Map<String, String[]> map = httpServletRequest.getParameterMap();
		 * map.put("testKey", new String[] {"*****"});
		 */
		
		HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(httpServletRequest) {
			@Override
			public String getParameter(String name) {
				String value = httpServletRequest.getParameter(name);
				if (value != null || value != "") {
					return value.replace("fuck", "******");
				}
				return super.getParameter(name);
			}
			//通过注解的方式去获取参数实现此方法获取参数的所有的值
			@Override
			public String[] getParameterValues(String name) {
				String[] values = httpServletRequest.getParameterValues(name);
				if (values != null || values.length > 0) {
					for (int i = 0; i < values.length; i++) {
						values[i] = values[i].replace("fuck", "****");
					}
				}
				return super.getParameterValues(name);
			}
		};
		chain.doFilter(httpServletRequestWrapper, response);
	}
}
