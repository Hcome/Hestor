package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Student;
import com.hqyj.model.vo.Result;

public interface StudentService {
	/**
	 * 添加学生信息
	 * @param user
	 * @return
	 */
	int insertStudent(Student student);
	/**使用PageInfo分页插件实现分页
	 * @param pageNum
	 * @return
	 */
	PageInfo<Student> selectStudentAll(int pageNum);
	/**
	 * 查询全部的学生成绩
	 * @param pageNum
	 * @return
	 */
	PageInfo<Student> queryStudentScoreAll(int pageNum);
	
	Student selectByPrimaryKey(Integer id);
	
	int updateStudent(Student student);
	
	Result deleteByPrimaryKey(Integer studentId);
	
	PageInfo<Student>  queryClassHasStudents(String className,Integer pageNum);
	/**
	 * 查询未分配班级的学生
	 * @param pageNum
	 * @return
	 */
	PageInfo<Student> queryStudentsIsNotClass(Integer pageNum);
	
	Integer queryStudentIdByUserName(String userName);
	/**
	 * 查询已经分配教学班班级的学生，给他们分配考场
	 */
	PageInfo<Student> queryStudentsHasClass(int pageNum);
	/**
	 * 查询已经分配考场的所有信息
	 */
	PageInfo<Student> queryStudentsByClassroomId(int pageNum,Integer classroomId);
}
