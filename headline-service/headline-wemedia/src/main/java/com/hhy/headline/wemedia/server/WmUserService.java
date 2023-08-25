package com.hhy.headline.wemedia.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.wemedia.dtos.WmLoginDto;
import com.hhy.headline.model.wemedia.pojos.WmUser;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.server
 * @Date 2023/8/3 16:05
 * @return
 * @Version 1.0
 */
public interface WmUserService extends IService<WmUser> {

    /**
     * 自媒体端登录
     * @param dto
     * @return
     */
    public ResponseResult login(WmLoginDto dto);

}
