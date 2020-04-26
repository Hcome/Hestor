package com.heshouyang.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.heshouyang.dao.RoleMapper;
import com.heshouyang.entity.Role;
import com.heshouyang.service.RoleService;

public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper rm;
	
	@Override
	public List<Role> selectRoles() {
		//获取session里面的userName
		Subject subject = SecurityUtils.getSubject();
		String userName = (String) subject.getSession().getAttribute("userName");
		return rm.selectRoles(userName);
	}

}
