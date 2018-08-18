package com.briup.crm.common.bean;

import java.io.Serializable;

public class Product implements Serializable {
    /**
     * 产品编号
     */
    private Long prodId;

    /**
     * 产品名字
     */
    private String prodName;

    /**
     * 型号
     */
    private String prodType;

    /**
     * 批次
     */
    private String prodBatch;

    /**
     * 单位
     */
    private String prodUnit;

    /**
     * 单价
     */
    private Double prodPrice;

    /**
     * 备注
     */
    private String prodMemo;

    private static final long serialVersionUID = 1L;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType == null ? null : prodType.trim();
    }

    public String getProdBatch() {
        return prodBatch;
    }

    public void setProdBatch(String prodBatch) {
        this.prodBatch = prodBatch == null ? null : prodBatch.trim();
    }

    public String getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit == null ? null : prodUnit.trim();
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdMemo() {
        return prodMemo;
    }

    public void setProdMemo(String prodMemo) {
        this.prodMemo = prodMemo == null ? null : prodMemo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prodId=").append(prodId);
        sb.append(", prodName=").append(prodName);
        sb.append(", prodType=").append(prodType);
        sb.append(", prodBatch=").append(prodBatch);
        sb.append(", prodUnit=").append(prodUnit);
        sb.append(", prodPrice=").append(prodPrice);
        sb.append(", prodMemo=").append(prodMemo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}