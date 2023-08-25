package com.hhy.headline.wemedia.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HeadlineWemediaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeadlineWemediaGatewayApplication.class, args);
    }

}
