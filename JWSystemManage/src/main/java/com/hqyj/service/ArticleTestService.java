package com.hqyj.service;

import java.util.List;

import com.hqyj.entity.ArticleTest;

public interface ArticleTestService {

	List<ArticleTest> selectArticleTest();
	
	int insertArticleTest(ArticleTest test);
}
