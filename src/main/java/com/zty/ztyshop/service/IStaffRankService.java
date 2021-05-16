package com.zty.ztyshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zty.ztyshop.dao.entity.StaffRank;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-05-16
 */
public interface IStaffRankService extends IService<StaffRank> {

    /**
     * @return
     */
    List<StaffRank> getAll();
}
