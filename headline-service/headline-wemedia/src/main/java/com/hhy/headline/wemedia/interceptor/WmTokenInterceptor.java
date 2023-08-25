package com.hhy.headline.wemedia.interceptor;

import com.hhy.headline.model.wemedia.pojos.WmUser;
import com.hhy.headline.utils.common.thread.WmThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.interceptor
 * @Date 2023/8/3 16:44
 * @return
 * @Version 1.0
 * @description 拦截器，用于从header中的token中获取用户信息放在ThreadLocal
 *
 */
@Slf4j
public class WmTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //得到header中的信息
        String userId = request.getHeader("userId");
        Optional<String> optional = Optional.ofNullable(userId);
        if(optional.isPresent()){
            //把用户id存入ThreadLocal中
            WmUser wmUser = new WmUser();
            wmUser.setId(Integer.valueOf(userId));
            WmThreadLocalUtil.setUser(wmUser);
            log.info("wmTokenFilter设置用户信息到ThreadLocal中...");
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("清理ThreadLocal...");
        WmThreadLocalUtil.clear();
    }
}
