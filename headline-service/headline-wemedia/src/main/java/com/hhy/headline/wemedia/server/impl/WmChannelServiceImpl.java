package com.hhy.headline.wemedia.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.wemedia.pojos.WmChannel;
import com.hhy.headline.wemedia.mapper.WmChannelMapper;
import com.hhy.headline.wemedia.server.WmChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.server.impl
 * @Date 2023/9/4 15:45
 * @return
 * @Version 1.0
 */
@Service
@Transactional
@Slf4j
public class WmChannelServiceImpl extends ServiceImpl<WmChannelMapper, WmChannel> implements WmChannelService {
    /**
     * 查询所有频道
     * @return
     */
    @Override
    public ResponseResult findAll() {
        return ResponseResult.okResult(list());
    }
}
