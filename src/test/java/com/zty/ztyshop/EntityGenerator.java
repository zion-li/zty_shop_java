package com.zty.ztyshop;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据层内容生成
 */
public class EntityGenerator {

    // 1:【改】生成输出目录，定位到工程的java目录下
    private String outputDir = "D:\\0_Actual_Project\\zty-shop\\src\\main\\java";
    // 生成类的作者
    private String author = "李佳 zion";
    // 2:【改】数据源相关配置
    private String url = "jdbc:mysql://127.0.0.1:3306/db_zty?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=UTC";
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String userName = "root";
    private String userPwd = "root";
    // 3：【改】DAO的包路径
    private String daoPackage = "com.zty.ztyshop.dao";
    // 4：【改】待生成的表名，注意是覆盖更新
    private static String[] tableNames;


    static {
        tableNames = new String[]{
                //影片模块
                "client_info"
                ,"client_rank",
                "order_info",
                "staff_info",
                "staff_rank",
                "sys_user"
        };
    }

    @Test
    public void entityGenerator() {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new BeetlTemplateEngine());
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);
        gc.setAuthor(author);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(userPwd);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //5：【改】此处可以修改为您的表前缀
        //strategy.setTablePrefix(new String[]{"_"});
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tableNames);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setEntity(daoPackage + ".entity");
        pc.setMapper(daoPackage + ".mapper");
        pc.setXml(daoPackage + ".mapper.xml");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        mpg.setCfg(cfg);
        // 执行生成
        mpg.execute();
        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
