package com.hhy.headline.search.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.search.config
 * @Date 2023/11/1 14:50
 * @return
 * @Version 1.0
 */
// 使用 Lombok 自动生成 Getter 和 Setter 方法
@Getter
@Setter
// 声明当前类为配置类
@Configuration
// 指定配置属性的前缀为 "elasticsearch"
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchConfig {
    // Elasticsearch 服务器的主机名
    private String host;
    // Elasticsearch 服务器的端口号
    private int port;

    // 定义一个 Bean 以提供 RestHighLevelClient 实例
    @Bean
    public RestHighLevelClient client(){
        // 打印主机名（这里可能会为空，具体取决于配置文件）
        System.out.println(host);
        // 打印端口号（这里可能会为0，具体取决于配置文件）
        System.out.println(port);

        // 创建并返回一个新的 RestHighLevelClient 实例
        return new RestHighLevelClient(RestClient.builder(
                new HttpHost(
                        host, // 使用配置的主机名
                        port, // 使用配置的端口号
                        "http" // 使用 http 协议
                )
        ));
    }
}

