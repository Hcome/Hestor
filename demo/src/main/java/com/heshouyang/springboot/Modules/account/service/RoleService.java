package com.heshouyang.springboot.Modules.account.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.account.entity.Role;
import com.heshouyang.springboot.Modules.common.vo.Result;
import com.heshouyang.springboot.Modules.common.vo.SearchVo;


public interface RoleService {

	Result editRole(Role role);
	
	Result deleteRole(int roleId);
	
	PageInfo<Role> getRoles(SearchVo searchVo);
	
	List<Role> getRolesByUserId(int userId);
	
	List<Role> getRolesByResourceId(int resourceId);
	
	Role getRoleById(int roleId);
	
	List<Role> getRoles();
}
