package com.zty.ztyshop.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/27 10:56
 */
@Data
@ApiModel(value = "分页参数", description = "分页参数")
public class BasePageParam {

    @Min(value = 1,message = "分页参数不合法")
    @ApiModelProperty(value = "当前页", name = "pageNo")
    private Integer pageNo;

    @ApiModelProperty(value = "每页记录数", name = "pageSize")
    @Max(value = 100,message = "分页参数不合法")
    private Integer pageSize;
}
