package com.zty.ztyshop.dao.entity;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * <p>
 * 客户表
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public class ClientInfo extends Model<ClientInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 顾客姓名
     */
    private String name;

    /**
     * 性别（0女、1男）
     */
    private Boolean gender;

    /**
     * 手机号
     */
    private String modile;

    /**
     * 是否（会员1 ，否 0）
     */
    private Boolean isVip;

    /**
     * 用户等级
     */
    private Integer clientLevel;

    /**
     * 总体消费
     */
    private BigDecimal account;

    /**
     * 顾客生日
     */
    private LocalDate birthday;

    /**
     * 最近一次到店时间
     */
    private LocalDateTime lastLogin;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getModile() {
        return modile;
    }

    public void setModile(String modile) {
        this.modile = modile;
    }

    public Boolean getVip() {
        return isVip;
    }

    public void setVip(Boolean isVip) {
        this.isVip = isVip;
    }

    public Integer getClientLevel() {
        return clientLevel;
    }

    public void setClientLevel(Integer clientLevel) {
        this.clientLevel = clientLevel;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
        ", id=" + id +
        ", name=" + name +
        ", gender=" + gender +
        ", modile=" + modile +
        ", isVip=" + isVip +
        ", clientLevel=" + clientLevel +
        ", account=" + account +
        ", birthday=" + birthday +
        ", lastLogin=" + lastLogin +
        ", createAt=" + createAt +
        "}";
    }
}
