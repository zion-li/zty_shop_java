package com.zty.ztyshop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientInfoParam;
import com.zty.ztyshop.controller.param.ClientLevelParam;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zty.ztyshop.dao.entity.ClientLevel;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public interface IClientInfoService extends IService<ClientInfo> {

    Boolean add(ClientInfoParam param);

    Boolean delete(ClientInfoParam param);

    Boolean update(ClientInfoParam param);

    Page<ClientInfo> page(BasePageParam param);
}
