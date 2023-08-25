package com.hhy.headline.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.common.enums.AppHttpCodeEnum;
import com.hhy.headline.model.user.dtos.LoginDto;
import com.hhy.headline.model.user.pojos.ApUser;
import com.hhy.headline.user.mapper.ApUserMapper;
import com.hhy.headline.user.service.ApUserService;
import com.hhy.headline.utils.common.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.user.service.impl
 * @Date 2023/7/26 17:28
 * @return
 * @Version 1.0
 *  apuser -- 业务实现类
 */
@Service
// 开启事务
@Transactional
// 日志注解
@Slf4j
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser> implements ApUserService {
    /**
     * @description: 登录方法实现
     * @author: hhy
     * @date: 2023/7/27 10:27
     * @param: [dto] -- DTO（Data Transfer Object）：用户数据传输对象
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    @Override
    public ResponseResult login(LoginDto dto) {
        // 1. 正常用户登录
        if(!StringUtils.isBlank(dto.getPassword()) && !StringUtils.isBlank(dto.getPhone())){
            //1.1 查询用户
            // getOne是MyBatis-Plus中的一个方法，用于执行数据库查询操作,从数据库中获取满足条件的一条数据记录
            // Wrappers是MyBatis-Plus提供的一个查询构造器工具类。lambdaQuery()表示创建一个lambda查询对象，用于构建条件查询。
            // eq表示等于操作，ApUser::getPhone表示获取ApUser对象中的phone字段，dto.getPhone()表示从另一个对象dto中获取phone字段的值。
            ApUser apUser = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, dto.getPhone()));
            if (apUser == null) {
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户信息不存在!");
            }
            // 1.2 密码校对
            String salt = apUser.getSalt();
            String password = dto.getPassword();
            password = DigestUtils.md5DigestAsHex((password + salt).getBytes());
            if(!password.equals(apUser.getPassword())){
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
            //1.3 返回数据  jwt
            Map<String, Object> map = new HashMap<>();
            // 存放token
            map.put("token", AppJwtUtil.getToken(apUser.getId().longValue()));
            // 将salt和password置空
            apUser.setSalt("");
            apUser.setPassword("");
            map.put("user", apUser);
            return ResponseResult.okResult(map);
        }else{
            // 2. 游客登录  同样返回token id为0
            Map<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0L));
            return ResponseResult.okResult(map);
        }
    }
}
