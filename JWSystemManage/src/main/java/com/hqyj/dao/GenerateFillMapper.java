package com.hqyj.dao;
/**
 * 保存学生试卷的填空题部分
 * @author Administrator
 *
 */

import java.util.List;

import com.hqyj.entity.GenerateFill;

public interface GenerateFillMapper {

	List<GenerateFill> selectFillAll();
	/**
	 * 添加学生的填空题记录
	 * @param fill
	 * @return
	 */
	int insertFill(GenerateFill fill);
}
