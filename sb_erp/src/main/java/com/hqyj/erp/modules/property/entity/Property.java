package com.hqyj.erp.modules.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.hqyj.erp.modules.flow.entity.Apply;

/**
 * 资产表
 * 
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "property")
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	private String propertyName;
	private String propertyType;
	private String propertyModel;
	private Integer propertyNum;
	private Double unitPrice;
	private Double totalPrice;

	public void initProperty(Property existProperty) {
		if (existProperty != null) {
			this.setPropertyNum(this.getPropertyNum() + existProperty.getPropertyNum());
			this.setTotalPrice(this.getUnitPrice() * this.getPropertyNum());
		}
	}
	
	public static Property initProperty(Apply apply) {
		Property property = new Property();
		if (apply != null) {
			BeanUtils.copyProperties(apply, property);
			property.setTotalPrice(property.getUnitPrice() * property.getPropertyNum());
		}
		return property;
	}

	public Property() {
	}

	public Property(String propertyName, String propertyType, String propertyModel) {
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.propertyModel = propertyModel;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
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

}
