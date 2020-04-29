package com.heshouyang.dao;

import java.util.List;

import com.heshouyang.entity.Personal;

public interface PersonalMapper {
	/**
	 * 查询所有的用户个人信息
	 * @return
	 */
	List<Personal> selectPersonalAll();
	
    int deleteByPrimaryKey(Integer personalId);

    Personal selectByPrimaryKey(Integer personalId);

    int updateByPrimaryKeySelective(Personal record);

    int updateByPrimaryKey(Personal record);
}