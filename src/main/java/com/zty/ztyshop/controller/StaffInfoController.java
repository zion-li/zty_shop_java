package com.zty.ztyshop.controller;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffInfoParam;
import com.zty.ztyshop.service.IStaffInfoService;
import com.zty.ztyshop.service.IStaffRankService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StaffInfoController {

    @Autowired
    private IStaffInfoService infoService;

    @Autowired
    private IStaffRankService staffRankService;

    /**
     * 等级信息
     *
     * @return
     */
    @GetMapping("/rank")
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
    public BaseResponseVO update(@RequestBody StaffInfoParam param) {

        return BaseResponseVO.success(infoService.update(param));
    }

    /**
     * 列表
     *
     * @param param
     * @return
     */
    @GetMapping("/page")
    public BaseResponseVO page(@RequestBody BasePageParam param) {
        return BaseResponseVO.success(infoService.page(param));
    }

    /**
     * 所有
     *
     * @return
     */
    @GetMapping("/list")
    public BaseResponseVO list() {
        return BaseResponseVO.success(infoService.getAll());
    }
}
