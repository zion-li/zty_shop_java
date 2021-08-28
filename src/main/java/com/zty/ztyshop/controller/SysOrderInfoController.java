package com.zty.ztyshop.controller;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.OrderInfoParam;
import com.zty.ztyshop.service.SysOrderInfoService;
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
    public BaseResponseVO page(@RequestBody BasePageParam param) {
        return BaseResponseVO.success(orderInfoService.page(param));
    }


}

