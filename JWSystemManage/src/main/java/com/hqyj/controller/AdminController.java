package com.hqyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Admin;
import com.hqyj.model.vo.SearchInfo;
import com.hqyj.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	@RequestMapping("/goQueryAdmin")
	public String goQueryAdmin() {
		return "adminList";
		
	}
	@RequestMapping("/queryAdmin")
	@ResponseBody
	public PageInfo<Admin> queryAdmin(SearchInfo searchInfo) {
		PageInfo<Admin> adminAll = as.selectAdminAll(searchInfo.getCurrentPage());
		return adminAll;
	}

}
