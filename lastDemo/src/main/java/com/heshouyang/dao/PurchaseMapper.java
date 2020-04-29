package com.heshouyang.dao;

import com.heshouyang.entity.Purchase;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Integer purchaseId);

    Purchase selectByPrimaryKey(Integer purchaseId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}