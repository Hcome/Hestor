package com.hqyj.erp.modules.property.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 资产类型
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public enum PropertyType {
	CURRENT_ASSETS("流动资产"),
	FIXED_ASSETS("固定资产"),
	INTANGIBLE_ASSETS("无形资产"),
	DEFERRED_ASSETS("递延资产"),
	OTHER_ASSETS("其他资产"),
	LONG_TERM_INVESTMENT("长期资产");
	
	public static List<String> propertyTypes = new ArrayList<String>();
	static {
		for (PropertyType propertyType : PropertyType.values()) {
			propertyTypes.add(propertyType.type);
		}
	}
	
	private String type;

	private PropertyType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
