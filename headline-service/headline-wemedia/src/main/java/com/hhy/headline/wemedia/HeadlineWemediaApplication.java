package com.hhy.headline.wemedia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hhy.headline.wemedia.mapper")
public class HeadlineWemediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeadlineWemediaApplication.class, args);
    }

}
