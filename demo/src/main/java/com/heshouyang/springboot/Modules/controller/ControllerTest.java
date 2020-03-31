package com.heshouyang.springboot.Modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerTest {
	
	@RequestMapping("/first/goBoot")
	@ResponseBody
	public String test() {
		return "第一次启动Spring boot";
	}
}
