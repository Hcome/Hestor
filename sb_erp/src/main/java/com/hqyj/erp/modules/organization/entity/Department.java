package com.hqyj.erp.modules.organization.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departId;
	private String departName;
	private String departDesc;

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartDesc() {
		return departDesc;
	}

	public void setDepartDesc(String departDesc) {
		this.departDesc = departDesc;
	}
}
