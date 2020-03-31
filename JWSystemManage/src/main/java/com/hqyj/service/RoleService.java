package com.hqyj.service;

import java.util.List;

import com.hqyj.entity.Role;

public interface RoleService {
	Role selectRoleById(Integer rid);

	List<Role> selectRoleAll();
}
