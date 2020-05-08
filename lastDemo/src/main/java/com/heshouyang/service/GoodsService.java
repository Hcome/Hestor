package com.heshouyang.service;

import java.util.HashSet;
import java.util.List;

import com.heshouyang.entity.Goods;

public interface GoodsService {

	HashSet<Goods> queryGoodsName();
	
	List<Goods> queryGoods();
}
