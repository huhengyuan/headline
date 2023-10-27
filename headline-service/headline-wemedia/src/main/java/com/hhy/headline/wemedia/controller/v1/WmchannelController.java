package com.hhy.headline.wemedia.controller.v1;

import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.wemedia.server.WmChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.controller.v1
 * @Date 2023/9/4 15:41
 * @return
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/v1/channel")
public class WmchannelController {
    @Autowired
    private WmChannelService wmChannelService;

    @GetMapping("/channels")
    public ResponseResult findAll(){
        return wmChannelService.findAll();
    }
}
