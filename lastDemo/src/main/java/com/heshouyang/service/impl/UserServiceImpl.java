package com.heshouyang.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.heshouyang.dao.UserMapper;
import com.heshouyang.entity.User;
import com.heshouyang.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper um;

	public User selectUserById(Integer id) {
	
		return um.selectUserById(id);
	}
	@Override
	public String checkLogin(String userName, String passWord, String checkbox,HttpServletRequest request,
			HttpServletResponse response) {
		//获取当前用户
		Subject subject = SecurityUtils.getSubject();
		//这里有个重点，就是在shiro中它会自动的去屏蔽jsp的session，所以要使用shiro自己提供封装的session
		subject.getSession().setAttribute("userName", userName);
		//创建令牌
		UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
		token.setRememberMe(true);
		try {
			subject.login(token);
			//认证成功之后使用shiro权限里面的cookie去保存我们的账号和密码，实现记住用户名密码的功能
			//判断复选框是否被选中，如果选中，将用户名密码存在cookie当中，用来展示记住密码的功能
			if (checkbox.equals("YES")) {
				//shiro框架中特有的创建cookie的方式
				SimpleCookie cookie = new SimpleCookie();
				SimpleCookie cookie2 = new SimpleCookie();
				
				//设置cookie的key值
				cookie.setName("USERID");
				cookie2.setName("PASSWORD");
				
				//设置cookie的value值,由于保存用户名是不安全的，我们可以通过保存用户的id，通过用户的id去查询用户去查询用户的id
				cookie.setValue(um.selectUserByUserName(userName).getId().toString());
				System.out.println(cookie.getValue());
				
				//此处的设置是为了在浏览器去保存cookie的时候，密码设置为不可见的
				cookie2.setValue(userName+passWord);
				
				//设置浏览器保存cookie的时间
				cookie.setMaxAge(30*24*60*60);
				cookie2.setMaxAge(30*24*60*60);
				//jsp返回给浏览器
				cookie.saveTo(request, response);
				cookie2.saveTo(request, response);
			}else if (checkbox.equals("NO")) {
				System.out.println(checkbox);
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("USERID")) {
							System.out.println(cookie);
							System.out.println(cookie.getPath());
							cookie.setMaxAge(0);
							cookie.setPath("/");
							response.addCookie(cookie);
						}
						if (cookie.getName().equals("PASSWORD")) {
							cookie.setMaxAge(0);
							cookie.setPath("/");
							response.addCookie(cookie);
						}
					}
				}
			}
			System.out.println("认证成功！");
			return "SUCCESS";
		} catch (Exception e) {
			System.out.println("认证失败");
			return "ERROR";
		}
	}

	@Override
	public String getCookies(HttpServletRequest request,HttpServletResponse response) {
		//存放查询出来的用户
		User user = new User();
		//获取前端发送的cookie对象
		Cookie[] cookies = request.getCookies();
		//通过用户的id去查询用户用户名
		if (cookies != null ) {
			for (Cookie cookie : cookies) {
				if ("USERID".equals(cookie.getName())) {
					String oldUserId = cookie.getValue();
					int userId = Integer.parseInt(oldUserId);
					User user1 = um.selectUserById(userId);
					user.setUserName(user1.getUserName());
				}
			}
		}
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("PASSWORD".equals(cookie.getName())) {
					String password = cookie.getValue();
					password = password.substring(user.getUserName().length());
					user.setPassWord(password);
				}
			}	
		}
		//将对象转换成json字符串
		Gson gson = new Gson();
		if (user.getUserName() != null) {
			String userString = gson.toJson(user);
			System.out.println(userString);
			return userString;
		}else {
			String userString = gson.toJson(new User(null, "", ""));
			return userString;
		}
	}
}
