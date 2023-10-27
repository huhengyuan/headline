package com.hhy.headline.schedule.redis;

import com.hhy.headline.common.redis.CacheService;
import com.hhy.headline.schedule.HeadlineScheduleApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.schedule.redis
 * @Date 2023/10/26 15:49
 * @return
 * @Version 1.0
 */
@SpringBootTest(classes = HeadlineScheduleApplication.class)
@RunWith(SpringRunner.class)
public class redisTest {
    @Autowired
    private CacheService cacheService;

    @Test
    public void testList(){

        //在list的左边添加元素
        cacheService.lLeftPush("list_001","hello,redis");

        //在list的右边获取元素，并删除
//        String list_001 = cacheService.lRightPop("list_001");
//        System.out.println(list_001);
    }
    @Test
    public void testZset(){
        //添加数据到zset中  分值
        cacheService.zAdd("zset_key_001","hello zset 001",1000);
        cacheService.zAdd("zset_key_001","hello zset 002",8888);
        cacheService.zAdd("zset_key_001","hello zset 003",7777);
        cacheService.zAdd("zset_key_001","hello zset 004",999999);

        //按照分值获取数据
        Set<String> zset_key_001 = cacheService.zRangeByScore("zset_key_001", 0, 8888);
        System.out.println(zset_key_001);


    }
}
