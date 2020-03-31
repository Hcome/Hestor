package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.Teacher;

public interface TeacherMapper {
	/**
	 * 增加老师
	 * @param teacher
	 * @return
	 */
	int insertTeacher(Teacher teacher);
	/**
	 * 查询所有老师老师
	 * @return
	 */
	List<Teacher> queryTeacherAll();
	
    int deleteByPrimaryKey(Integer teacherId);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}