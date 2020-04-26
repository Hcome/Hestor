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
	/**
	 * 查询全部学生的成绩
	 * @return
	 */
	List<Student> queryStudentScoreAll();
	
	List<Student> queryStudentAll();
	/**
	 * 通过id删除学生信息
	 * @param studentId
	 * @return
	 */
    int deleteByPrimaryKey(Integer studentId);
    /**
     * 根据Id查询学生信息
     * @param studentId
     * @return
     */
    Student selectByPrimaryKey(Integer studentId);
    
    /**
	 * 通过班级名称去查询学生信息
	 * @param className
	 * @return
	 */
	List<Student> queryClassHasStudents(String className);
	
    int updateByPrimaryKeySelective(Student record);
    /**
     * 更新学生信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Student record);
}