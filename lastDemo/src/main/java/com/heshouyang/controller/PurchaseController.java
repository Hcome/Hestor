package com.heshouyang.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heshouyang.entity.Goods;
import com.heshouyang.service.GoodsService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private GoodsService gs;

	@RequestMapping("/goUsePurchase.do")
	public String  goUsePurchase() {
		return "purchase/userporchase_list";
	}
	/**
	 * 通过将所有的商品存入Session当中实现前端的二级联动
	 * @param request
	 * @return
	 */
	@RequestMapping("/purchaseThing.do")
	public String purchaseThing(HttpServletRequest request) {
		HashSet<Goods> set = gs.queryGoodsName();
		List<Goods> list = gs.queryGoods();
		request.getSession().setAttribute("set", set);
		request.getSession().setAttribute("list", list);
		return "purchase/porchaseMoney";	
	}
}
