package com.hqyj.dao;

import com.hqyj.entity.ExamPaper;

/**
 * 对学生随机生成的试卷进行操作
 * @author Administrator
 *
 */
public interface ExamPaperMapper {

	/**
	 * 添加试卷
	 * @param paper
	 * @return
	 */
	int insertExampaper(ExamPaper paper);
}
