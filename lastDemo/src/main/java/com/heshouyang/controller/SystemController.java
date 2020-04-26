package com.heshouyang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heshouyang.service.UserService;

@Controller
@RequestMapping("/sys")
public class SystemController {
	
	@Autowired
	private UserService us;

	@RequestMapping("/gologin.do")
	public String goLogin() {
		return "login";
	}
	
	@RequestMapping("/login.ajax")
	@ResponseBody
	public String login(String userName,String passWord,String checkbox,HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println(userName+" "+passWord+" "+checkbox);
		String info = us.checkLogin(userName,passWord,checkbox, request, response);
		return info;
	}
	/**
	 * 获取cookie里面的值
	 * @return
	 */
	@RequestMapping("/getCookies.ajax")
	@ResponseBody
	public String getCookies(HttpServletRequest request,HttpServletResponse response) {
		String info = us.getCookies(request,response);
		return info;
		
	}
	@RequestMapping("/index.ajax")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/exitLogin.do")
	public String loginOut() {
		//得到当前对象
		Subject subject = SecurityUtils.getSubject();
		//将令牌里面的对象清除
		subject.logout();
		return "login";
		
	}
	@RequestMapping("/welcome.ajax")
	public String welcome() {
		return "redirect:../index/welcome.jsp";
	}
}
