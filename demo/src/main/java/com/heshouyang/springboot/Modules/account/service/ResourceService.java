package com.heshouyang.springboot.Modules.account.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.account.entity.Resource;
import com.heshouyang.springboot.Modules.common.vo.Result;
import com.heshouyang.springboot.Modules.common.vo.SearchVo;


public interface ResourceService {

	Result editResource(Resource resource);
	
	Result deleteResource(int resourceId);
	
	PageInfo<Resource> getResources(SearchVo searchVo);
	
	List<Resource> getResourcesByRoleId(int roleId);
	
	Resource getResourceById(int resourceId);
}
