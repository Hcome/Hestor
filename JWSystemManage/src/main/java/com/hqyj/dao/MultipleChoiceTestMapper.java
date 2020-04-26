package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.MultipleChoiceTest;

public interface MultipleChoiceTestMapper {

	/**
	 * 查询试题
	 * @param id
	 * @return
	 */
	List<MultipleChoiceTest> selectTestById();
	/**
	 * 添加选择题
	 * @param test
	 * @return
	 */
	int insertMultipleChoiceTest(MultipleChoiceTest test);
}
