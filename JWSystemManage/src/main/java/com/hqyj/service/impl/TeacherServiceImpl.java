package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.TeacherMapper;
import com.hqyj.entity.Teacher;
import com.hqyj.model.vo.Result;
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
	@Override
	public Teacher selectByPrimaryKey(Integer teacherId) {
		Teacher teacher = tm.selectByPrimaryKey(teacherId);
		return teacher;
	}
	@Override
	public int updateByPrimaryKey(Teacher record) {
		int key = tm.updateByPrimaryKey(record);
		System.out.println("受影响的行数"+key);
		return 0;
	}
	@Override
	public Result deleteByPrimaryKey(Integer teacherId) {
		int num = tm.deleteByPrimaryKey(teacherId);
		if (num > 0) {
			return new Result("200", "success");
		}else {
			return new Result("500", "删除失败！");			
		}
	}
}
