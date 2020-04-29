package com.heshouyang.dao;

import com.heshouyang.entity.Seller;

public interface SellerMapper {
    int deleteByPrimaryKey(Integer sellerId);

    Seller selectByPrimaryKey(Integer sellerId);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}