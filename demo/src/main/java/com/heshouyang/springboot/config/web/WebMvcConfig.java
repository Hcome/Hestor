package com.heshouyang.springboot.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.heshouyang.springboot.filter.ParameterFilter;
import com.heshouyang.springboot.interceptor.UriIterceptor;
/**
 * 将过滤器设置为系统的一个Bean
 * @author Administrator
 *
 */
@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private UriIterceptor uri;
	
	//注册的拦截器的方法
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//添加拦截器的路径
		registry.addInterceptor(uri).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Bean
	public FilterRegistrationBean<ParameterFilter> filterRegistr() {
		FilterRegistrationBean<ParameterFilter> filterRegistrationBean = new FilterRegistrationBean<ParameterFilter>();
		filterRegistrationBean.setFilter(new ParameterFilter());
		return filterRegistrationBean;
	}
}
