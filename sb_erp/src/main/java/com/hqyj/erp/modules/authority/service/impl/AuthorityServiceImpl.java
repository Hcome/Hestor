package com.hqyj.erp.modules.authority.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.authority.dao.AuthorityDao;
import com.hqyj.erp.modules.authority.entity.Resource;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.entity.RoleResource;
import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;

/**
 * Authority Service Impl
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityDao authorityDao;

	/* 
	 * 获取角色列表
	 */
	@Override
	public List<Role> getRoles() {
		return authorityDao.getRoles();
	}

	/* 
	 * 插入或更新角色
	 */
	@Override
	public Result insertOrUpdateRole(Role role) {
		Role roleTemp = authorityDao.getRoleByNmae(role.getRoleName());
		if (roleTemp != null && (role.getRoleId() <= 0 || roleTemp.getRoleId() != role.getRoleId())) {
			return new Result(500, "角色已经存在。");
		}
		
		try {
			if (role.getRoleId() > 0) {
				authorityDao.updateRole(role);
			} else {
				authorityDao.insertRole(role);
			}
			return new Result(200, "Insert or Update Role success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Insert or Update Role failed.");
		}
	}

	/* 
	 * 根据id查询角色
	 */
	@Override
	public Role getRoleById(int roleId) {
		return authorityDao.getRoleById(roleId);
	}

	/* 
	 * 删除角色
	 */
	@Override
	public Result deleteRole(int roleId) {
		try {
			authorityDao.deleteRole(roleId);
			return new Result(200, "Delete success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Delete failed.");
		}
	}

	/* 
	 * 根据角色id查询所有资源
	 */
	@Override
	public List<Resource> getResourcesByRoleId(int roleId) {
		return authorityDao.getResourcesByRoleId(roleId);
	}

	/* 
	 * 查询所有资源，封装到page info中
	 */
	@Override
	public PageInfo<Resource> getResource(SearchVo resarchVo) {
		try {
			SearchVo.initSearchVo(resarchVo);
			PageHelper.startPage(resarchVo.getCurrentPage(), resarchVo.getPageSize());
			
			List<Resource> resources = Optional.ofNullable(
					authorityDao.getResources()).orElse(Collections.emptyList());
			return new PageInfo<>(resources);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}

	/* 
	 * 根据资源id查询资源
	 */
	@Override
	public Resource getResourceById(int resourceId) {
		return authorityDao.getResourceById(resourceId);
	}

	/* 
	 * 插入或者更新资源
	 */
	@Override
	@Transactional
	public Result insertOrUpdateResource(Resource resource) {
		Resource resourceTemp = authorityDao.getResourceByName(resource.getResourceName());
		if (resourceTemp != null && 
				(resource.getResourceId() <= 0 || 
				(resource.getResourceId() != resourceTemp.getResourceId()))) {
			return new Result(500, "操作失败。");
		}
		
		try {
			if (resource.getResourceId() > 0) {
				authorityDao.updateResource(resource);
			} else {
				authorityDao.insertResource(resource);
			}
			
			authorityDao.deleteRoleResource(resource.getResourceId());
			List<Role> roles = Optional.ofNullable(resource.getRoles()).orElse(Collections.emptyList());
			for (Role role : roles) {
				authorityDao.insertRoleResource(new RoleResource(role.getRoleId(), resource.getResourceId()));
			}
			return new Result(200, "操作成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "操作失败。");
		}
	}

	/* 
	 * 删除资源
	 */
	@Override
	public Result deleteResource(int resourceId) {
		try {
			authorityDao.deleteResource(resourceId);
			authorityDao.deleteRoleResource(resourceId);
			return new Result(200, "删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "删除失败。");
		}
	}

	/* 
	 * 根据用户id查询角色列表
	 */
	@Override
	public List<Role> getRolesByUserId(int userId) {
		return authorityDao.getRolesByUserId(userId);
	}

}
