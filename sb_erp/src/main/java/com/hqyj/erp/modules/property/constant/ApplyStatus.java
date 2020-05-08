package com.hqyj.erp.modules.property.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请状态
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public enum ApplyStatus {
	APPLY(0, "审核中"), APPROVE(1, "批准"), REJECT(-1, "拒绝");
	
	private int code;
	private String desc;

	private ApplyStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public static List<String> applyStatus = new ArrayList<String>();
	static {
		for (ApplyStatus applyStatu : ApplyStatus.values()) {
			applyStatus.add(applyStatu.desc);
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
