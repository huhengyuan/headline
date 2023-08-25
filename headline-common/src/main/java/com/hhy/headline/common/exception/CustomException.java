package com.hhy.headline.common.exception;

import com.hhy.headline.model.common.enums.AppHttpCodeEnum;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.common.exception
 * @Date 2023/7/22 19:16
 * @return
 * @Version 1.0
 */
public class CustomException extends RuntimeException {

    private AppHttpCodeEnum appHttpCodeEnum;

    public CustomException(AppHttpCodeEnum appHttpCodeEnum){
        this.appHttpCodeEnum = appHttpCodeEnum;
    }

    public AppHttpCodeEnum getAppHttpCodeEnum() {
        return appHttpCodeEnum;
    }
}
