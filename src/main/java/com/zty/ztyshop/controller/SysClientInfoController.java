package com.zty.ztyshop.controller;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientInfoParam;
import com.zty.ztyshop.service.SysClientInfoService;
import com.zty.ztyshop.service.SysClientRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
public class SysClientInfoController {

    //客户信息
    @Autowired
    private SysClientInfoService clientInfoService;

    //等级
    @Autowired
    private SysClientRankService clientRankService;

    /**
     * 等级信息
     *
     * @return
     */
    @GetMapping("/rank")
    public BaseResponseVO add() {
        return BaseResponseVO.success(clientRankService.getAll());
    }

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
        return BaseResponseVO.success(clientInfoService.getAll());
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
}
