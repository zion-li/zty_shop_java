package com.zty.ztyshop.common;


import lombok.Data;

/**
 * 分页请求类
 *
 * @author 李佳 zion 18102466330@163.com
 * @version 1.0
 * @date 2019/4/17 13:36
 */
@Data
public class BasePageVO extends BaseRequestVO {

    private Integer nowPage = 1;
    private Integer pageSize = 10;

    @Override
    public void checkParam() throws BaseException {
        return;
    }
}
