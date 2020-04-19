package com.hqyj.dao;

import java.util.HashSet;

import com.hqyj.entity.FillBlanksTest;

/**
 * 填空题
 * @author Administrator
 *
 */
public interface FillBlanksTestMapper {

	/**
	 * 查询全部的填空题
	 * @return
	 */
	HashSet<FillBlanksTest> selectFillBlanksTestAll();
	/**
	 * 添加填空题
	 * @param test
	 * @return
	 */
	int insertFillBlanksTest(FillBlanksTest test);
}
