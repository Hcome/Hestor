package com.hqyj.erp.modules.authority.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 角色表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	private String roleName;
	private String roleDesc;
	
	@Transient
	private boolean selected;
	
	public static List<Role> composeRoleList(List<Role> allRoles, List<Role> selectedRoles) {
		if (selectedRoles == null) {
			return allRoles;
		}
		
		allRoles.stream().forEach(item -> {
			selectedRoles.stream().forEach(itemTemp -> {
				if (itemTemp.getRoleId() == item.getRoleId()) {
					item.setSelected(true);
				}
			});
		});
		
		return allRoles;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
