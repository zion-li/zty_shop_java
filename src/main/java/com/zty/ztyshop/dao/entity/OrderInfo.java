package com.zty.ztyshop.dao.entity;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-11-25
 */
@Data
@ToString
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
     * 本次消费金额
     */
    private BigDecimal account;

    /**
     * 现金业绩-类型
     */
    private String cashType;

    /**
     * 现金业绩
     */
    private BigDecimal cashAccount;

    /**
     * 现金业绩
     */
    private BigDecimal cashAccountAssistant;

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
     * 营养业绩
     */
    private BigDecimal cashYy;

    private Integer cashYyAssistant;

    /**
     * 水洗业绩
     */
    private BigDecimal cashSx;

    private Integer cashSxAssistant;

    /**
     * 速焗业绩
     */
    private BigDecimal cashSj;

    private Integer cashSjAssistant;

    /**
     * 商品业绩
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
     * 更新时间
     */
    private LocalDateTime updateAt;

    /**
     * 是否作废
     */
    private Boolean isDelete;
}
