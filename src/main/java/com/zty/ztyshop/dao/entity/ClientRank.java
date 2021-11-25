package com.zty.ztyshop.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
/**
 * <p>
 * 客户等级表
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-11-25
 */
@Data
@ToString
public class ClientRank extends Model<ClientRank> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 级别名称
     */
    private String name;
}
