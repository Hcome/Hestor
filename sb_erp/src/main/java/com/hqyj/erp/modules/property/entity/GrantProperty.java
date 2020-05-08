package com.hqyj.erp.modules.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.BeanUtils;

import com.hqyj.erp.modules.flow.entity.Apply;

/**
 * 在用资产
 * 
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "grant_property")
public class GrantProperty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int grantPropertyId;
	private Integer userId;
	private String propertyName;
	private String propertyType;
	private String propertyModel;
	private Integer propertyNum;
	private Double unitPrice;
	private Double totalPrice;
	@Transient
	private String userName;
	
	public static GrantProperty init(Apply apply) {
		GrantProperty grantProperty = new GrantProperty();
		BeanUtils.copyProperties(apply, grantProperty);
		return grantProperty;
	}

	public int getGrantPropertyId() {
		return grantPropertyId;
	}

	public void setGrantPropertyId(int grantPropertyId) {
		this.grantPropertyId = grantPropertyId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyModel() {
		return propertyModel;
	}

	public void setPropertyModel(String propertyModel) {
		this.propertyModel = propertyModel;
	}

	public Integer getPropertyNum() {
		return propertyNum;
	}

	public void setPropertyNum(Integer propertyNum) {
		this.propertyNum = propertyNum;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
