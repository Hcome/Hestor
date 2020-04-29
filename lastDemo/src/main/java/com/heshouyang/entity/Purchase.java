package com.heshouyang.entity;

import java.util.Date;

public class Purchase {
    private Integer purchaseId;

    private Integer fkSupplierId;

    private Integer fkGoodsId;

    private Integer purchaseNum;

    private Long purchaseAllprice;

    private Date purchaseDate;

    private String purchaseStutas;

    private Integer fkUserId;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getFkSupplierId() {
        return fkSupplierId;
    }

    public void setFkSupplierId(Integer fkSupplierId) {
        this.fkSupplierId = fkSupplierId;
    }

    public Integer getFkGoodsId() {
        return fkGoodsId;
    }

    public void setFkGoodsId(Integer fkGoodsId) {
        this.fkGoodsId = fkGoodsId;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public Long getPurchaseAllprice() {
        return purchaseAllprice;
    }

    public void setPurchaseAllprice(Long purchaseAllprice) {
        this.purchaseAllprice = purchaseAllprice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseStutas() {
        return purchaseStutas;
    }

    public void setPurchaseStutas(String purchaseStutas) {
        this.purchaseStutas = purchaseStutas == null ? null : purchaseStutas.trim();
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }
}