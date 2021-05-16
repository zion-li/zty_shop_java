package com.zty.ztyshop.dao.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-05-16
 */
public class OrderInfo extends Model<OrderInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户唯一标识
     */
    private Integer clientId;

    /**
     * 发型师
     */
    private Integer staffId;

    /**
     * 现金业绩-类型
     */
    private String cashType;

    /**
     * 现金业绩
     */
    private BigDecimal cashAccount;

    /**
     * 剪发业绩
     */
    private BigDecimal cashJf;

    private Integer cashJfAssistant;

    /**
     * 烫发业绩
     */
    private BigDecimal cashTf;

    private Integer cashTfAssistant;

    /**
     * 染发业绩
     */
    private BigDecimal cashRf;

    private Integer cashRfAssistant;

    /**
     * 头皮业绩
     */
    private BigDecimal cashTp;

    private Integer cashTpAssistant;

    /**
     * 造型业绩
     */
    private BigDecimal cashZx;

    private Integer cashZxAssistant;

    /**
     * 营养
     */
    private BigDecimal cashYy;

    private Integer cashYyAssistant;

    /**
     * 水洗
     */
    private BigDecimal cashSx;

    private Integer cashSxAssistant;

    /**
     * 速焗
     */
    private BigDecimal cashSj;

    private Integer cashSjAssistant;

    /**
     * 商品
     */
    private BigDecimal cashSp;

    /**
     * 商品描述
     */
    private String cashSpDesc;

    private Integer cashSpAssistant;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 创建时间
     */
    private LocalDateTime updateAt;

    /**
     * 是否作废
     */
    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getCashType() {
        return cashType;
    }

    public void setCashType(String cashType) {
        this.cashType = cashType;
    }

    public BigDecimal getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(BigDecimal cashAccount) {
        this.cashAccount = cashAccount;
    }

    public BigDecimal getCashJf() {
        return cashJf;
    }

    public void setCashJf(BigDecimal cashJf) {
        this.cashJf = cashJf;
    }

    public Integer getCashJfAssistant() {
        return cashJfAssistant;
    }

    public void setCashJfAssistant(Integer cashJfAssistant) {
        this.cashJfAssistant = cashJfAssistant;
    }

    public BigDecimal getCashTf() {
        return cashTf;
    }

    public void setCashTf(BigDecimal cashTf) {
        this.cashTf = cashTf;
    }

    public Integer getCashTfAssistant() {
        return cashTfAssistant;
    }

    public void setCashTfAssistant(Integer cashTfAssistant) {
        this.cashTfAssistant = cashTfAssistant;
    }

    public BigDecimal getCashRf() {
        return cashRf;
    }

    public void setCashRf(BigDecimal cashRf) {
        this.cashRf = cashRf;
    }

    public Integer getCashRfAssistant() {
        return cashRfAssistant;
    }

    public void setCashRfAssistant(Integer cashRfAssistant) {
        this.cashRfAssistant = cashRfAssistant;
    }

    public BigDecimal getCashTp() {
        return cashTp;
    }

    public void setCashTp(BigDecimal cashTp) {
        this.cashTp = cashTp;
    }

    public Integer getCashTpAssistant() {
        return cashTpAssistant;
    }

    public void setCashTpAssistant(Integer cashTpAssistant) {
        this.cashTpAssistant = cashTpAssistant;
    }

    public BigDecimal getCashZx() {
        return cashZx;
    }

    public void setCashZx(BigDecimal cashZx) {
        this.cashZx = cashZx;
    }

    public Integer getCashZxAssistant() {
        return cashZxAssistant;
    }

    public void setCashZxAssistant(Integer cashZxAssistant) {
        this.cashZxAssistant = cashZxAssistant;
    }

    public BigDecimal getCashYy() {
        return cashYy;
    }

    public void setCashYy(BigDecimal cashYy) {
        this.cashYy = cashYy;
    }

    public Integer getCashYyAssistant() {
        return cashYyAssistant;
    }

    public void setCashYyAssistant(Integer cashYyAssistant) {
        this.cashYyAssistant = cashYyAssistant;
    }

    public BigDecimal getCashSx() {
        return cashSx;
    }

    public void setCashSx(BigDecimal cashSx) {
        this.cashSx = cashSx;
    }

    public Integer getCashSxAssistant() {
        return cashSxAssistant;
    }

    public void setCashSxAssistant(Integer cashSxAssistant) {
        this.cashSxAssistant = cashSxAssistant;
    }

    public BigDecimal getCashSj() {
        return cashSj;
    }

    public void setCashSj(BigDecimal cashSj) {
        this.cashSj = cashSj;
    }

    public Integer getCashSjAssistant() {
        return cashSjAssistant;
    }

    public void setCashSjAssistant(Integer cashSjAssistant) {
        this.cashSjAssistant = cashSjAssistant;
    }

    public BigDecimal getCashSp() {
        return cashSp;
    }

    public void setCashSp(BigDecimal cashSp) {
        this.cashSp = cashSp;
    }

    public String getCashSpDesc() {
        return cashSpDesc;
    }

    public void setCashSpDesc(String cashSpDesc) {
        this.cashSpDesc = cashSpDesc;
    }

    public Integer getCashSpAssistant() {
        return cashSpAssistant;
    }

    public void setCashSpAssistant(Integer cashSpAssistant) {
        this.cashSpAssistant = cashSpAssistant;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                ", id=" + id +
                ", clientId=" + clientId +
                ", staffId=" + staffId +
                ", cashType=" + cashType +
                ", cashAccount=" + cashAccount +
                ", cashJf=" + cashJf +
                ", cashJfAssistant=" + cashJfAssistant +
                ", cashTf=" + cashTf +
                ", cashTfAssistant=" + cashTfAssistant +
                ", cashRf=" + cashRf +
                ", cashRfAssistant=" + cashRfAssistant +
                ", cashTp=" + cashTp +
                ", cashTpAssistant=" + cashTpAssistant +
                ", cashZx=" + cashZx +
                ", cashZxAssistant=" + cashZxAssistant +
                ", cashYy=" + cashYy +
                ", cashYyAssistant=" + cashYyAssistant +
                ", cashSx=" + cashSx +
                ", cashSxAssistant=" + cashSxAssistant +
                ", cashSj=" + cashSj +
                ", cashSjAssistant=" + cashSjAssistant +
                ", cashSp=" + cashSp +
                ", cashSpDesc=" + cashSpDesc +
                ", cashSpAssistant=" + cashSpAssistant +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", isDelete=" + isDelete +
                "}";
    }
}
