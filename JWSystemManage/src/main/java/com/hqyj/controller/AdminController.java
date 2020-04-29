package com.hqyj.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Admin;
import com.hqyj.model.vo.Result;
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
	
	@RequestMapping(value = "/updateAdmin")
	public String updateAdmin(Admin admin,HttpServletRequest request) {
	     Admin admin2 = (Admin) request.getSession().getAttribute("admin");
	     admin.setAdminId(admin2.getAdminId());
		 int num = as.updateAdmin(admin);
		 return "adminList";
	} 
	
	@RequestMapping(value = "/queryAdminById")
	public String queryAdminById(Integer id,HttpServletRequest request) {
		Admin admin = as.queryAdminById(id);
		request.getSession().setAttribute("admin", admin);
		return "updateAdmin";
	}
	@RequestMapping(value = "/deleteAdminById")
	@ResponseBody
	public Result deleteAdminById(Admin admin) {
		
		return as.deleteAdminById(admin.getAdminId());
		
	}
}
