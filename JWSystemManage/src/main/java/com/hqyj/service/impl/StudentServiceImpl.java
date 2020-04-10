package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.StudentMapper;
import com.hqyj.entity.Clazz;
import com.hqyj.entity.Student;
import com.hqyj.model.vo.Result;
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

	@Override
	public PageInfo<Student> queryStudentScoreAll(int pageNum) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum,3);
		List<Student> list = sm.queryStudentScoreAll();
		PageInfo<Student> info = new PageInfo<Student>(list);
		return info;
	}

	@Override
	public Student selectByPrimaryKey(Integer id) {
		Student student = sm.selectByPrimaryKey(id);
		return student;
	}

	@Override
	public int updateStudent(Student student) {
		int num = sm.updateByPrimaryKey(student);
		System.out.println("受影响的行数"+num);
		return num;
	}

	@Override
	public Result deleteByPrimaryKey(Integer studentId) {
		
		int num = sm.deleteByPrimaryKey(studentId);
		if (num > 0) {
			return new Result("200", "success");
		}else {
			return new Result("500", "删除失败");
		}
	}
}
