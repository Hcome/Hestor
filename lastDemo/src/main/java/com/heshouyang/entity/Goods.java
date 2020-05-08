package com.heshouyang.entity;

import java.io.Serializable;

public class Goods implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer goodsId;

    private String goodsName;

    private String goodsSpec;

    private String goodsPrice;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec == null ? null : goodsSpec.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsSpec=" + goodsSpec + ", goodsPrice="
				+ goodsPrice + "]";
	}

	public Goods(Integer goodsId, String goodsName, String goodsSpec, String goodsPrice) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsSpec = goodsSpec;
		this.goodsPrice = goodsPrice;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}