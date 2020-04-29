package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.Clazz;

public interface ClazzMapper {
	/**
	 * 查询英语全部教学班级
	 * @return
	 */
	List<Clazz> queryClazzsAll();
	/**
	 * 查询所有班级的所有学生
	 * @return
	 */
	List<Clazz> queryStudents();
	
	
}
