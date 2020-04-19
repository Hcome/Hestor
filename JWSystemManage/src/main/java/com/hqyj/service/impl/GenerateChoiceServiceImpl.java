package com.hqyj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.GenerateChoiceMapper;
import com.hqyj.entity.GenerateChoice;
import com.hqyj.service.GenerateChoiceService;

@Service
public class GenerateChoiceServiceImpl implements GenerateChoiceService{
	
	@Autowired
	private GenerateChoiceMapper gcm;
	
	@Override
	public int insertChoice(GenerateChoice choice) {
		int num = gcm.insertChoice(choice);
		return num;
	}

}
