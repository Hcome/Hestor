package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.MultipleChoiceTestMapper;
import com.hqyj.entity.MultipleChoiceTest;
import com.hqyj.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private MultipleChoiceTestMapper tm;
	
	@Override
	public List<MultipleChoiceTest> selectTestById() {
		List<MultipleChoiceTest> list = tm.selectTestById();
		return list;
	}

	@Override
	public int insertChoiceTest(MultipleChoiceTest test) {
		int num = tm.insertMultipleChoiceTest(test);
		return num;
	}

}
