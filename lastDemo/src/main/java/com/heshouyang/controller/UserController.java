package com.heshouyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heshouyang.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	
	@RequestMapping(value = "/userLists.do")
	public String goUserList() {
		
		return "userList";
		
	}
}
