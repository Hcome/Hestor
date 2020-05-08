package com.hqyj.erp.modules.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.entity.Position;
import com.hqyj.erp.modules.organization.service.OrganizationService;
import com.hqyj.erp.modules.organization.vo.ZtreeModel;

/**
 * 公司组织控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;

	/**
	 * 跳转到组织结构页面
	 */
	@RequestMapping("/structure")
	public String structure() {
		return "organization/structure";
	}
	
	/**
	 * 跳转到部门列表页面
	 */
	@RequestMapping("/departmentListPage")
	public String departmentListPage(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "organization/departmentList";
	}
	
	/**
	 * 跳转到添加部门页面
	 */
	@RequestMapping("/addDepartmentPage")
	public String addDepartmentPage() {
		return "organization/departmentAdd";
	}
	
	/**
	 * 添加部门
	 */
	@PostMapping(value="/addDepartment",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addDepartment(@ModelAttribute Department department) {
		return organizationService.insertOrUpdateDepartment(department);
	}
	
	/**
	 * 跳转到更新部门页面
	 */
	@RequestMapping("/updateDepartmentPage")
	public String updateDepartmentPage(@RequestParam int departId, ModelMap modelMap) {
		modelMap.addAttribute("department", organizationService.getDepartmentById(departId));
		return "organization/departmentEdit";
	}
	
	/**
	 * 更新部门
	 */
	@PostMapping(value="/updateDepartment",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result updateDepartment(@ModelAttribute Department department) {
		return organizationService.insertOrUpdateDepartment(department);
	}
	
	/**
	 * 删除部门
	 */
	@PostMapping(value="/deleteDepartment",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteDepartment(@ModelAttribute Department department) {
		return organizationService.deleteDepartment(department.getDepartId());
	}
	
	/**
	 * 跳转到职位列表页面
	 */
	@RequestMapping("/positionListPage")
	public String positionListPage(ModelMap modelMap) {
		modelMap.addAttribute("positions", organizationService.getPositions());
		return "organization/positionList";
	}
	
	/**
	 * 获取职位列表
	 */
	@PostMapping(value="/positions", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Position> positions(@ModelAttribute SearchVo userSearch) {
		return organizationService.getPositionsByPage(userSearch);
	}
	
	/**
	 * 编辑职位页面
	 */
	@RequestMapping("/editPositionPage")
	public String editPositionPage(@RequestParam int positionId, ModelMap modelMap) {
		modelMap.addAttribute("position", organizationService.getPositionById(positionId));
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "organization/positionEdit";
	}
	
	/**
	 * 编辑职位
	 */
	@PostMapping(value="/editPosition",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editPosition(@ModelAttribute Position position) {
		return organizationService.insertOrUpdatePosition(position);
	}
	
	/**
	 * 添加职位页面
	 */
	@RequestMapping("/addPositionPage")
	public String addPositionPage(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "organization/positionAdd";
	}
	
	/**
	 * 添加职位
	 */
	@PostMapping(value="/addPosition",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addPosition(@ModelAttribute Position position) {
		return organizationService.insertOrUpdatePosition(position);
	}
	
	/**
	 * 删除职位
	 */
	@PostMapping(value="/deletePosition",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deletePosition(@ModelAttribute Position position) {
		return organizationService.deletePosition(position.getPositionId());
	}
	
	/**
	 * 根据部门id查询职位列表
	 */
	@RequestMapping(value="/positionsByDepart", consumes="application/json")
	@ResponseBody
	public List<Position> positionsByDepart(@RequestParam int departId) {
		return organizationService.getPositionsByDepartId(departId);
	}
	
	/**
	 * 查询部门列表，封装为组织结构树
	 */
	@PostMapping(value="/getOrgTree")
	@ResponseBody
	public List<ZtreeModel> getOrgTree(@ModelAttribute Position position) {
		return organizationService.getOrgTree();
	}
	
}
