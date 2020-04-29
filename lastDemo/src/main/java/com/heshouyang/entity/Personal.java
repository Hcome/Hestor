package com.heshouyang.entity;

import java.util.Date;

public class Personal {
    private Integer personalId;

    private String personalNum;

    private String personalName;

    private String personalTel;

    private String personalSex;

    private String personalAge;

    private Date birthday;

    private String department;

    private String bankname;

    private String bankid;

    private Integer fkUserId;

    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

    public String getPersonalNum() {
        return personalNum;
    }

    public void setPersonalNum(String personalNum) {
        this.personalNum = personalNum == null ? null : personalNum.trim();
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName == null ? null : personalName.trim();
    }

    public String getPersonalTel() {
        return personalTel;
    }

    public void setPersonalTel(String personalTel) {
        this.personalTel = personalTel == null ? null : personalTel.trim();
    }

    public String getPersonalSex() {
        return personalSex;
    }

    public void setPersonalSex(String personalSex) {
        this.personalSex = personalSex == null ? null : personalSex.trim();
    }

    public String getPersonalAge() {
        return personalAge;
    }

    public void setPersonalAge(String personalAge) {
        this.personalAge = personalAge == null ? null : personalAge.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }
}