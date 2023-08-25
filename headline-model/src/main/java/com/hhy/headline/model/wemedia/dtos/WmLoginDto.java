package com.hhy.headline.model.wemedia.dtos;

import lombok.Data;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.wemedia.dtos
 * @Date 2023/8/1 16:03
 * @return
 * @Version 1.0
 */
@Data
public class WmLoginDto {

    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
}
