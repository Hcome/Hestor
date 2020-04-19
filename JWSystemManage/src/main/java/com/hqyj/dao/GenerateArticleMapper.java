package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.ArticleTest;

/**
 * 存储学生试卷的阅读理解部分
 * @author Administrator
 *
 */
public interface GenerateArticleMapper {

	List<ArticleTest> selectArticleALl();
	/**
	 * 添加阅读题记录
	 * @param test
	 * @return
	 */
	int inserArticle(ArticleTest test);
}
