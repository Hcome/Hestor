package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.ClazzMapper;
import com.hqyj.entity.Clazz;
import com.hqyj.service.ClazzService;
@Service
public class ClazzServiceImpl implements ClazzService{
	
	@Autowired
	private ClazzMapper cm;
	
	@Override
	public PageInfo<Clazz> selectClazzAll(int pageNum) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum,3);
		
		List<Clazz> list = cm.queryClazzsAll();
		PageInfo<Clazz> info = new PageInfo<Clazz>(list);
		return info;
	}

}
