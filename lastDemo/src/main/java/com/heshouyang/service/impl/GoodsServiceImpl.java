package com.heshouyang.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heshouyang.dao.GoodsMapper;
import com.heshouyang.entity.Goods;
import com.heshouyang.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper gm;
	@Override
	public HashSet<Goods> queryGoodsName() {
		HashSet<Goods> set = gm.queryGoodsName();
		//查询集合中长度减一的位置然后去除重复的
		/*
		 * for (int i = 0; i < list.size()-1; i++) { for (int j = 0; j < list.size()-i;
		 * j++) { if (list.get(i) != null &&
		 * StringUtils.isNotEmpty(list.get(i).getGoodsName())) { if
		 * (list.get(i).getGoodsName().equals(list.get(j).getGoodsName())) {
		 * list.get(i).setGoodsName(null); } } } } System.out.println(list.toString());
		 */
		return set;
	}
	@Override
	public List<Goods> queryGoods() {
		List<Goods> list = gm.queryGoods();
		return list;
	}
}
