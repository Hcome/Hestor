package com.heshouyang.dao;

import java.util.HashSet;
import java.util.List;

import com.heshouyang.entity.Goods;

public interface GoodsMapper {
	/**
	 * 查询全部的商品的名字实现二级联动
	 * @return
	 */
	HashSet<Goods> queryGoodsName();
	/**
	 * 查询全部商品的对象
	 * @return
	 */
	List<Goods> queryGoods();
	
    int deleteByPrimaryKey(Integer goodsId);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}