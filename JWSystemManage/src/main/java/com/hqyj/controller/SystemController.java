package com.hqyj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.entity.Role;
import com.hqyj.entity.User;
import com.hqyj.model.vo.Result;
import com.hqyj.service.UserService;

@Controller
@RequestMapping("/sys")
public class SystemController {
	@Autowired
	private UserService us;

	@RequestMapping("/gologin")
	public String gologin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Result login(@RequestBody User user,HttpServletRequest request) {
		//将用户名存入session中
		HttpSession session = request.getSession();
		session.setAttribute("userName", user.getUserName());
		User user2 = us.selectUserByUserByName(user.getUserName());
		List<Role> roles = user2.getRoles();
		session.setAttribute("roles", roles);
		System.out.println(user);
		Result result = us.login(user);
		return result;
	}

	@RequestMapping("/loginOut")
	public String loginOut() {
		SecurityUtils.getSubject().logout();
		return "login";
	}

	@RequestMapping("/index")
	public String goIndex() {
		return "index";
	}

	@RequestMapping("/goregister")
	public String goRegister() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Result register(@RequestBody User user) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&"+user.getUserId());
		return us.registerUser(user);
	}

	@RequestMapping("/error")
	public String goError() {
		return "error";
	}
	/**
	 * 查询用户的全部信息
	 * @return
	 */
	@RequestMapping("/goQueryUserIsAdminInfo")
	public String queryUserIsAdmin(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("userName");
		User user = us.selectUserByUserByName(userName);
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			if ("admin".equals(role.getRoleName())) {
				User admin = us.selectUserIsAdminAllInfo(userName);
				//由于一个用户可能有多个角色，所以将多个角色放入List集合当中去
				List<Role> list = admin.getRoles();
				request.getSession().setAttribute("list", list);
				
				request.getSession().setAttribute("adminUser", admin);
				return "selectAdmin";
			}else if ("teacher".equals(role.getRoleName())) {
				User teacher = us.selectUserIsTeacherAllInfo(userName);
				//由于一个用户可能有多个角色，所以将多个角色放入List集合当中去
				List<Role> list = teacher.getRoles();
				request.getSession().setAttribute("list", list);
				
				request.getSession().setAttribute("teacherUser", teacher);
				return "selectStudent";
			}else if ("student".equals(role.getRoleName())) {
				User student = us.selectUserIsStudentAllInfo(userName);
				//由于一个用户可能有多个角色，所以将多个角色放入List集合当中去
				List<Role> list = student.getRoles();
				request.getSession().setAttribute("list", list);
				
				request.getSession().setAttribute("studentUser", student);
				return "selectStudent";
			}
			//判断这个user是否存在有多个身份
			else if ("admin".equals(role.getRoleName())&&"teacher".equals(role.getRoleName())) {
				User adminAndTeacher = us.selectUserIsAdminAllInfo(userName);
				//由于一个用户可能有多个角色，所以将多个角色放入List集合当中去
				List<Role> list = adminAndTeacher.getRoles();
				request.getSession().setAttribute("list", list);
				
				request.getSession().setAttribute("adminAndTeacher", adminAndTeacher);
				return "selectAdminAndTeacher";
			}
		}
		return null;
	}
}
