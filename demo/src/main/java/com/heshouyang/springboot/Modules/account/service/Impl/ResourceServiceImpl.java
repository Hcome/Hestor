package com.heshouyang.springboot.Modules.account.service.Impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.account.dao.ResourceDao;
import com.heshouyang.springboot.Modules.account.dao.RoleResourceDao;
import com.heshouyang.springboot.Modules.account.entity.Resource;
import com.heshouyang.springboot.Modules.account.entity.Role;
import com.heshouyang.springboot.Modules.account.service.ResourceService;
import com.heshouyang.springboot.Modules.common.vo.Result;
import com.heshouyang.springboot.Modules.common.vo.Result.ResultStatus;
import com.heshouyang.springboot.Modules.common.vo.SearchVo;

@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private RoleResourceDao roleResourceDao;

	@Override
	public Result editResource(Resource resource) {
		if (resource == null || StringUtils.isBlank(resource.getResourceUri()) ) {
			return new Result(500, "resource info is null");
		}
		
		// 添加 resource
		if (resource.getResourceId() > 0) {
			resourceDao.updateResource(resource);
		} else {
			resourceDao.addResource(resource);
		}
		
		// 添加 roleResource
		roleResourceDao.deletRoleResourceByResourceId(resource.getResourceId());
		if (resource.getRoles() != null && !resource.getRoles().isEmpty()) {
			for (Role role : resource.getRoles()) {
				roleResourceDao.addRoleResource(role.getRoleId(), resource.getResourceId());
			}
		}
		
		return new Result(200, "success", resource);
	}

	@Override
	public Result deleteResource(int resourceId) {
		Result result = new Result(ResultStatus.SUCCESS.status, "");
		try {
			roleResourceDao.deletRoleResourceByResourceId(resourceId);
			resourceDao.deleteResource(resourceId);
		} catch (Exception e) {
			result.setStatus(ResultStatus.FAILED.status);
			result.setMessage(e.getMessage());
		}
		
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PageInfo<Resource> getResources(SearchVo searchVo) {
		searchVo.initSearchVo(searchVo);
		PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
		return new PageInfo(Optional.ofNullable(resourceDao.getResources()).orElse(Collections.emptyList()));
	}

	@Override
	public List<Resource> getResourcesByRoleId(int roleId) {
		return resourceDao.getResourcesByRoleId(roleId);
	}

	@Override
	public Resource getResourceById(int resourceId) {
		return resourceDao.getResourceById(resourceId);
	}
}
