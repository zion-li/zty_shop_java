package com.zty.ztyshop.controller.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/27 11:07
 */
@Data
public class StaffLevelParam {

    private Integer id;

    /**
     * 职称名
     */
    private String name;

    /**
     * 是否激活
     */
    private Integer isActive;
}
