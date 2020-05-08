package com.heshouyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	//@Autowired
	//private UserService us;
	
	@RequestMapping(value = "/userLists.do")
	public String goUserList() {
		return "userManager/userList";
	}
}
