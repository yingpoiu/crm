package com.briup.crm.common.bean;

import java.io.Serializable;

public class CstLinkman implements Serializable {
    /**
     * 联系人编号
     */
    private Long lkmId;

    /**
     * 客户编号
     */
    private Long lkmCustId;

    /**
     * 客户号
     */
    private String lkmCustNo;

    /**
     * 客户名称
     */
    private String lkmCustName;

    /**
     * 联系人名字
     */
    private String lkmName;

    /**
     * 联系人地点
     */
    private String lkmSex;

    /**
     * 地点
     */
    private String lkmPostion;

    /**
     * 联系电话
     */
    private String lkmTel;

    /**
     * 手机号码
     */
    private String lkmMobile;

    /**
     * 备注
     */
    private String lkmMemo;

    private static final long serialVersionUID = 1L;

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public Long getLkmCustId() {
        return lkmCustId;
    }

    public void setLkmCustId(Long lkmCustId) {
        this.lkmCustId = lkmCustId;
    }

    public String getLkmCustNo() {
        return lkmCustNo;
    }

    public void setLkmCustNo(String lkmCustNo) {
        this.lkmCustNo = lkmCustNo == null ? null : lkmCustNo.trim();
    }

    public String getLkmCustName() {
        return lkmCustName;
    }

    public void setLkmCustName(String lkmCustName) {
        this.lkmCustName = lkmCustName == null ? null : lkmCustName.trim();
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName == null ? null : lkmName.trim();
    }

    public String getLkmSex() {
        return lkmSex;
    }

    public void setLkmSex(String lkmSex) {
        this.lkmSex = lkmSex == null ? null : lkmSex.trim();
    }

    public String getLkmPostion() {
        return lkmPostion;
    }

    public void setLkmPostion(String lkmPostion) {
        this.lkmPostion = lkmPostion == null ? null : lkmPostion.trim();
    }

    public String getLkmTel() {
        return lkmTel;
    }

    public void setLkmTel(String lkmTel) {
        this.lkmTel = lkmTel == null ? null : lkmTel.trim();
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile == null ? null : lkmMobile.trim();
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo == null ? null : lkmMemo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lkmId=").append(lkmId);
        sb.append(", lkmCustId=").append(lkmCustId);
        sb.append(", lkmCustNo=").append(lkmCustNo);
        sb.append(", lkmCustName=").append(lkmCustName);
        sb.append(", lkmName=").append(lkmName);
        sb.append(", lkmSex=").append(lkmSex);
        sb.append(", lkmPostion=").append(lkmPostion);
        sb.append(", lkmTel=").append(lkmTel);
        sb.append(", lkmMobile=").append(lkmMobile);
        sb.append(", lkmMemo=").append(lkmMemo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}