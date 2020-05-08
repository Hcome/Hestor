package com.heshouyang.entity;

public class Supplier {
    private Integer supplierId;

    private String supplierName;

    private String supplierAddress;

    private String supplierPhonenumber;

    private String supplierEmail;
    
    private Goods goods;

    public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
    }

    public String getSupplierPhonenumber() {
        return supplierPhonenumber;
    }

    public void setSupplierPhonenumber(String supplierPhonenumber) {
        this.supplierPhonenumber = supplierPhonenumber == null ? null : supplierPhonenumber.trim();
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail == null ? null : supplierEmail.trim();
    }
}