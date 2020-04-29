package com.heshouyang.dao;

import com.heshouyang.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer tMenuid);

    Menu selectByPrimaryKey(Integer tMenuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}