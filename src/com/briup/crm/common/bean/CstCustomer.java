package com.briup.crm.common.bean;

import java.io.Serializable;

public class CstCustomer implements Serializable {
    /**
     * 客户编号
     */
    private Long custId;

    /**
     * 客户号
     */
    private String custNo;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 客户区域
     */
    private String custRegion;

    /**
     * 客户经理编号
     */
    private Long custManagerId;

    /**
     * 客户经理姓名
     */
    private String custManagerName;

    /**
     * 客户等级
     */
    private Integer custLevel;

    /**
     * 客户等级描述
     */
    private String custLevelLabel;

    /**
     * 客户满意度
     */
    private Integer custSatisfy;

    /**
     * 客户信誉度
     */
    private Integer custCredit;

    /**
     * 客户地址
     */
    private String custAddr;

    /**
     * 客户邮编
     */
    private String custZip;

    /**
     * 客户电话
     */
    private String custTel;

    /**
     * 客户传真
     */
    private String custFax;

    /**
     * 网址
     */
    private String custWebsite;

    /**
     * 营业执照注册号
     */
    private String custLicenceNo;

    /**
     * 法人
     */
    private String custChieftain;

    /**
     * 注册资金
     */
    private Float custBankroll;

    /**
     * 年营业额
     */
    private Float custTurnover;

    /**
     * 开户行
     */
    private String custBank;

    /**
     * 银行账号
     */
    private String custBankAccount;

    /**
     * 地税登记号
     */
    private String custLocalTaxNo;

    /**
     * 国税登记号
     */
    private String custNationalTaxNo;

    /**
     * 客户状态
     */
    private String custStatus;

    private static final long serialVersionUID = 1L;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustRegion() {
        return custRegion;
    }

    public void setCustRegion(String custRegion) {
        this.custRegion = custRegion == null ? null : custRegion.trim();
    }

    public Long getCustManagerId() {
        return custManagerId;
    }

    public void setCustManagerId(Long custManagerId) {
        this.custManagerId = custManagerId;
    }

    public String getCustManagerName() {
        return custManagerName;
    }

    public void setCustManagerName(String custManagerName) {
        this.custManagerName = custManagerName == null ? null : custManagerName.trim();
    }

    public Integer getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(Integer custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustLevelLabel() {
        return custLevelLabel;
    }

    public void setCustLevelLabel(String custLevelLabel) {
        this.custLevelLabel = custLevelLabel == null ? null : custLevelLabel.trim();
    }

    public Integer getCustSatisfy() {
        return custSatisfy;
    }

    public void setCustSatisfy(Integer custSatisfy) {
        this.custSatisfy = custSatisfy;
    }

    public Integer getCustCredit() {
        return custCredit;
    }

    public void setCustCredit(Integer custCredit) {
        this.custCredit = custCredit;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr == null ? null : custAddr.trim();
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip == null ? null : custZip.trim();
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel == null ? null : custTel.trim();
    }

    public String getCustFax() {
        return custFax;
    }

    public void setCustFax(String custFax) {
        this.custFax = custFax == null ? null : custFax.trim();
    }

    public String getCustWebsite() {
        return custWebsite;
    }

    public void setCustWebsite(String custWebsite) {
        this.custWebsite = custWebsite == null ? null : custWebsite.trim();
    }

    public String getCustLicenceNo() {
        return custLicenceNo;
    }

    public void setCustLicenceNo(String custLicenceNo) {
        this.custLicenceNo = custLicenceNo == null ? null : custLicenceNo.trim();
    }

    public String getCustChieftain() {
        return custChieftain;
    }

    public void setCustChieftain(String custChieftain) {
        this.custChieftain = custChieftain == null ? null : custChieftain.trim();
    }

    public Float getCustBankroll() {
        return custBankroll;
    }

    public void setCustBankroll(Float custBankroll) {
        this.custBankroll = custBankroll;
    }

    public Float getCustTurnover() {
        return custTurnover;
    }

    public void setCustTurnover(Float custTurnover) {
        this.custTurnover = custTurnover;
    }

    public String getCustBank() {
        return custBank;
    }

    public void setCustBank(String custBank) {
        this.custBank = custBank == null ? null : custBank.trim();
    }

    public String getCustBankAccount() {
        return custBankAccount;
    }

    public void setCustBankAccount(String custBankAccount) {
        this.custBankAccount = custBankAccount == null ? null : custBankAccount.trim();
    }

    public String getCustLocalTaxNo() {
        return custLocalTaxNo;
    }

    public void setCustLocalTaxNo(String custLocalTaxNo) {
        this.custLocalTaxNo = custLocalTaxNo == null ? null : custLocalTaxNo.trim();
    }

    public String getCustNationalTaxNo() {
        return custNationalTaxNo;
    }

    public void setCustNationalTaxNo(String custNationalTaxNo) {
        this.custNationalTaxNo = custNationalTaxNo == null ? null : custNationalTaxNo.trim();
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus == null ? null : custStatus.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", custId=").append(custId);
        sb.append(", custNo=").append(custNo);
        sb.append(", custName=").append(custName);
        sb.append(", custRegion=").append(custRegion);
        sb.append(", custManagerId=").append(custManagerId);
        sb.append(", custManagerName=").append(custManagerName);
        sb.append(", custLevel=").append(custLevel);
        sb.append(", custLevelLabel=").append(custLevelLabel);
        sb.append(", custSatisfy=").append(custSatisfy);
        sb.append(", custCredit=").append(custCredit);
        sb.append(", custAddr=").append(custAddr);
        sb.append(", custZip=").append(custZip);
        sb.append(", custTel=").append(custTel);
        sb.append(", custFax=").append(custFax);
        sb.append(", custWebsite=").append(custWebsite);
        sb.append(", custLicenceNo=").append(custLicenceNo);
        sb.append(", custChieftain=").append(custChieftain);
        sb.append(", custBankroll=").append(custBankroll);
        sb.append(", custTurnover=").append(custTurnover);
        sb.append(", custBank=").append(custBank);
        sb.append(", custBankAccount=").append(custBankAccount);
        sb.append(", custLocalTaxNo=").append(custLocalTaxNo);
        sb.append(", custNationalTaxNo=").append(custNationalTaxNo);
        sb.append(", custStatus=").append(custStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}