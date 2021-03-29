package com.zty.ztyshop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientLevelParam;
import com.zty.ztyshop.controller.param.StaffLevelParam;
import com.zty.ztyshop.dao.entity.ClientLevel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zty.ztyshop.dao.entity.StaffLevel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public interface IClientLevelService extends IService<ClientLevel> {

    Boolean add(ClientLevelParam param);

    Boolean delete(ClientLevelParam param);

    Boolean update(ClientLevelParam param);

    Page<ClientLevel> page(BasePageParam param);

}
