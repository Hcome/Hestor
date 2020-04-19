package com.hqyj.service;

import java.util.HashSet;

import com.hqyj.entity.ArticleTest;

public interface ArticleTestService {

	HashSet<ArticleTest> selectArticleTest();
	
	int insertArticleTest(ArticleTest test);
}
