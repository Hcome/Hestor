package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.AdminMapper;
import com.hqyj.entity.Admin;
import com.hqyj.model.vo.Result;
import com.hqyj.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper am;
	@Override
	public int insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return am.insertAdmin(admin);
	}
	@Override
	public PageInfo<Admin> selectAdminAll(int pageNum) {
		
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum,3);
		List<Admin> admins = am.queryAdminAll();
		PageInfo<Admin> pageInfo = new PageInfo<>(admins);
		return pageInfo;
	}
	@Override
	public int updateAdmin(Admin admin) {
		int num = am.updateAdmin(admin);
		System.out.println("修改成功"+num);
		return num;
	}
	@Override
	public Admin queryAdminById(Integer id) {
		Admin admin = am.queryAdminById(id);
		return admin;
	}
	@Override
	public Result deleteAdminById(Integer id) {
		int num = am.deleteAdminById(id);
		if (num > 0) {
			return new Result("200", "success");
		}else {
			return new Result("500", "删除失败");
		}	
	}
	
}
