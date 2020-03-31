package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Teacher;

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

}
