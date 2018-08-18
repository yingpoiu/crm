package com.briup.crm.common.bean;

import java.io.Serializable;

public class Storage implements Serializable {
    /**
     * 编号
     */
    private Long stkId;

    /**
     * 仓库名
     */
    private String stkWarehourse;

    /**
     * 总数量
     */
    private Integer stkCount;

    /**
     * 计量单位
     */
    private String stkMemo;

    /**
     * 货位
     */
    private String stkWare;

    /**
     * 库存货物名字
     */
    private String stkName;

    private static final long serialVersionUID = 1L;

    public Long getStkId() {
        return stkId;
    }

    public void setStkId(Long stkId) {
        this.stkId = stkId;
    }

    public String getStkWarehourse() {
        return stkWarehourse;
    }

    public void setStkWarehourse(String stkWarehourse) {
        this.stkWarehourse = stkWarehourse == null ? null : stkWarehourse.trim();
    }

    public Integer getStkCount() {
        return stkCount;
    }

    public void setStkCount(Integer stkCount) {
        this.stkCount = stkCount;
    }

    public String getStkMemo() {
        return stkMemo;
    }

    public void setStkMemo(String stkMemo) {
        this.stkMemo = stkMemo == null ? null : stkMemo.trim();
    }

    public String getStkWare() {
        return stkWare;
    }

    public void setStkWare(String stkWare) {
        this.stkWare = stkWare == null ? null : stkWare.trim();
    }

    public String getStkName() {
        return stkName;
    }

    public void setStkName(String stkName) {
        this.stkName = stkName == null ? null : stkName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stkId=").append(stkId);
        sb.append(", stkWarehourse=").append(stkWarehourse);
        sb.append(", stkCount=").append(stkCount);
        sb.append(", stkMemo=").append(stkMemo);
        sb.append(", stkWare=").append(stkWare);
        sb.append(", stkName=").append(stkName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}