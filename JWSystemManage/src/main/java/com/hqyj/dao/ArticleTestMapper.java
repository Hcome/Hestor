package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.ArticleTest;

public interface ArticleTestMapper {
	/**
	 * 阅读理解四篇
	 * @return
	 */
	List<ArticleTest> selectArticleTest();
	/**
	 * 增加阅读题
	 * @param test
	 * @return
	 */
	int insertArticleTest(ArticleTest test);	
}
