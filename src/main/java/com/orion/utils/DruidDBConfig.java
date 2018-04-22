package com.orion.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LLC on 2018/4/5.
 */
@Configuration
public class DruidDBConfig {
    @Bean(destroyMethod = "close",initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource DruidDBConfig(){
        return new DruidDataSource();
    }
}
