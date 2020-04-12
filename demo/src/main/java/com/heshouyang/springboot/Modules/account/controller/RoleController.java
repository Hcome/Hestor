package com.heshouyang.springboot.Modules.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.account.entity.Role;
import com.heshouyang.springboot.Modules.account.service.RoleService;
import com.heshouyang.springboot.Modules.common.vo.Result;
import com.heshouyang.springboot.Modules.common.vo.SearchVo;


@RestController
@RequestMapping("/api")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@PostMapping(value = "/roles", consumes = "application/json")
	public PageInfo<Role> getRoles(@RequestBody SearchVo searchVo) {
		return roleService.getRoles(searchVo);
	}
	
	@PostMapping(value = "/role", consumes = "application/json")
	public Result editRole(@RequestBody Role role) {
		return roleService.editRole(role);
	}
	
	@RequestMapping("/role/{roleId}")
	public Role getRole(@PathVariable int roleId) {
		return roleService.getRoleById(roleId);
	}
	
	@DeleteMapping("/role/{roleId}")
	public Result deletRole(@PathVariable int roleId) {
		return roleService.deleteRole(roleId);
	}
	
	@RequestMapping("/roles")
	public List<Role> getRoles() {
		return roleService.getRoles();
	}
}
