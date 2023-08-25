package com.hhy.headline.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 集成注册中心
@EnableDiscoveryClient
// mp包扫描
@MapperScan("com.hhy.headline.user.mapper")
public class HeadlineUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeadlineUserApplication.class, args);
    }

}
