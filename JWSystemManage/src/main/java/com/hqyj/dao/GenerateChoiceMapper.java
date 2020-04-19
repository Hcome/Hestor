package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.GenerateChoice;

/**
 * 存储学生提交试卷的选择题部分
 * @author Administrator
 *
 */
public interface GenerateChoiceMapper {

	List<GenerateChoice> selectChoiceAll();
	
	/**
	 * 学生的选择题完成之后的记录
	 * @param choice
	 * @return
	 */
	int insertChoice(GenerateChoice choice);
}
