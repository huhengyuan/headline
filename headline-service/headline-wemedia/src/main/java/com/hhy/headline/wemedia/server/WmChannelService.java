package com.hhy.headline.wemedia.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.wemedia.pojos.WmChannel;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.server
 * @Date 2023/9/4 15:44
 * @return
 * @Version 1.0
 */
public interface WmChannelService extends IService<WmChannel> {
    /**
     * 查询所有频道
     * @return
     */
    public ResponseResult findAll();
}
