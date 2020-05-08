package com.hqyj.erp.modules.organization.vo;

/**
 * 组织结构树对象
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public class ZtreeModel {

	private String id;
	private String pId = "0";
	private String name;
	private String icon;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
