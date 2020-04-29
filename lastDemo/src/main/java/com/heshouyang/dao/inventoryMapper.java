package com.heshouyang.dao;

import com.heshouyang.entity.inventory;

public interface inventoryMapper {
    int deleteByPrimaryKey(Integer inventoryId);

    inventory selectByPrimaryKey(Integer inventoryId);

    int updateByPrimaryKeySelective(inventory record);

    int updateByPrimaryKey(inventory record);
}