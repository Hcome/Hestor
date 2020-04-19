package com.heshouyang.springboot.Modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heshouyang.springboot.Modules.account.service.UserService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 127.0.0.1:8088/account/login
	 */
	@RequestMapping("/login")
	public String loginPage() {
		return "indexSimple";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		userService.logout();
		return "redirect:/account/login";
	}
	
	/**
	 * 127.0.0.1:8088/account/dashboard
	 */
	@RequestMapping("/dashboard")
	public String dashboardPage() {
		return "index";
	}
	
	/**
	 * 127.0.0.1:8088/account/users
	 */
	@RequestMapping("/users")
	public String usersPage() {
		return "index";
	}
	
	/**
	 * 127.0.0.1:8088/account/roles
	 */
	@RequestMapping("/roles")
	public String rolesPage() {
		return "index";
	}
	
	/**
	 * 127.0.0.1:8088/account/resources
	 */
	@RequestMapping("/resources")
	public String resourcesPage() {
		return "index";
	}

}
