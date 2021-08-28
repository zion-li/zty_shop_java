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
 * @date 2021/5/23 19:45
 */
@RestController
@RequestMapping("/staffStatistic")
public class StatisticStaffController {

    @Autowired
    private StaticOrderInfoService orderInfoService;

    //统计每个发型师，今天服务多少个用户，
    @GetMapping("/statistics1Days")
    public BaseResponseVO statistics1Days() {
        return BaseResponseVO.success(orderInfoService.statistics1Days());
    }

    @GetMapping("/statistics7Days")
    public BaseResponseVO statistics7Days() {
        return BaseResponseVO.success(orderInfoService.statistics7Days());
    }

    @GetMapping("/statistics30Days")
    public BaseResponseVO statistics30Days() {
        return BaseResponseVO.success(orderInfoService.statistics30Days());
    }

    @GetMapping("/statistics90Days")
    public BaseResponseVO statistics90Days() {
        return BaseResponseVO.success(orderInfoService.statistics90Days());
    }

    @GetMapping("/statistics365Days")
    public BaseResponseVO statistics365Days() {
        return BaseResponseVO.success(orderInfoService.statistics365Days());
    }
}
