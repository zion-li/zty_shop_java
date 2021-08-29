package com.zty.ztyshop.controller;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffInfoParam;
import com.zty.ztyshop.service.SysStaffInfoService;
import com.zty.ztyshop.service.SysStaffRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 职工 前端控制器
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/staffInfo")
@Api(value = "管理员--职工管理", tags = "管理员--职工管理")
public class SysStaffInfoController {

    /**
     * 员工信息
     */
    @Autowired
    private SysStaffInfoService infoService;

    /**
     * 员工职称
     */
    @Autowired
    private SysStaffRankService staffRankService;

    /**
     * 职称信息
     *
     * @return
     */
    @GetMapping("/rank")
    @ApiOperation(value = "员工-所有员工的分类", notes = "员工-所有员工的分类")
    public BaseResponseVO rank() {
        return BaseResponseVO.success(staffRankService.getAll());
    }

    /**
     * 新增
     *
     * @param param
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "员工-新增", notes = "员工-新增")
    public BaseResponseVO add(@RequestBody StaffInfoParam param) {
        return BaseResponseVO.success(infoService.add(param));
    }

    /**
     * 删
     *
     * @param param
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation(value = "员工-删除", notes = "员工-删除")
    public BaseResponseVO delete(@RequestBody StaffInfoParam param) {
        return BaseResponseVO.success(infoService.delete(param));
    }

    /**
     * 改
     *
     * @param param
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "员工-更新", notes = "员工-更新")
    public BaseResponseVO update(@RequestBody StaffInfoParam param) {

        return BaseResponseVO.success(infoService.update(param));
    }

    /**
     * 列表
     *
     * @param param
     * @return
     */
    @PostMapping("/page")
    @ApiOperation(value = "员工-分页列表", notes = "员工-分页列表")
    public BaseResponseVO page(@RequestBody @Validated BasePageParam param) {
        return BaseResponseVO.success(infoService.page(param));
    }

    /**
     * 所有
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "员工-所有列表", notes = "员工-所有列表")
    public BaseResponseVO list() {
        return BaseResponseVO.success(infoService.getAll());
    }
}
