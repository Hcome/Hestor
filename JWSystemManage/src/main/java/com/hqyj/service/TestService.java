package com.hqyj.service;

import java.util.List;

import com.hqyj.entity.MultipleChoiceTest;

public interface TestService {

	
	List<MultipleChoiceTest> selectTestById();
	
	int insertChoiceTest(MultipleChoiceTest test);
}
