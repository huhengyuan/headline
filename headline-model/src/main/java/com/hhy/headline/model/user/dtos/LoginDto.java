package com.hhy.headline.model.user.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.user.dtos
 * @Date 2023/7/26 17:16
 * @return
 * @Version 1.0
 * DTO（Data Transfer Object）：登录数据传输对象。
 */
@Data
public class LoginDto {

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号",required = true)
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
