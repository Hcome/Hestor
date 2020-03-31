package com.hqyj.model.vo;

/**
 * 用户角色中间表
 * 
 * @author GYQ20
 *
 */
public class UserAndRole {
	
	private Integer userRoleId;
	private Integer userId;
	private Integer roleId;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
