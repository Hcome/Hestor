package com.hqyj.erp.modules.authority.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.authority.entity.Resource;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;

/**
 * Authority Service
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public interface AuthorityService {

	List<Role> getRoles();
	
	Result insertOrUpdateRole(Role role);
	
	Role getRoleById(int roleId);
	
	Result deleteRole(int roleId);
	
	List<Resource> getResourcesByRoleId(int roleId);
	
	PageInfo<Resource> getResource(SearchVo resarchVo);
	
	Resource getResourceById(int resourceId);
	
	Result insertOrUpdateResource(Resource resource);
	
	Result deleteResource(int resourceId);
	
	List<Role> getRolesByUserId(int userId);
}
