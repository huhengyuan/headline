package com.hhy.headline.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.user.dtos.LoginDto;
import com.hhy.headline.model.user.pojos.ApUser;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.user.service
 * @Date 2023/7/26 17:27
 * @return
 * @Version 1.0
 */
public interface ApUserService extends IService<ApUser> {
    /**
     * app端登录
     * @param dto
     * @return
     */
    public ResponseResult login(LoginDto dto);
}
