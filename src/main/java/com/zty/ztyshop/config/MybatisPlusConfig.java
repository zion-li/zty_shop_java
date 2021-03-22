package com.zty.ztyshop.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mybatis-plus 插件配置
 *
 * @author 李佳 zion 18102466330@163.com
 * @version 1.0
 * @date 2019/4/17 14:20
 */
@Slf4j
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {

    @Bean
    public DruidDataSource dataSource(DruidProperties druidProperties) {
        log.info(">>> enable mysql");
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        paginationInterceptor.setDbType(DbType.MYSQL);
        return paginationInterceptor;
    }

    /**
     * 乐观锁mybatis插件，
     * 当要更新一条记录的时候，希望这条记录没有被别人更新
     * <p>
     * 取出记录时，获取当前version
     * 更新时，带上这个version
     * 执行更新时， set version = yourVersion+1 where version = yourVersion
     * 如果version不对，就更新失败
     * <p>
     * 使用@Version标注在实体类上，数据库添加一个字段就可以了
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
