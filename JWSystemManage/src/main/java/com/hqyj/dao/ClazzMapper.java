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
	 * 查询全部学生的成绩
	 * @return
	 */
	List<Clazz> queryStudentScoreAll();

}
