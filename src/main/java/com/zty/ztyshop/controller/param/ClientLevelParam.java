package com.zty.ztyshop.controller.param;

import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/29 9:27
 */
@Data
public class ClientLevelParam {

    private Integer id;

    /**
     * 区间最小值（包含）
     */
    private Integer min;

    /**
     * 区间最大值（不包含)
     */
    private Integer max;

    /**
     * 级别名称
     */
    private String name;

    /**
     * 英文标识
     */
    private String englishName;

}
