package com.zty.ztyshop.controller;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientLevelParam;
import com.zty.ztyshop.controller.param.StaffLevelParam;
import com.zty.ztyshop.service.IClientLevelService;
import com.zty.ztyshop.service.IStaffLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.rmi.server.RMIClientSocketFactory;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/clientLevel")
public class ClientLevelController {
    @Autowired
    private IClientLevelService clientLevelService;

    /**
     * 增
     *
     * @param param
     * @return
     */
    @PostMapping("/add")
    public BaseResponseVO add(@RequestBody ClientLevelParam param) {
        return BaseResponseVO.success(clientLevelService.add(param));
    }

    /**
     * 删
     *
     * @param param
     * @return
     */
    @PostMapping("/delete")
    public BaseResponseVO delete(@RequestBody ClientLevelParam param) {
        return BaseResponseVO.success(clientLevelService.delete(param));
    }

    /**
     * 改
     *
     * @param param
     * @return
     */
    @PostMapping("/update")
    public BaseResponseVO update(@RequestBody ClientLevelParam param) {
        return BaseResponseVO.success(clientLevelService.update(param));
    }

    /**
     * 列表
     *
     * @param param
     * @return
     */
    @GetMapping("/page")
    public BaseResponseVO page(@RequestBody BasePageParam param) {
        return BaseResponseVO.success(clientLevelService.page(param));
    }

    /**
     * 所有
     *
     * @return
     */
    @GetMapping("/list")
    public BaseResponseVO list() {
        return BaseResponseVO.success(clientLevelService.list());
    }

}
