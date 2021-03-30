package com.zty.ztyshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffInfoParam;
import com.zty.ztyshop.controller.param.StaffLevelParam;
import com.zty.ztyshop.controller.vo.StaffInfoVO;
import com.zty.ztyshop.dao.entity.StaffInfo;
import com.zty.ztyshop.dao.entity.StaffLevel;
import com.zty.ztyshop.service.IStaffInfoService;
import com.zty.ztyshop.service.IStaffLevelService;
import com.zty.ztyshop.utils.CaffeineUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
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
    private IStaffLevelService levelService;

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

        return BaseResponseVO.success(infoService.updateStaffInfo(param));
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

        List<StaffLevel> staffLevels = levelService.list();

        List<StaffInfo> staffInfos = infoService.list();

        List<StaffInfoVO> res = Lists.newArrayList();

        if (!CollectionUtils.isEmpty(staffInfos)) {
            for (StaffInfo s : staffInfos) {

                StaffInfoVO per = new StaffInfoVO();
                BeanUtils.copyProperties(s, per);
                if (!CollectionUtils.isEmpty(staffLevels)) {
                    for (StaffLevel level : staffLevels) {
                        if (s.getStaffLevel().intValue() == level.getId().intValue()) {
                            per.setStaffName(level.getName());
                            break;
                        }
                    }
                }

                res.add(per);
            }


        }

        return BaseResponseVO.success(res);
    }
}
