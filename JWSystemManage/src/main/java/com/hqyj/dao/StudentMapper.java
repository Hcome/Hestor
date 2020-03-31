package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.Student;

public interface StudentMapper {
	/**
	 * 增加一个学生
	 * @param user
	 * @return
	 */
	int insertStudent(Student student);
	/**
	 * 查询全部学生
	 * @return
	 */
	List<Student> queryStudentAll();

    int deleteByPrimaryKey(Integer studentId);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}