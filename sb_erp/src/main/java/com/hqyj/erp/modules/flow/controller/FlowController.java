package com.hqyj.erp.modules.flow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.exception.ErpException;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.flow.entity.Apply;
import com.hqyj.erp.modules.flow.service.FlowService;
import com.hqyj.erp.modules.property.constant.ApplyStatus;
import com.hqyj.erp.modules.property.constant.ApplyType;
import com.hqyj.erp.modules.property.constant.PropertyType;

/**
 * 申请流程控制器
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Controller
@RequestMapping("/flow")
public class FlowController {
	
	@Autowired
	private FlowService flowService;
	@Autowired
	private AccountService accountService;

	/**
	 * 用户申请列表页面
	 */
	@RequestMapping("/applyListPage")
	public String applyListPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "flow/applyList";
	}
	
	/**
	 * 获取用户申请列表
	 */
	@RequestMapping(value="/applies",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Apply> getApplies(@ModelAttribute SearchVo searchVo) {
		return flowService.getApplies(searchVo);
	}
	
	/**
	 * 跳转到添加申请页面
	 */
	@RequestMapping("/addApplyPage")
	public String addApplyPage(ModelMap modelMap) {
		User user = accountService.getUserBySubject();
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		modelMap.addAttribute("leaders", accountService.getLeadersByCurrentUserId(user.getUserId()));
		return "flow/applyAdd";
	}
	
	/**
	 * 添加申请
	 */
	@RequestMapping(value="/addApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addApply(@ModelAttribute Apply apply) {
		return flowService.insertOrUpdateApply(apply);
	}
	
	/**
	 * 跳转到编辑申请页面
	 */
	@RequestMapping("/editApplyPage")
	public String editApplyPage(@RequestParam int applyId, ModelMap modelMap) {
		User user = accountService.getUserBySubject();
		modelMap.addAttribute("apply", flowService.getApplyById(applyId));
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		modelMap.addAttribute("leaders", accountService.getLeadersByCurrentUserId(user.getUserId()));
		return "flow/applyEdit";
	}
	
	/**
	 * 编辑申请
	 */
	@RequestMapping(value="/editApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editApply(@ModelAttribute Apply apply) {
		return flowService.insertOrUpdateApply(apply);
	}
	
	/**
	 * 删除申请
	 */
	@RequestMapping(value="/deleteApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteApply(@ModelAttribute Apply apply) {
		return flowService.deleteApply(apply.getApplyId());
	}
	
	/**
	 * 跳转到申请流程页面
	 */
	@RequestMapping("/flowListPage")
	public String flowListPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "flow/flowList";
	}
	
	/**
	 * 获取申请流程列表
	 */
	@RequestMapping(value="/applyFlows",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Apply> applyFlows(@ModelAttribute SearchVo searchVo) {
		return flowService.applyFlows(searchVo);
	}
	
	/**
	 * 跳转到编辑申请流程页面
	 */
	@RequestMapping("/editFlowPage")
	public String editFlowPage(@RequestParam int applyId, ModelMap modelMap) {
		modelMap.addAttribute("apply", flowService.getApplyById(applyId));
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		modelMap.addAttribute("applyStatus", ApplyStatus.applyStatus);
		return "flow/flowEdit";
	}
	
	/**
	 * 编辑申请流程
	 */
	@RequestMapping(value="/editFlow", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editFlow(@ModelAttribute Apply apply) {
		try {
			return flowService.updateApplyFlow(apply);
		} catch (ErpException e) {
			e.printStackTrace();
			return new Result(e.getStatus(), e.getReason());
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "操作失败。");
		}
	}
}
