package com.heshouyang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.heshouyang.dao.PersonalMapper;
import com.heshouyang.entity.Personal;
import com.heshouyang.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService{

	@Autowired
	private PersonalMapper pm;
	@Override
	//实现后端分页
	public PageInfo<Personal> selectPersonalAll(int pageNum) {
		@SuppressWarnings("unused")
		//实现后端的分页，避免大量的数据影响查询性能
		PageHelper pageHelper = new PageHelper();
		PageMethod.startPage(pageNum, 3);
		
		List<Personal> list = pm.selectPersonalAll();
		PageInfo<Personal> info = new PageInfo<>(list);
		System.out.println(info);
		return info;
	}
}
