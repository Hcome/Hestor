package com.hqyj.dao;

import com.hqyj.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}