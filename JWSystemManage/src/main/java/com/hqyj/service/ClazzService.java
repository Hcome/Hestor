package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Clazz;

public interface ClazzService {

	PageInfo<Clazz> selectClazzAll(int pageNum);
	

}
