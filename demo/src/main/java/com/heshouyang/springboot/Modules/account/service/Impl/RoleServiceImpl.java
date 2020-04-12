package com.heshouyang.springboot.Modules.account.service.Impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.account.dao.RoleDao;
import com.heshouyang.springboot.Modules.account.entity.Role;
import com.heshouyang.springboot.Modules.account.service.RoleService;
import com.heshouyang.springboot.Modules.common.vo.Result;
import com.heshouyang.springboot.Modules.common.vo.Result.ResultStatus;
import com.heshouyang.springboot.Modules.common.vo.SearchVo;


@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Result editRole(Role role) {
		if (role == null || StringUtils.isBlank(role.getRoleName())) {
			return new Result(ResultStatus.FAILED.status, "Role info is null");
		}
		
		if (role.getRoleId() > 0) {
			roleDao.updateRole(role);
		} else {
			roleDao.addRole(role);
		}
		
		return new Result(ResultStatus.SUCCESS.status, "success", role);
	}

	@Override
	public Result deleteRole(int roleId) {
		Result result = new Result(ResultStatus.SUCCESS.status, "");
		try {
			roleDao.deleteRole(roleId);
		} catch (Exception e) {
			result.setStatus(ResultStatus.FAILED.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PageInfo<Role> getRoles(SearchVo searchVo) {
		searchVo.initSearchVo(searchVo);
		PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
		return new PageInfo(Optional.ofNullable(roleDao.getRoles()).orElse(Collections.emptyList()));
	}

	@Override
	public List<Role> getRolesByUserId(int userId) {
		return roleDao.getRolesByUserId(userId);
	}

	@Override
	public List<Role> getRolesByResourceId(int resourceId) {
		return roleDao.getRolesByResourceId(resourceId);
	}

	@Override
	public Role getRoleById(int roleId) {
		return roleDao.getRoleById(roleId);
	}

	@Override
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}
}
