package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.RoleMapper;
import com.hqyj.entity.Role;
import com.hqyj.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper rm;

	@Override
	public Role selectRoleById(Integer rid) {

		return rm.selectByPrimaryKey(rid);
	}

	@Override
	public List<Role> selectRoleAll() {

		return rm.selecRoleAll();
	}

}
