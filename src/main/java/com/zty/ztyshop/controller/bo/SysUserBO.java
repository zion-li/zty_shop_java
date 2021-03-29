package com.zty.ztyshop.controller.bo;

import com.zty.ztyshop.dao.entity.SysUser;
import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/27 10:33
 */
@Data
public class SysUserBO extends SysUser {

    private String token;

}
