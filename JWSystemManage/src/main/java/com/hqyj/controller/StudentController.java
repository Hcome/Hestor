package com.hqyj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Student;
import com.hqyj.model.vo.Result;
import com.hqyj.model.vo.SearchInfo;
import com.hqyj.service.StudentService;

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
	
	@RequestMapping(value = "/goQueryStudentScoreAll")
	public String goQueryStudentScoreAll() {
		return "scoreList";
	}
	@RequestMapping(value = "/queryStudentScoreAll")
	@ResponseBody
	public PageInfo<Student> queryStudentScoreAll(SearchInfo searchInfo) {
		
		PageInfo<Student> pageInfo = ss.queryStudentScoreAll(searchInfo.getCurrentPage());
		return pageInfo;	
	}
	
	@RequestMapping(value = "/queryStudentById")
	public String queryStudentById(Integer id,HttpServletRequest request) {
		Student student = ss.selectByPrimaryKey(id);
		request.getSession().setAttribute("student", student);
		return "updateStudent";
	}
	@RequestMapping("/updateStudent")
	public String updateStudent(Student student,HttpServletRequest request) {
		
		Student student1 = (Student) request.getSession().getAttribute("student");
		student.setStudentId(student1.getStudentId());
		int updateStudent = ss.updateStudent(student);
		System.out.println("更新记录"+updateStudent);
		return "studentList";
	}
	@RequestMapping("/deleteByPrimaryKey")
	@ResponseBody
	public Result deleteByPrimaryKey(Student student) {
		Result result = ss.deleteByPrimaryKey(student.getStudentId());
		return result;
	}
	
	/**
	 * 查询班级对应的学生
	 */
	@RequestMapping(value="/byClassNameQueryStudent")
	public String byClassNameQueryStudent(String className,HttpServletRequest request) {
		request.getSession().setAttribute("className", className);
		return "studentList2";
	}
	@RequestMapping("/queryClassHasStudents")
	@ResponseBody
	public PageInfo<Student> queryClassHasStudents(SearchInfo searchInfo,HttpServletRequest request) {
		String className = (String) request.getSession().getAttribute("className");
		PageInfo<Student> info = ss.queryClassHasStudents(className, searchInfo.getCurrentPage());
		return info;
	}
}
