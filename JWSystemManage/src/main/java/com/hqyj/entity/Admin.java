package com.hqyj.entity;
/**
 * 管理员
 * @author Administrator
 *
 */
public class Admin {

	private Integer adminId;

    private Integer adminNum;

    private String adminName;

    private Integer adminAge;

    private String adminTel;

    private String adminGender;

    private String adminEmail;

    private Integer fkUserId;

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminNum=" + adminNum + ", adminName=" + adminName + ", adminAge="
				+ adminAge + ", adminTel=" + adminTel + ", adminGender=" + adminGender + ", adminEmail=" + adminEmail
				+ ", fkUserId=" + fkUserId + "]";
	}

	public Admin(Integer adminId, Integer adminNum, String adminName, Integer adminAge, String adminTel,
			String adminGender, String adminEmail, Integer fkUserId) {
		super();
		this.adminId = adminId;
		this.adminNum = adminNum;
		this.adminName = adminName;
		this.adminAge = adminAge;
		this.adminTel = adminTel;
		this.adminGender = adminGender;
		this.adminEmail = adminEmail;
		this.fkUserId = fkUserId;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getAdminNum() {
		return adminNum;
	}

	public void setAdminNum(Integer adminNum) {
		this.adminNum = adminNum;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(Integer adminAge) {
		this.adminAge = adminAge;
	}

	public String getAdminTel() {
		return adminTel;
	}

	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public Integer getFkUserId() {
		return fkUserId;
	}

	public void setFkUserId(Integer fkUserId) {
		this.fkUserId = fkUserId;
	}
}
