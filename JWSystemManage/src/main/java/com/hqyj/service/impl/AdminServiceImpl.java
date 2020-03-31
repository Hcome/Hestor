package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.AdminMapper;
import com.hqyj.entity.Admin;
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

}
