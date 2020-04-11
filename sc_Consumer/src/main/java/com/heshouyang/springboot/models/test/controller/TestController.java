package com.heshouyang.springboot.models.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	private RestTemplate restDesc;
	
	@RequestMapping("/consumerDesc")
	public String consumerDesc() {
		return restDesc.getForObject("http://PRODUCT/api/testDesc", String.class)+"++++++++++++";
	}
}
