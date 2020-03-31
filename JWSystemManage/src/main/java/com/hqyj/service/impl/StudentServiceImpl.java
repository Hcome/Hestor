package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.StudentMapper;
import com.hqyj.entity.Student;
import com.hqyj.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper sm;

	@Override
	public int insertStudent(Student stu) {
		
		int num = sm.insertStudent(stu);
		System.out.println(num);
		return num;
	}

	@Override
	public PageInfo<Student> selectStudentAll(int pageNum) {
		//创建一个开启分页的对象
		PageHelper helper = new PageHelper();
		//开启分页
		helper.startPage(pageNum,3);
		List<Student> list = sm.queryStudentAll();
		//创建需要分页的对象
		PageInfo<Student> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
