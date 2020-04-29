package com.heshouyang.dao;

import com.heshouyang.entity.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}