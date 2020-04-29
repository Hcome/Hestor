package com.hqyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Clazz;
import com.hqyj.model.vo.SearchInfo;
import com.hqyj.service.ClazzService;

@Controller
@RequestMapping("/clazz")
public class ClazzController {
	
	@Autowired
	private ClazzService cs;
	
	@RequestMapping(value = "/goQueryClazzAll")
	public String goQueryClazzAll() {
		return "clazzList";
	}
	
	@RequestMapping(value = "/queryClazzAll")
	@ResponseBody
	public PageInfo<Clazz> queryClazzAll(SearchInfo searchInfo) {
		PageInfo<Clazz> clazzAll = cs.selectClazzAll(searchInfo.getCurrentPage());
		return clazzAll;
	}
}
