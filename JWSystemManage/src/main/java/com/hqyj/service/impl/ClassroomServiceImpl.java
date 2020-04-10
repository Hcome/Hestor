package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.ClassroomMapper;
import com.hqyj.entity.ClassRoom;
import com.hqyj.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService{
	
	@Autowired
	private ClassroomMapper cm;

	@Override
	public PageInfo<ClassRoom> queryClassRoomAll(int pageNum) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum,3);
		List<ClassRoom> list = cm.queryClassRoomAll();
		PageInfo< ClassRoom> info = new PageInfo<ClassRoom>(list);
		return info;
	}

}
