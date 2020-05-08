package com.heshouyang.entity;

import java.util.Date;

public class Account {
    private Integer accountId;
    //商场的名称
    private String makectName;
    
    private Integer accountAlluse;

    private String accountAcoding;

    private String accountOper;

    private Date accountDate;

    private Integer fkGoodsId;

    public String getMakectName() {
		return makectName;
	}

	public void setMakectName(String makectName) {
		this.makectName = makectName;
	}

	public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountAlluse() {
        return accountAlluse;
    }

    public void setAccountAlluse(Integer accountAlluse) {
        this.accountAlluse = accountAlluse;
    }

    public String getAccountAcoding() {
        return accountAcoding;
    }

    public void setAccountAcoding(String accountAcoding) {
        this.accountAcoding = accountAcoding == null ? null : accountAcoding.trim();
    }

    public String getAccountOper() {
        return accountOper;
    }

    public void setAccountOper(String accountOper) {
        this.accountOper = accountOper == null ? null : accountOper.trim();
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public Integer getFkGoodsId() {
        return fkGoodsId;
    }

    public void setFkGoodsId(Integer fkGoodsId) {
        this.fkGoodsId = fkGoodsId;
    }
}