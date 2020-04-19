package com.hqyj.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.FillBlanksTestMapper;
import com.hqyj.entity.FillBlanksTest;
import com.hqyj.service.FillBlanksTestService;


@Service
public class FillBlanksTestServiceImpl implements FillBlanksTestService{
	
	@Autowired
	private FillBlanksTestMapper ftm;

	@Override
	public HashSet<FillBlanksTest> selectFillBlanksTestAll() {
		HashSet<FillBlanksTest> set = ftm.selectFillBlanksTestAll();
		return set;
	}

	@Override
	public int insertFillBlanksTest(FillBlanksTest test) {
		int num = ftm.insertFillBlanksTest(test);
		return num;
	}

}
