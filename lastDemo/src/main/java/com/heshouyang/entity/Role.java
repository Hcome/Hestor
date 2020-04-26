package com.heshouyang.entity;

import java.io.Serializable;

public class Role implements Serializable{

	/**
	 *角色实体类
	 */
	private static final long serialVersionUID = 1L;

	private Integer roleId;
	
	private String roleName;
	
	private String roleDes;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDes() {
		return roleDes;
	}

	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}

	public Role(Integer roleId, String roleName, String roleDes) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDes = roleDes;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDes=" + roleDes + "]";
	}
}
