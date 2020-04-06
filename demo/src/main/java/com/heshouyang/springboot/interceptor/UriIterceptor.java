package com.heshouyang.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 添加拦截器，并注入bean
 * @author Administrator
 *
 */
@Component
public class UriIterceptor implements HandlerInterceptor{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UriIterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.debug("pro Handle interceptor");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//getServletPath是获取所有资源的路径包括静态资源，通过判断他为空的时候去获取我们的页面的路径，封装我们的
		//路径，来返回我们的前端页面给获取它的body的值，管理碎片化的页面。
		
		//modelAndView.getViewName():获取返回页面的值
		if (modelAndView == null || modelAndView.getViewName().startsWith("redirect:")) {
			return;
		}
		LOGGER.debug("post Handle interceptor");
		String uri = request.getServletPath();
		
		//获取modelAndView,StringUtils是一个工具包，判断字符串是否为空或者为空字符串。
		if (StringUtils.isNotBlank(uri)) {
			if (uri.startsWith("/")) {
				uri = uri.substring(1);
			}
		}
		ModelMap modelMap = modelAndView.getModelMap();
		String tenplate = (String) modelMap.get("template");
		if (StringUtils.isBlank(tenplate)) {
			modelAndView.getModelMap().addAttribute("template",uri.toLowerCase());
		}
		
		LOGGER.debug("+++++++++++++++++++++++"+uri);
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOGGER.debug("after Handle interceptor");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
