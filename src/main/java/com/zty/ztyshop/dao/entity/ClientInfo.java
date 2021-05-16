package com.zty.ztyshop.dao.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-05-16
 */
@Data
public class ClientInfo extends Model<ClientInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 顾客姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String modile;

    /**
     * 用户等级
     */
    private String rankName;

    /**
     * 性别（0女、1男）
     */
    private Integer gender;

    /**
     * 顾客生日
     */
    private LocalDate birthday;

    /**
     * 总体消费
     */
    private BigDecimal account;

    /**
     * 最近一次到店时间
     */
    private LocalDateTime lastLogin;

    /**
     * 服务次数
     */
    private Integer serviceTime;
}
