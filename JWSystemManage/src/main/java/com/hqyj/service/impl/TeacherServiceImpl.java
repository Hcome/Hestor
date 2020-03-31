package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.TeacherMapper;
import com.hqyj.entity.Teacher;
import com.hqyj.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherMapper tm;
	/**
	 * 新增老师
	 */
	@Override
	public int insertTeacher(Teacher teacher) {
		
		return tm.insertTeacher(teacher);
	}
	/**
	 * 查询所有老师
	 */
	@Override
	public PageInfo<Teacher> selectTeacherAll(int pageNum) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum,3);
		List<Teacher> teachers = tm.queryTeacherAll();
		PageInfo<Teacher> info = new PageInfo<>(teachers);
		return info;
	}

}
