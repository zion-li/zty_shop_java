package com.zty.ztyshop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.OrderInfoParam;
import com.zty.ztyshop.controller.vo.OrderInfoVO;
import com.zty.ztyshop.controller.vo.StaffServeStatisticVO;
import com.zty.ztyshop.dao.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public interface SysOrderInfoService extends IService<OrderInfo> {

    Boolean add(OrderInfoParam param);

    Boolean delete(OrderInfoParam param);

    Boolean update(OrderInfoParam param);

    Page<OrderInfoVO> page(BasePageParam param);
}
