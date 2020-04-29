package com.heshouyang.dao;

import com.heshouyang.entity.Supplier;

public interface SupplierMapper {
    int deleteByPrimaryKey(Integer supplierId);

    Supplier selectByPrimaryKey(Integer supplierId);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}