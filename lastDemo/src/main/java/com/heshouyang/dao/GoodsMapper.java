package com.heshouyang.dao;

import com.heshouyang.entity.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}