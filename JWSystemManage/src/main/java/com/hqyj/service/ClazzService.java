package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Clazz;

public interface ClazzService {

	PageInfo<Clazz> selectClazzAll(int pageNum);
	/**
	 * 查询全部的学生成绩
	 * @param pageNum
	 * @return
	 */
	PageInfo<Clazz> queryStudentScoreAll(int pageNum);

}
