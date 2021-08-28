package com.zty.ztyshop.controller;

import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.service.StaticOrderInfoService;
import com.zty.ztyshop.service.SysOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/23 14:48
 */
@RestController
@RequestMapping("/orderStatistic")
public class StatisticOrderInfoController {

    @Autowired
    private StaticOrderInfoService orderInfoService;

    /**
     * 总订单数
     *
     * @return
     */
    @GetMapping("/statisticsAll")
    public BaseResponseVO statisticsAll() {
        return BaseResponseVO.success(orderInfoService.count());
    }

    /**
     * @return
     */
    @GetMapping("/statisticsAccountAll")
    public BaseResponseVO statisticsAccountAll() {
        return BaseResponseVO.success(orderInfoService.accountAll());
    }

    /**
     * 详情（7天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsLast7Days")
    public BaseResponseVO statisticsLast7Days() {
        //1：月
        return BaseResponseVO.success(orderInfoService.statisticsLast7Days());
    }

    /**
     * 详情（30天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsLast30Days")
    public BaseResponseVO statisticsLast30Days() {
        //1：月
        return BaseResponseVO.success(orderInfoService.statisticsLast30Days());
    }

    /**
     * 详情（90天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsLast90Days")
    public BaseResponseVO statisticsLast90Days() {
        //1：月
        return BaseResponseVO.success(orderInfoService.statisticsLast90Days());
    }

    /**
     * 详情（365天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsLast365Days")
    public BaseResponseVO statisticsLast365Days() {
        //1：月
        return BaseResponseVO.success(orderInfoService.statisticsLast365Days());
    }
}
