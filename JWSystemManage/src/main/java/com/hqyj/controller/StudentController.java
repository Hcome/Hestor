package com.hqyj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.ClassRoom;
import com.hqyj.entity.Student;
import com.hqyj.model.vo.Result;
import com.hqyj.model.vo.SearchInfo;
import com.hqyj.service.ClassroomService;
import com.hqyj.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService ss;
	@Autowired
	private ClassroomService cs;
	
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
	
	/**
	 * 查询未分配班级的学生
	 */
	@RequestMapping("/gofindNotClassStudent")
	public String gofindNotClassStudent() {
		return "studentList3";
	}
	@RequestMapping("/findNotClassStudent")
	@ResponseBody
	public PageInfo<Student> findNotClassStudent(SearchInfo searchInfo) {
		PageInfo<Student> info = ss.queryStudentsIsNotClass(searchInfo.getCurrentPage());
		return info;	
	}
	
	/**
	 *点击添加按钮，可以进行赋值，并返回班级列表
	 */
	@RequestMapping("/addStudentIntoClass")
	public String addStudentIntoClass(Integer id,HttpServletRequest request) {
		System.out.println(id+"______________________");
		String className = (String) request.getSession().getAttribute("className");
		System.out.println(className+"____________________");
		Student student = ss.selectByPrimaryKey(id);
		student.setFkClassName(className);
		int num = ss.updateStudent(student);
		
		System.out.println("受影响的行数"+num);
		return "studentList2";
	}
	
	@RequestMapping("/goQueryStudentsHasClass")
	public String goQueryStudentsHasClass() {
		return "studentList4";
	}
	@RequestMapping("/queryStudentsHasClass")
	@ResponseBody
	public PageInfo<Student> queryStudentsHasClass(SearchInfo searchInfo) {
		PageInfo<Student> info = ss.queryStudentsHasClass(searchInfo.getCurrentPage());
		return info;
	}
	
	/**
	 * 随机分布考场
	 * 
	 */
	@RequestMapping("/addStudentIntoClassroom")
	public String addStudentIntoClassroom(Integer id) {
		//是用来获取空闲教室的
		List<Integer> list1 = new ArrayList<Integer>();
		Random random = new Random();
		Student student = ss.selectByPrimaryKey(id);
		//获取所有的空教室的id，并存在集合当中
		List<ClassRoom> list = cs.findClassRoomIsNull();
		for (ClassRoom classRoom : list) {
			list1.add(classRoom.getClassRoomId());
		}
		//自动装箱，通过获取指定长度之间的范围，随机获取集合当中的classroomId，长度但是不包括list1.size();
		Integer classroomId = list1.get(random.nextInt(list1.size())+1);
		
		student.setFkClassroomId(classroomId);
		//更新学生表
		int num = ss.updateStudent(student);
		System.out.println("受影响的行数："+num);
		return "studentList4";	
	}
	
	/**
	 * 查询已经分配考场的考生
	 */
	@RequestMapping("/goQueryStudentsByClassroomId")
	public String goQueryStudentsByClassroomId(Integer id,HttpServletRequest request) {
		request.getSession().setAttribute("classroomId", id);
		return "studentList5";	
	}
	@RequestMapping("/queryStudentsByClassroomId")
	@ResponseBody
	public PageInfo<Student> queryStudentsByClassroomId(SearchInfo searchInfo,HttpServletRequest request) {
		Integer id = (Integer) request.getSession().getAttribute("classroomId");
		PageInfo<Student> info = ss.queryStudentsByClassroomId(searchInfo.getCurrentPage(), id);
		return info;
	}
}
