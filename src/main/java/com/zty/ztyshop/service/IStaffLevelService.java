package com.zty.ztyshop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffLevelParam;
import com.zty.ztyshop.dao.entity.StaffLevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public interface IStaffLevelService extends IService<StaffLevel> {
    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    Page<StaffLevel> page(BasePageParam param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    Boolean update(StaffLevelParam param);

    /**
     * 删除
     *
     * @param param
     * @return
     */
    Boolean delete(StaffLevelParam param);

    /**
     * add
     *
     * @param param
     * @return
     */
    Boolean add(StaffLevelParam param);
}
