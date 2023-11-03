package com.hhy.kafkademo.listener;

import com.alibaba.fastjson.JSON;
import com.hhy.kafkademo.pojos.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.kafkademo.listener
 * @Date 2023/10/30 14:36
 * @return
 * @Version 1.0
 */
@Component
public class HelloListener {
    @KafkaListener(topics = "user")
    public void handleMessage(String msg){
        if(!StringUtils.isEmpty(msg)){
            System.out.println(msg);
            User user = JSON.parseObject(msg, User.class);
            System.out.println(user);
        }
    }
}
