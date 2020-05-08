package com.hqyj.erp.modules.property.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请类型
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public enum ApplyType {
	GRANT(1, "领用"), PURCHASE(2, "采购"), SCRAP(3, "报废");

	private int code;
	private String desc;

	private ApplyType(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public static List<String> applyTypes = new ArrayList<String>();
	static {
		for (ApplyType applyType : ApplyType.values()) {
			applyTypes.add(applyType.desc);
		}
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
