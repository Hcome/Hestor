package com.hqyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Teacher;
import com.hqyj.model.vo.SearchInfo;
import com.hqyj.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService ts;
	
	@RequestMapping(value="/goQueryTeacher")
	public String goQueryTeacher() {
		
		return "teacherList";
	}
	//实现老师分页
	@RequestMapping(value="/queryTeacher")
	@ResponseBody
	public PageInfo<Teacher> queryTeacher(SearchInfo searchInfo) {
		
		PageInfo<Teacher> info = ts.selectTeacherAll(searchInfo.getCurrentPage());
		return info;
		
	}

}
