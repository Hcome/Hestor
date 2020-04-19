package com.hqyj.service;

import java.util.HashSet;

import com.hqyj.entity.FillBlanksTest;

public interface FillBlanksTestService {
	
	HashSet<FillBlanksTest> selectFillBlanksTestAll();

	int insertFillBlanksTest(FillBlanksTest test);
}
