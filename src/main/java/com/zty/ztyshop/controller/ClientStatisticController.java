package com.zty.ztyshop.controller;

import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.service.IClientInfoService;
import com.zty.ztyshop.service.IClientRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/16 9:48
 */
@RestController
@RequestMapping("/clientStatistic")
public class ClientStatisticController {

    @Autowired
    private IClientInfoService clientInfoService;

    @Autowired
    private IClientRankService clientRankService;


    /**
     * 详情（30天新增用户）
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
     * 详情（30天新增用户）
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

//    /**
//     * 详情（30天老用户回访）
//     *
//     * @return
//     */
//    @GetMapping("/statisticsOldLast30Days")
//    public BaseResponseVO statisticsOldLast30Days(@RequestParam(required = false) Integer type) {
//        //1：月
//        return BaseResponseVO.success(clientInfoService.statisticsOldLast30Days(type));
//    }
//
//    /**
//     * 详情（最近12个月新增用户）
//     *
//     * @return
//     */
//    @GetMapping("/statisticsAll")
//    public BaseResponseVO statisticsAll(@RequestParam(required = false) Integer type) {
//        //1：月
//        return BaseResponseVO.success(clientInfoService.statisticsAll(type));
//    }

}
