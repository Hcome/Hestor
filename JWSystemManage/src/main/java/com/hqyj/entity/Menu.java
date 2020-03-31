package com.hqyj.entity;

public class Menu {
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuDesc=" + menuDesc + ", menuLink=" + menuLink + "]";
	}

	private Integer menuId;

	private String menuDesc;

	private String menuLink;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc == null ? null : menuDesc.trim();
	}

	public String getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink == null ? null : menuLink.trim();
	}
}