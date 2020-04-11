package com.heshouyang.springboot.models.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

	// http://localhost:8083/api/testDesc
	@RequestMapping("/testDesc")
	public String scDesc() {
		return "Spring cloud desc.";
	}
}
