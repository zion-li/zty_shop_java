package com.zty.ztyshop.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public class StaffInfo extends Model<StaffInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 员工生日
     */
    private LocalDate birthday;

    /**
     * 性别(0 女，1 男)
     */
    private Boolean gender;

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
     * 职称名称
     */
    private Integer staffLevel;

    /**
     * 紧急联系人姓名
     */
    private String emergencyContactName;

    /**
     * 紧急联系人电话
     */
    private String emergencyContactMobile;

    /**
     * 状态（0 离职、1正常）
     */
    private Boolean isActive;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
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

    public Integer getStaffLevel() {
        return staffLevel;
    }

    public void setStaffLevel(Integer staffLevel) {
        this.staffLevel = staffLevel;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
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

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
        ", id=" + id +
        ", name=" + name +
        ", birthday=" + birthday +
        ", gender=" + gender +
        ", adress=" + adress +
        ", mobile=" + mobile +
        ", idArd=" + idArd +
        ", employmentDate=" + employmentDate +
        ", staffLevel=" + staffLevel +
        ", emergencyContactName=" + emergencyContactName +
        ", emergencyContactMobile=" + emergencyContactMobile +
        ", isActive=" + isActive +
        ", createAt=" + createAt +
        ", updateAt=" + updateAt +
        "}";
    }
}
