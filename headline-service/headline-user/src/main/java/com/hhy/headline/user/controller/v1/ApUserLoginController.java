package com.hhy.headline.user.controller.v1;

import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.user.dtos.LoginDto;
import com.hhy.headline.user.service.ApUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.user.controller.v1
 * @Date 2023/7/26 17:21
 * @return
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/v1/login")
@Api(value = "app端用户登录", tags = "ap_user", description = "app端用户登录API")
public class ApUserLoginController {

    @Autowired
    private ApUserService apUserService;

    @PostMapping("login_auth")
    @ApiOperation("用户登录")
    public ResponseResult login(@RequestBody LoginDto loginDto){
        return apUserService.login(loginDto);
    }
}
