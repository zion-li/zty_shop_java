package com.zty.ztyshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zty.ztyshop.controller.vo.StaffServeStatisticVO;
import com.zty.ztyshop.dao.entity.OrderInfo;

import java.util.List;
import java.util.Map;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/8/28 11:27
 */
public interface StaticOrderInfoService extends IService<OrderInfo> {
    //总金额
    String accountAll();

    Map<String, Integer> statisticsLast7Days();

    Map<String, Integer> statisticsLast30Days();

    Map<String, Integer> statisticsLast90Days();

    Map<String, Integer> statisticsLast365Days();

    List<StaffServeStatisticVO> statistics1Days();

    List<StaffServeStatisticVO> statistics7Days();

    List<StaffServeStatisticVO> statistics30Days();

    List<StaffServeStatisticVO> statistics90Days();

    List<StaffServeStatisticVO> statistics365Days();
}
