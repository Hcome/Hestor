package com.hqyj.erp.modules.property.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.dao.PropertyDao;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
import com.hqyj.erp.modules.property.entity.ScrapProperty;
import com.hqyj.erp.modules.property.service.PropertyService;

/**
 * Property Service Impl
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyDao propertyDao;
	
	/* 
	 * 添加资产
	 */
	@Override
	public Result addProperty(Property property) {
		Property existProperty = propertyDao.getPropertyByAttribute(property);
		property.initProperty(existProperty);
		
		return null;
	}
	
	/* 
	 * 获取在用资产列表，封装到page info中
	 */
	@Override
	public PageInfo<GrantProperty> getGrantProperties(SearchVo searchVo) {
		try {
			SearchVo.initSearchVo(searchVo);
			PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
			
			List<GrantProperty> grantProperties = 
					Optional.ofNullable(propertyDao.getGrantProperties(searchVo))
					.orElse(Collections.emptyList());
			return new PageInfo<>(grantProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}

	/* 
	 * 获取报废资产列表，封装到page info中
	 */
	@Override
	public PageInfo<ScrapProperty> getScrapProperties(SearchVo searchVo) {
		try {
			SearchVo.initSearchVo(searchVo);
			PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
			
			List<ScrapProperty> scrapProperties = 
					Optional.ofNullable(propertyDao.getScrapProperties(searchVo))
					.orElse(Collections.emptyList());
			return new PageInfo<>(scrapProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}
	
	/* 
	 * 获取资产列表，封装到page info中
	 */
	@Override
	public PageInfo<Property> getProperties(SearchVo searchVo) {
		try {
			SearchVo.initSearchVo(searchVo);
			PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
			
			List<Property> properties = 
					Optional.ofNullable(propertyDao.getProperties(searchVo))
					.orElse(Collections.emptyList());
			return new PageInfo<>(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}
}
