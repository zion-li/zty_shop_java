package com.zty.ztyshop.controller;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.zty.ztyshop.common.BaseEnum;
import com.zty.ztyshop.common.BaseException;
import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientInfoParam;
import com.zty.ztyshop.service.SysClientInfoService;
import com.zty.ztyshop.service.SysClientRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
@Api(value = "管理员--客户管理", tags = "管理员--客户管理")
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
    @ApiOperation(value = "客户-等级查询", notes = "客户-等级查询")
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
    @ApiOperation(value = "客户-新增客户", notes = "客户-新增客户")
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
    @ApiOperation(value = "客户-删除客户", notes = "客户-删除客户")
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
    @ApiOperation(value = "客户-更改客户", notes = "客户-更改客户")
    public BaseResponseVO update(@RequestBody ClientInfoParam param) {
        return BaseResponseVO.success(clientInfoService.update(param));
    }

    /**
     * 列表
     *
     * @param param
     * @return
     */
    @PostMapping("/page")
    @ApiOperation(value = "客户-分页查询客户", notes = "客户-分页查询客户")
    public BaseResponseVO page(@RequestBody BasePageParam param) {
        return BaseResponseVO.success(clientInfoService.page(param));
    }

    /**
     * 所有
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "客户-查询所有", notes = "客户-查询所有")
    public BaseResponseVO list() {
        return BaseResponseVO.success(clientInfoService.getAll());
    }


    /**
     * 详情
     *
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "客户-查询单个客户详情", notes = "客户-查询单个客户详情")
    public BaseResponseVO getInfo(@PathVariable("id") String id) {
        return BaseResponseVO.success(clientInfoService.getById(Integer.parseInt(id)));
    }

    /**
     * 通过手机号查询用户信息
     *
     * @return
     */
    @GetMapping("/search")
    @ApiOperation(value = "客户-通过手机号查询用户信息(创建订单的时候，快速搜索用户)", notes = "客户-通过手机号查询用户信息")
    public BaseResponseVO search(@RequestParam("modile") String modile) {

        if (StringUtils.isBlank(modile)) {
            throw new BaseException(BaseEnum.PHONE_ERROR);
        }

        return BaseResponseVO.success(clientInfoService.searchByModile(modile));
    }
}
