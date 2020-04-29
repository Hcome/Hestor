package com.heshouyang.entity;

import java.util.Date;

public class Seller {
    private Integer sellerId;

    private Integer sellerNum;

    private Integer sellerAllprise;

    private Integer fkCustomerId;

    private Integer fkUserId;

    private Date sellerDate;

    private String sellerStutas;

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getSellerNum() {
        return sellerNum;
    }

    public void setSellerNum(Integer sellerNum) {
        this.sellerNum = sellerNum;
    }

    public Integer getSellerAllprise() {
        return sellerAllprise;
    }

    public void setSellerAllprise(Integer sellerAllprise) {
        this.sellerAllprise = sellerAllprise;
    }

    public Integer getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(Integer fkCustomerId) {
        this.fkCustomerId = fkCustomerId;
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }

    public Date getSellerDate() {
        return sellerDate;
    }

    public void setSellerDate(Date sellerDate) {
        this.sellerDate = sellerDate;
    }

    public String getSellerStutas() {
        return sellerStutas;
    }

    public void setSellerStutas(String sellerStutas) {
        this.sellerStutas = sellerStutas == null ? null : sellerStutas.trim();
    }
}