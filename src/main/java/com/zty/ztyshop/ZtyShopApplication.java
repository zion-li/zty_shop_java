package com.zty.ztyshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zty.ztyshop.dao.mapper")
public class ZtyShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZtyShopApplication.class, args);
    }

}
