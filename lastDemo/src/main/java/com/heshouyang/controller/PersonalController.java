package com.heshouyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.heshouyang.entity.Personal;
import com.heshouyang.service.PersonalService;
import com.heshouynag.model.vo.SearchInfo;

@Controller
@RequestMapping("/personal")
public class PersonalController {

	@Autowired
	private PersonalService ps;
	
	@RequestMapping("/all")
	@ResponseBody
	public PageInfo<Personal> findAllPersnal(SearchInfo searchInfo) {
		PageInfo<Personal> info = ps.selectPersonalAll(searchInfo.getCurrentPage(), searchInfo.getPageSize());
		return info;
		
	}
}
