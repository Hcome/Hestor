package com.hqyj.erp.config.web;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web Mvc Config
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer {

	/* 
	 * 上传图片回显，文件上传到本地硬盘，需要将本地硬盘路径指定为相对的source文件夹，这样页面才能直接引用相对路劲展示图片
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/upload/");
	}

}
