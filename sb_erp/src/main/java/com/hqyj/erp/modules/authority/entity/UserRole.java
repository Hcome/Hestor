package com.hqyj.erp.modules.authority.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRoleId;
	private int userId;
	private int roleId;

	public UserRole() {
	}

	public UserRole(int userId, int roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
