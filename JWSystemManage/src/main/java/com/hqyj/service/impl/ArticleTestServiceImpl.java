package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.ArticleTestMapper;
import com.hqyj.entity.ArticleTest;
import com.hqyj.service.ArticleTestService;

@Service
public class ArticleTestServiceImpl implements ArticleTestService{

	@Autowired
	private ArticleTestMapper atm;
	
	@Override
	public List<ArticleTest> selectArticleTest() {
		
		List<ArticleTest> set = atm.selectArticleTest();
		return set;
	}

	@Override
	public int insertArticleTest(ArticleTest test) {
		int num = atm.insertArticleTest(test);
		return num;
	}

}
