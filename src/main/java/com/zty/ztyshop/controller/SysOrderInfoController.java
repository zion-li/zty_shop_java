package com.zty.ztyshop.controller;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.OrderInfoParam;
import com.zty.ztyshop.service.SysOrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/orderInfo")
@Api(value = "管理员--订单管理", tags = "管理员--订单管理")
public class SysOrderInfoController {

    @Autowired
    private SysOrderInfoService orderInfoService;


    /**
     * 新增
     *
     * @param param
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "订单-新增订单", notes = "订单-新增订单")
    public BaseResponseVO add(@RequestBody OrderInfoParam param) {
        return BaseResponseVO.success(orderInfoService.add(param));
    }

    /**
     * 删
     *
     * @param param
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation(value = "订单-删除订单", notes = "订单-删除订单")
    public BaseResponseVO delete(@RequestBody OrderInfoParam param) {
        return BaseResponseVO.success(orderInfoService.delete(param));
    }

    /**
     * 改
     *
     * @param param
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "订单-更改订单", notes = "订单-更改订单")
    public BaseResponseVO update(@RequestBody OrderInfoParam param) {
        return BaseResponseVO.success(orderInfoService.update(param));
    }

    /**
     * 列表
     *
     * @param param
     * @return
     */
    @GetMapping("/page")
    @ApiOperation(value = "订单-分页列表", notes = "订单-分页订单")
    public BaseResponseVO page(@RequestBody BasePageParam param) {
        return BaseResponseVO.success(orderInfoService.page(param));
    }


}

