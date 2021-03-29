package com.zty.ztyshop.controller;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientInfoParam;
import com.zty.ztyshop.controller.param.ClientLevelParam;
import com.zty.ztyshop.service.IClientInfoService;
import com.zty.ztyshop.service.IClientLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/clientInfo")
public class ClientInfoController {
    @Autowired
    private IClientInfoService clientInfoService;

    /**
     * 增
     *
     * @param param
     * @return
     */
    @PostMapping("/add")
    public BaseResponseVO add(@RequestBody ClientInfoParam param) {
        return BaseResponseVO.success(clientInfoService.add(param));
    }

    /**
     * 删
     *
     * @param param
     * @return
     */
    @PostMapping("/delete")
    public BaseResponseVO delete(@RequestBody ClientInfoParam param) {
        return BaseResponseVO.success(clientInfoService.delete(param));
    }

    /**
     * 改
     *
     * @param param
     * @return
     */
    @PostMapping("/update")
    public BaseResponseVO update(@RequestBody ClientInfoParam param) {
        return BaseResponseVO.success(clientInfoService.update(param));
    }

    /**
     * 列表
     *
     * @param param
     * @return
     */
    @GetMapping("/page")
    public BaseResponseVO page(@RequestBody BasePageParam param) {
        return BaseResponseVO.success(clientInfoService.page(param));
    }

    /**
     * 所有
     *
     * @return
     */
    @GetMapping("/list")
    public BaseResponseVO list() {
        return BaseResponseVO.success(clientInfoService.list());
    }


    /**
     * 详情
     *
     * @return
     */
    @GetMapping("/{id}")
    public BaseResponseVO list(@PathVariable("id") String id) {
        return BaseResponseVO.success(clientInfoService.getById(Integer.parseInt(id)));
    }


    /**
     * 详情（30天新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsNewLast30Days")
    public BaseResponseVO statisticsLast30Days(@RequestParam(required = false) Integer type) {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsNewLast30Days(type));
    }

    /**
     * 详情（30天老用户回访）
     *
     * @return
     */
    @GetMapping("/statisticsOldLast30Days")
    public BaseResponseVO statisticsOldLast30Days(@RequestParam(required = false) Integer type) {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsOldLast30Days(type));
    }

    /**
     * 详情（最近12个月新增用户）
     *
     * @return
     */
    @GetMapping("/statisticsAll")
    public BaseResponseVO statisticsAll(@RequestParam(required = false) Integer type) {
        //1：月
        return BaseResponseVO.success(clientInfoService.statisticsAll(type));
    }

}
