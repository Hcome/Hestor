package com.hqyj.service;

import java.util.List;

import com.hqyj.entity.FillBlanksTest;

public interface FillBlanksTestService {
	
	List<FillBlanksTest> selectFillBlanksTestAll();

	int insertFillBlanksTest(FillBlanksTest test);
}
