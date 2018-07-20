package com.orion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by LLC on 2017/10/22.
 */
@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@MapperScan("com.orion.mapper")
public class SpringBootAction {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAction.class,args);
    }
}
