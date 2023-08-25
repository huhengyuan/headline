package com.hhy.headline.utils.common.thread;

import com.hhy.headline.model.wemedia.pojos.WmUser;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.utils.common.thread
 * @Date 2023/8/3 16:38
 * @return
 * @Version 1.0
 * @description 自媒体微服务使用拦截器获取到header中的的用户信息，并放入到threadlocal
 * 本地线程用于存放从token获取的用户信息
 */
public class WmThreadLocalUtil {
    private final static ThreadLocal<WmUser> WM_USER_THREAD_LOCAL = new ThreadLocal<>();
    /**
     * 添加用户
     * @param wmUser
     */
    public static void  setUser(WmUser wmUser){
        WM_USER_THREAD_LOCAL.set(wmUser);
    }
    /**
     * 获取用户
     */
    public static WmUser getUser(){
        return WM_USER_THREAD_LOCAL.get();
    }

    /**
     * 清理用户
     */
    public static void clear(){
        WM_USER_THREAD_LOCAL.remove();
    }
}
