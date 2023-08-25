package com.hhy.headline.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.common.swagger
 * @Date 2023/7/27 10:53
 * @return
 * @Version 1.0
 * @description swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                // 要扫描的API(Controller)基础包
                .apis(RequestHandlerSelectors.basePackage("com.hhy"))
                .paths(PathSelectors.any())
                .build();
    }
    // 描述对象
    private ApiInfo buildApiInfo() {
        Contact contact = new Contact("HEADLINE","","");
        return new ApiInfoBuilder()
                .title("headline-平台管理API文档")
                .description("headline - 后台api")
                .contact(contact)
                .version("1.0.0").build();
    }
}
