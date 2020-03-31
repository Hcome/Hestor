package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer roleId);

	Role selectByPrimaryKey(Integer roleId);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	Role selectRoleById(Integer roleId);

	List<Role> selecRoleAll();
}