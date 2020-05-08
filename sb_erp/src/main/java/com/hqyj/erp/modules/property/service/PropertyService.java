package com.hqyj.erp.modules.property.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
import com.hqyj.erp.modules.property.entity.ScrapProperty;

/**
 * Property Service
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public interface PropertyService {

	Result addProperty(Property property);
	
	PageInfo<GrantProperty> getGrantProperties(SearchVo searchVo);
	
	PageInfo<ScrapProperty> getScrapProperties(SearchVo searchVo);
	
	PageInfo<Property> getProperties(SearchVo searchVo);
}
