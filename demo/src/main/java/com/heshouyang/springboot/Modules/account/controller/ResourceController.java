package com.heshouyang.springboot.Modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.account.entity.Resource;
import com.heshouyang.springboot.Modules.account.service.ResourceService;
import com.heshouyang.springboot.Modules.common.vo.Result;
import com.heshouyang.springboot.Modules.common.vo.SearchVo;


@RestController
@RequestMapping("/api")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;

	@PostMapping(value = "/resources", consumes = "application/json")
	public PageInfo<Resource> getResources(@RequestBody SearchVo searchVo) {
		return resourceService.getResources(searchVo);
	}
	
	@PostMapping(value = "/resource", consumes = "application/json")
	public Result editResource(@RequestBody Resource resource) {
		return resourceService.editResource(resource);
	}
	
	@RequestMapping("/resource/{resourceId}")
	public Resource getResourceById(@PathVariable int resourceId) {
		return resourceService.getResourceById(resourceId);
	}
	
	@DeleteMapping("/resource/{resourceId}")
	public Result deleteResource(@PathVariable int resourceId) {
		return resourceService.deleteResource(resourceId);
	}
}
