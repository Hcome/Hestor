package com.hqyj.erp.modules.property.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 资产流动记录
 * 
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "property_flow_record")
public class PropertyFlowRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyFlowRecordId;
	private String propertyName;
	private String propertyType;
	private String propertyModel;
	private Integer propertyNum;
	private Integer applyId;
	private Integer approveId;
	private Date applyDate;
	private Date approveDate;
	@Transient
	private String applyName;
	@Transient
	private String approveName;

	public int getPropertyFlowRecordId() {
		return propertyFlowRecordId;
	}

	public void setPropertyFlowRecordId(int propertyFlowRecordId) {
		this.propertyFlowRecordId = propertyFlowRecordId;
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

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Integer getApproveId() {
		return approveId;
	}

	public void setApproveId(Integer approveId) {
		this.approveId = approveId;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}

}
