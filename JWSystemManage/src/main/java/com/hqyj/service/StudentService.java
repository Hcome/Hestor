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
}
