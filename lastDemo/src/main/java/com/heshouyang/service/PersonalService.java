package com.heshouyang.service;

import com.github.pagehelper.PageInfo;
import com.heshouyang.entity.Personal;

public interface PersonalService {

	PageInfo<Personal> selectPersonalAll(int currentPage);
}
