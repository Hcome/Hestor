package com.hqyj.service;

import java.util.HashSet;
import com.hqyj.entity.MultipleChoiceTest;

public interface TestService {

	
	HashSet<MultipleChoiceTest> selectTestById();
	
	int insertChoiceTest(MultipleChoiceTest test);
}
