package com.hhy.headline.wemedia.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.config
 * @Date 2023/10/9 16:00
 * @return
 * @Version 1.0
 */
@Component
@MapperScan("com.hhy.headline.feign.api.fallback")
public class InitConfig {

}
