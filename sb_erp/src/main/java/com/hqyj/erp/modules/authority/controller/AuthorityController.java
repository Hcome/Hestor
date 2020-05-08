package com.hqyj.erp.modules.authority.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.authority.entity.Resource;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;

/**
 * 授权控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;

	/**
	 * 跳转到角色列表页面
	 */
	@RequestMapping("/roleListPage")
	public String roleListPage(ModelMap modelMap) {
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "authority/roleList";
	}
	
	/**
	 * 跳转到添加角色页面
	 */
	@RequestMapping("/addRolePage")
	public String addRolePage() {
		return "authority/roleAdd";
	}
	
	/**
	 * 添加角色
	 */
	@PostMapping(value="/addRole",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addRole(@ModelAttribute Role role) {
		return authorityService.insertOrUpdateRole(role);
	}
	
	/**
	 * 跳转到编辑角色页面
	 */
	@RequestMapping("/editRolePage")
	public String editRolePage(@RequestParam int roleId, ModelMap modelMap) {
		modelMap.addAttribute("role", authorityService.getRoleById(roleId));
		return "authority/roleEdit";
	}
	
	/**
	 * 编辑角色
	 */
	@PostMapping(value="/editRole",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editRole(@ModelAttribute Role role) {
		return authorityService.insertOrUpdateRole(role);
	}
	
	/**
	 * 删除角色
	 */
	@PostMapping(value="/deleteRole",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteRole(@ModelAttribute Role role) {
		return authorityService.deleteRole(role.getRoleId());
	}
	
	/**
	 * 跳转到资源列表页面
	 */
	@RequestMapping("/resourceListPage")
	public String resourceListPage() {
		return "authority/resourceList";
	}
	
	/**
	 * 根据查询条件获取资源
	 */
	@RequestMapping(value="/resources",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Resource> resources(@ModelAttribute SearchVo searchVo) {
		return authorityService.getResource(searchVo);
	}
	
	/**
	 * 跳转到添加资源页面
	 */
	@RequestMapping("/addResourcePage")
	public String addResourcePage(ModelMap modelMap) {
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "authority/resourceAdd";
	}
	
	/**
	 * 添加资源
	 */
	@PostMapping(value="/addResource",consumes="application/json")
	@ResponseBody
	public Result addResource(@RequestBody Resource resource) {
		return authorityService.insertOrUpdateResource(resource);
	}
	
	/**
	 * 跳转到编辑资源页面
	 */
	@RequestMapping("/editResourcePage")
	public String editResourcePage(@RequestParam int resourceId, ModelMap modelMap) {
		Resource resource = authorityService.getResourceById(resourceId);
		modelMap.addAttribute("resource", resource);
		modelMap.addAttribute("roles", Role.composeRoleList(authorityService.getRoles(), resource.getRoles()));
		return "authority/resourceEdit";
	}
	
	/**
	 * 编辑资源
	 */
	@PostMapping(value="/editResource",consumes="application/json")
	@ResponseBody
	public Result editResource(@RequestBody Resource resource) {
		return authorityService.insertOrUpdateResource(resource);
	}
	
	/**
	 * 删除资源
	 */
	@PostMapping(value="/deleteResource",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteResource(@ModelAttribute Resource resource) {
		return authorityService.deleteResource(resource.getResourceId());
	}
}
