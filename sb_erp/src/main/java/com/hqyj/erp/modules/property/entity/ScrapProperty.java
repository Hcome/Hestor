package com.hqyj.erp.modules.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.hqyj.erp.modules.flow.entity.Apply;

/**
 * 报废资产
 * 
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "scrap_property")
public class ScrapProperty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scrapPropertyId;
	private String propertyName;
	private String propertyType;
	private String propertyModel;
	private Integer propertyNum;
	
	public static ScrapProperty initScrapProperty(Apply apply) {
		ScrapProperty scrapProperty = new ScrapProperty();
		if (apply != null) {
			BeanUtils.copyProperties(apply, scrapProperty);
		}
		return scrapProperty;
	}

	public int getScrapPropertyId() {
		return scrapPropertyId;
	}

	public void setScrapPropertyId(int scrapPropertyId) {
		this.scrapPropertyId = scrapPropertyId;
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
}
