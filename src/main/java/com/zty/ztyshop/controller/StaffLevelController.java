package com.zty.ztyshop.controller;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffLevelParam;
import com.zty.ztyshop.dao.entity.StaffLevel;
import com.zty.ztyshop.service.IStaffLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 员工职称
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/staffLevel")
public class StaffLevelController {

    @Autowired
    private IStaffLevelService levelService;

    /**
     * 增
     *
     * @param param
     * @return
     */
    @PostMapping("/add")
    public BaseResponseVO add(@RequestBody StaffLevelParam param) {
        return BaseResponseVO.success(levelService.add(param));
    }

    /**
     * 删
     *
     * @param param
     * @return
     */
    @PostMapping("/delete")
    public BaseResponseVO delete(@RequestBody StaffLevelParam param) {
        return BaseResponseVO.success(levelService.delete(param));
    }

    /**
     * 改
     *
     * @param param
     * @return
     */
    @PostMapping("/update")
    public BaseResponseVO update(@RequestBody StaffLevelParam param) {
        return BaseResponseVO.success(levelService.update(param));
    }

    /**
     * 列表
     *
     * @param param
     * @return
     */
    @GetMapping("/page")
    public BaseResponseVO page(@RequestBody BasePageParam param) {
        return BaseResponseVO.success(levelService.page(param));
    }

    /**
     * 所有
     *
     * @return
     */
    @GetMapping("/list")
    public BaseResponseVO list() {
        return BaseResponseVO.success(levelService.list());
    }


}
