package com.zty.ztyshop.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-05-16
 */
public class StaffInfo extends Model<StaffInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 职员等级
     */
    private String rankName;

    /**
     * 员工生日
     */
    private LocalDate birthday;

    /**
     * 性别(0 女，1 男)
     */
    private Integer gender;

    /**
     * 联系地址
     */
    private String adress;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 身份证号
     */
    private String idArd;

    /**
     * 入职时间
     */
    private LocalDate employmentDate;

    /**
     * 紧急联系人姓名
     */
    private String emergencyContactName;

    /**
     * 紧急联系人电话
     */
    private String emergencyContactMobile;

    /**
     * 状态（0 在职、1离职）
     */
    private Integer isResign;

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

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdArd() {
        return idArd;
    }

    public void setIdArd(String idArd) {
        this.idArd = idArd;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactMobile() {
        return emergencyContactMobile;
    }

    public void setEmergencyContactMobile(String emergencyContactMobile) {
        this.emergencyContactMobile = emergencyContactMobile;
    }

    public Integer getResign() {
        return isResign;
    }

    public void setResign(Integer isResign) {
        this.isResign = isResign;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
        ", id=" + id +
        ", name=" + name +
        ", rankName=" + rankName +
        ", birthday=" + birthday +
        ", gender=" + gender +
        ", adress=" + adress +
        ", mobile=" + mobile +
        ", idArd=" + idArd +
        ", employmentDate=" + employmentDate +
        ", emergencyContactName=" + emergencyContactName +
        ", emergencyContactMobile=" + emergencyContactMobile +
        ", isResign=" + isResign +
        "}";
    }
}
