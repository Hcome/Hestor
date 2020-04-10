package com.hqyj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Teacher;
import com.hqyj.model.vo.Result;
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
	@RequestMapping("/selectTeacherById")
	public String selectTeacherById(Integer teacherId,HttpServletRequest request) {
		Teacher teacher = ts.selectByPrimaryKey(teacherId);
		request.getSession().setAttribute("teacher", teacher);
		return "updateTeacher";
	}
	
	@RequestMapping(value = "/updateByPrimaryKey")
	public String updateByPrimaryKey(Teacher teacher,HttpServletRequest request) {
		Teacher teacher2 = (Teacher) request.getSession().getAttribute("teacher");
		teacher.setTeacherId(teacher2.getTeacherId());
		int num = ts.updateByPrimaryKey(teacher);
		System.out.println(num+"受影响的行数");
		return "teacherList";
		
	}
	@RequestMapping(value = "/deleteByPrimaryKey")
	@ResponseBody
	public Result deleteByPrimaryKey(Teacher teacher) {
		Result result = ts.deleteByPrimaryKey(teacher.getTeacherId());
		return result;	
	}
}
