package com.hqyj.erp.modules.account.controller;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.service.OrganizationService;

/**
 * 账户相关控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private AuthorityService authorityService;

	/**
	 * 跳转user list 页面
	 */
	@RequestMapping("/userListPage")
	public String userListPage(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "account/userList";
	}
	
	/**
	 * 根据userId获取user信息
	 */
	@PostMapping(value="/getUserById", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public User getUserById(@ModelAttribute User user) {
		return accountService.getUserById(user.getUserId());
	}
	
	/**
	 * 获取users列表
	 */
	@PostMapping(value="/users", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<User> users(@ModelAttribute SearchVo userSearch) {
		return accountService.getUserList(userSearch);
	}
	
	/**
	 * 跳转edit user页面
	 */
	@RequestMapping("/editUserPage")
	public String editUserPage(@RequestParam int userId, ModelMap modelMap) {
		User user = accountService.getUserById(userId);
		List<Department> departments = Optional.ofNullable(
				organizationService.getDepartments()).orElse(Collections.emptyList());
		int departId = user.getDepartId() == null || user.getDepartId() == 0 ? 
				(departments == null || departments.size() == 0 ? 0 : departments.get(0).getDepartId()) 
				: user.getDepartId();
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("departments", departments);
		modelMap.addAttribute("positions", 
				organizationService.getPositionsByDepartId(departId));
		modelMap.addAttribute("roles", Role.composeRoleList(authorityService.getRoles(), user.getRoles()));
		return "account/userEdit";
	}
	
	/**
	 * 编辑user
	 */
	@PostMapping(value="/editUser",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editUser(@ModelAttribute User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	/**
	 * 跳转add user页面
	 */
	@RequestMapping("/addUserPage")
	public String addUserPage(ModelMap modelMap) {
		List<Department> departments = Optional.ofNullable(
				organizationService.getDepartments()).orElse(Collections.emptyList());
		modelMap.addAttribute("departments", departments);
		if (departments.size() > 0) {
			modelMap.addAttribute("positions", 
					organizationService.getPositionsByDepartId(departments.get(0).getDepartId()));
		}
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "account/userAdd";
	}
	
	/**
	 * 添加user
	 */
	@PostMapping(value="/addUser",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addUser(@ModelAttribute User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	/**
	 * 删除user
	 */
	@PostMapping(value="/deleteUser",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	@RequiresPermissions("deleteUser")
	public Result deleteUser(@ModelAttribute User user) {
		return accountService.deleteUserById(user.getUserId());
	}
	
	/**
	 * 上传文件
	 */
	@PostMapping(value="/upload",consumes="multipart/form-data")
	@ResponseBody
	public Result uploadFile(@RequestParam MultipartFile file) {
		if (file.isEmpty()) {
			return new Result(500, "file is null.");
		}
		
		String destPath = "D:/upload/" + file.getOriginalFilename();
		try {
			File destFile = new File(destPath);
			file.transferTo(destFile);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Upload file fail.");
		}
		
		return new Result(200, "Upload file success.", "/upload/" + file.getOriginalFilename());
	}
}
