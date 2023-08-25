package com.hhy.headline.wemedia.controller.v1;

import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.wemedia.dtos.WmLoginDto;
import com.hhy.headline.wemedia.server.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.controller.v1
 * @Date 2023/8/3 16:09
 * @return
 * @Version 1.0
 */

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private WmUserService wmUserService;

    @PostMapping("/in")
    public ResponseResult login(@RequestBody WmLoginDto dto){
        return wmUserService.login(dto);
    }
}
