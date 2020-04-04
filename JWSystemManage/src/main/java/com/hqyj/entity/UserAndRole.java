package com.hqyj.entity;

public class UserAndRole {

	private int userRoleId;
	private int fkUserId;
	private int kfRoleId;
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public int getFkUserId() {
		return fkUserId;
	}
	public void setFkUserId(int fkUserId) {
		this.fkUserId = fkUserId;
	}
	public int getKfRoleId() {
		return kfRoleId;
	}
	public void setKfRoleId(int kfRoleId) {
		this.kfRoleId = kfRoleId;
	}
}
