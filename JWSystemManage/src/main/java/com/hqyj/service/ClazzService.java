package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Clazz;
import com.hqyj.entity.Student;

public interface ClazzService {

	PageInfo<Clazz> selectClazzAll(int pageNum);
	
	
}
