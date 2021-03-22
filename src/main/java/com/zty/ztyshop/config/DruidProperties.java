package com.zty.ztyshop.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * @author 李佳 zion 18102466330@163.com
 * @version 1.0
 * @date 2019/4/17 14:20
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidProperties {

    private String url;

    private String username;

    private String password;

    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    /**
     * 初始化配置
     */
    private Integer initialSize = 2;
    /**
     * 最小连接数
     * ** 连接池中的最小空闲连接数，Druid会定时扫描连接池的连接，如果空闲的连接数大于该值，则关闭多余的连接，
     * ** 反之则创建更多的连接以满足最小连接数要求
     */
    private Integer minIdle = 1;
    /**
     * 最大连接数,
     * 推荐配置：20，多数场景下 20 已完全够用，当然这个参数跟使用场景相关性很大，
     * 【重点】：一般配置成正常连接数的 3~5 倍。
     * 理解：
     * **** 连接池中的最大连接数 ==>这三部分的连接总和不能超过maxActive；
     * ****     activeCount：正在使用的连接；
     * ****     poolingCount：连接池中的空闲连接；
     * ****     createTaskCount：正在生成的连接；
     */
    private Integer maxActive = 20;
    /**
     * 获取连接超时时间（单位：ms）这个参数只管理获取连接的超时
     * 推荐配置：内网(网络状况好) 800；网络状况不是特别好的情况下推荐大于等于 1200，因为 tcp 建连重试一般是 1 秒。
     */
    private Integer maxWait = 60000;
    /**
     * 连接有效性检测时间(单位:ms)，空闲连接回收的时间间隔，默认：60000L
     * 作用详解：（）
     * *作为DestroyTask执行的时间周期
     * **判断连接池的连接空闲数是否大于minIdle，如果是则关闭多余的连接，反之则新增连接
     * **回收连接池泄露的连接
     */
    private Integer timeBetweenEvictionRunsMillis = 60000;
    /**
     * 最小生存的时间(单位ms)，(默认：1800000L）
     * 注意：
     * **if (minEvictableIdleTimeMillis < 30000L){
     * ******LOG.error("minEvictableIdleTimeMillis should be greater than 30000");
     * **}
     * <p>
     * 理解：
     * **** 非运行中的连接数》minIdle && 非运行时间 > minEvictableIdleTimeMillis，设置成Idle状态并关闭；
     */
    private Integer minEvictableIdleTimeMillis = 300000;

    private String validationQuery = "SELECT 'x'";
    /**
     * 是否开启对空闲连接的检查
     */
    private Boolean testWhileIdle = true;
    /**
     * 获取连接检测
     */
    private Boolean testOnBorrow = false;
    /**
     * 归还连接检测
     */
    private Boolean testOnReturn = false;
    /**
     * 打开PSCache，并且指定每个连接上PSCache的大小
     */
    private Boolean poolPreparedStatements = true;

    private Integer maxPoolPreparedStatementPerConnectionSize = 20;

    private String filters = "stat,wall,log4j2";

    public void config(DruidDataSource dataSource) {

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setDriverClassName(driverClassName);
        //定义初始连接数
        dataSource.setInitialSize(initialSize);
        //最小空闲
        dataSource.setMinIdle(minIdle);
        //定义最大连接数
        dataSource.setMaxActive(maxActive);

        //最长等待时间
        dataSource.setMaxWait(maxWait);

        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);

        // 打开PSCache，并且指定每个连接上PSCache的大小
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
