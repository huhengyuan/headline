package com.hhy.headline.common.constants;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.common.constants
 * @Date 2023/10/26 16:17
 * @return
 * @Version 1.0
 */
public class ScheduleConstants {

    //task状态
    public static final int SCHEDULED=0;   //初始化状态

    public static final int EXECUTED=1;       //已执行状态

    public static final int CANCELLED=2;   //已取消状态

    public static String FUTURE="future_";   //未来数据key前缀

    public static String TOPIC="topic_";     //当前数据key前缀
}