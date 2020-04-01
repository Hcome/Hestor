package com.heshouyang.springboot.Modules.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heshouyang.springboot.Modules.test.vo.configBean;

@Controller
@RequestMapping("/first")
public class ControllerTest {
	
	//在程序当中定义我们所自定义的logback，使其输出
	private final static Logger LOGGER = LoggerFactory.getLogger(ControllerTest.class); 
	
	@Value("${server.port}")
	private int port;
	@Value("${com.heshouyang.name}")
	private String name;
	@Value("${com.heshouyang.age}")
	private int age;
	@Value("${com.heshouyang.desc}")
	private String desc;
	@Value("${com.heshouyang.random}")
	private String random;
	
	@Autowired
	private configBean configBean;
	
	@RequestMapping("/logTest")
	@ResponseBody
	private String logTest() {
		LOGGER.trace("This is trace log");
		LOGGER.debug("This is debug log");
		LOGGER.info("This is info log");
		LOGGER.warn("This is warn log");
		LOGGER.error("This is error log");
		
		return "This is logTest Demo";
	}
	
	@RequestMapping("/config")
	@ResponseBody
	public String configTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("--")
			.append(name).append("--")
			.append(age).append("--")
			.append(desc).append("--")
			.append(random).append("</br>");
		sb.append(configBean.getName()).append("--")
			.append(configBean.getAge()).append("--")
			.append(configBean.getDesc()).append("--")
			.append(configBean.getRandom()).append("</br>");
		return sb.toString();
	}
	
	public void name() {
		
	}
	@RequestMapping("/goTest")
	@ResponseBody
	private String testGo() {
		
		return "spring Boot";
	}
}
