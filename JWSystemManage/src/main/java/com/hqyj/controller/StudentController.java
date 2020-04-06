package com.hqyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Student;
import com.hqyj.model.vo.SearchInfo;
import com.hqyj.service.StudentService;
import com.hqyj.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService ss;
	
	@RequestMapping(value="/goQueryStudent")
	public String goQueryStudent() {
		
		return "studentList";
	}
	@RequestMapping(value="/queryStudent")
	//作用是修饰返回的对象自动转换成json格式的字符串，因为前端页面是字符串的形式的
	//在实现ssm框架的过程中，我们就先要在controller层将对象转换成json格式的字符串返回至前端页面，
	@ResponseBody
	public PageInfo<Student> queryStudent(SearchInfo searchInfo) {
		System.out.println("当前页是从那一页开始的"+searchInfo.getCurrentPage());
		PageInfo<Student> pageInfo = ss.selectStudentAll(searchInfo.getCurrentPage());
		return pageInfo;
		
	}
	
}
