package com.briup.crm.common.bean;

import java.io.Serializable;
import java.util.Date;

public class CstLog implements Serializable {
    /**
     * 编号
     */
    private Integer logId;

    /**
     * 操作人
     */
    private String logOp;

    /**
     * 操作事件
     */
    private String logEvent;

    /**
     * 日期
     */
    private Date logDate;

    private static final long serialVersionUID = 1L;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogOp() {
        return logOp;
    }

    public void setLogOp(String logOp) {
        this.logOp = logOp == null ? null : logOp.trim();
    }

    public String getLogEvent() {
        return logEvent;
    }

    public void setLogEvent(String logEvent) {
        this.logEvent = logEvent == null ? null : logEvent.trim();
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logId=").append(logId);
        sb.append(", logOp=").append(logOp);
        sb.append(", logEvent=").append(logEvent);
        sb.append(", logDate=").append(logDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}