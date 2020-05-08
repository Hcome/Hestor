package com.hqyj.erp.modules.property.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.constant.PropertyType;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
import com.hqyj.erp.modules.property.entity.ScrapProperty;
import com.hqyj.erp.modules.property.service.PropertyService;

/**
 * 资产相关控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/property")
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private AccountService accountService;

	/**
	 * 跳转到在用资产页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/grantPropertyListPage")
	public String grantPropertyListPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		return "property/grantPropertyList";
	}
	
	/**
	 * 获取在用资产
	 */
	@RequestMapping(value="/grantProperties",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<GrantProperty> grantProperties(@ModelAttribute SearchVo searchVo) {
		return propertyService.getGrantProperties(searchVo);
	}
	
	/**
	 * 跳转到报废资产页面
	 */
	@RequestMapping("/scrapPropertyListPage")
	public String scrapPropertyListPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		return "property/scrapPropertyList";
	}
	
	/**
	 * 获取报废资产列表
	 */
	@RequestMapping(value="/scrapProperties",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<ScrapProperty> scrapProperties(@ModelAttribute SearchVo searchVo) {
		return propertyService.getScrapProperties(searchVo);
	}
	
	/**
	 * 跳转到资产列表页面
	 */
	@RequestMapping("/propertyListPage")
	public String propertyListPage(ModelMap modelMap) {
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		return "property/propertyList";
	}
	
	/**
	 * 获取资产列表
	 */
	@RequestMapping(value="/properties",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Property> properties(@ModelAttribute SearchVo searchVo) {
		return propertyService.getProperties(searchVo);
	}
	
}
