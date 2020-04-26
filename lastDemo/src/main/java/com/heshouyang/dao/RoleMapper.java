package com.heshouyang.dao;

import java.util.List;

import com.heshouyang.entity.Role;

public interface RoleMapper {
	
	/**
	 * 通过用户名查询角色
	 */
	List<Role> selectRoles(String userName);

}
