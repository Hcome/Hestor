package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Teacher;
import com.hqyj.model.vo.Result;

public interface TeacherService {
	/**
	 * 增加老师
	 * @param teacher
	 * @return
	 */
	int insertTeacher(Teacher teacher);
	/**
	 * 查询所有的老师
	 * @return
	 */
	PageInfo<Teacher> selectTeacherAll(int pageNum);
	
	Teacher selectByPrimaryKey(Integer teacherId);

	int updateByPrimaryKey(Teacher record);
	
	Result deleteByPrimaryKey(Integer teacherId);
}
