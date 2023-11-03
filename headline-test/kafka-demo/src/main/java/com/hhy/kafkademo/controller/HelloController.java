package com.hhy.kafkademo.controller;

import com.alibaba.fastjson.JSON;
import com.hhy.kafkademo.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.kafkademo.controller
 * @Date 2023/10/30 14:33
 * @return
 * @Version 1.0
 */
@RestController
public class HelloController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @GetMapping("/hello")
    public String hello(){
        kafkaTemplate.send("headline","测试进行中！");
        User u = new User("小刘", 18);
        kafkaTemplate.send("user", JSON.toJSONString(u));
        return "success";
    }
}
