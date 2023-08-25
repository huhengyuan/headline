package com.hhy.headline.wemedia.config;

import com.hhy.headline.wemedia.interceptor.WmTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.config
 * @Date 2023/8/3 16:53
 * @return
 * @Version 1.0
 * @description 配置使拦截器生效，拦截所有的请求
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WmTokenInterceptor()).addPathPatterns("/**");
    }
}
