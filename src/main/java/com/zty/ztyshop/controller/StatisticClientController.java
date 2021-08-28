package com.zty.ztyshop.controller;

import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.service.StaticClientInfoService;
import com.zty.ztyshop.service.SysClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/16 9:48
 */
@RestController
@RequestMapping("/clientStatistic")
public class StatisticClientController {

    @Autowired
    private StaticClientInfoService clientInfoService;

    /**
     * 总用户数
     *
     * @return
     */
    @GetMapping("/statisticsAll")
    public BaseResponseVO statisticsAll() {
        return BaseResponseVO.success(clientInfoService.count());
    }


    /**
     * 详情（7天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsLast7Days")
    public BaseResponseVO statisticsLast7Days() {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsLast7Days());
    }

    /**
     * 详情（30天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsLast30Days")
    public BaseResponseVO statisticsLast30Days() {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsLast30Days());
    }

    /**
     * 详情（90天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsLast90Days")
    public BaseResponseVO statisticsLast90Days() {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsLast90Days());
    }

    /**
     * 详情（365天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsLast365Days")
    public BaseResponseVO statisticsLast365Days() {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsLast365Days());
    }

    /**
     * 详情（7天回访用户）
     *
     * @return
     */
    @GetMapping("/statisticsReturn7Days")
    public BaseResponseVO statisticsReturn7Days() {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsReturn7Days());
    }

    /**
     * 详情（30天回访用户）
     *
     * @return
     */
    @GetMapping("/statisticsReturn30Days")
    public BaseResponseVO statisticsReturn30Days() {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsReturn30Days());
    }

    /**
     * 详情（90天回访用户）
     *
     * @return
     */
    @GetMapping("/statisticsReturn90Days")
    public BaseResponseVO statisticsReturn90Days() {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsReturn90Days());
    }

    /**
     * 详情（365天回访用户）
     *
     * @return
     */
    @GetMapping("/statisticsReturn365Days")
    public BaseResponseVO statisticsReturn365Days() {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsReturn365Days());
    }

}
