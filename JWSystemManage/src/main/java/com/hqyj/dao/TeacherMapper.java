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
	 /**
     * 根据id删除老师
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer teacherId);
    /**
     *根据id查询老师
     * @param teacherId
     * @return
     */
    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);
    /**
     * 更新老师信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Teacher record);
}