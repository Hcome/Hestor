package com.heshouyang.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heshouyang.entity.User;

public interface UserService {

	User selectUserById(Integer id);

	String checkLogin(String userName, String passWord, String checkbox,HttpServletRequest request,
			HttpServletResponse response);

	String getCookies(HttpServletRequest request,HttpServletResponse response);
	
	
}
