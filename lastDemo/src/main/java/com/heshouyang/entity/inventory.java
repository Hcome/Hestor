package com.heshouyang.entity;

import java.util.Date;

public class inventory {
    private Integer inventoryId;

    private Integer fkGoodsId;

    private Integer inventoryNum;

    private Integer fkSupplierId;

    private Integer fkUserId;

    private Date inventoryDate;

    private String inventoryStutas;

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getFkGoodsId() {
        return fkGoodsId;
    }

    public void setFkGoodsId(Integer fkGoodsId) {
        this.fkGoodsId = fkGoodsId;
    }

    public Integer getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(Integer inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    public Integer getFkSupplierId() {
        return fkSupplierId;
    }

    public void setFkSupplierId(Integer fkSupplierId) {
        this.fkSupplierId = fkSupplierId;
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }

    public Date getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(Date inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public String getInventoryStutas() {
        return inventoryStutas;
    }

    public void setInventoryStutas(String inventoryStutas) {
        this.inventoryStutas = inventoryStutas == null ? null : inventoryStutas.trim();
    }
}