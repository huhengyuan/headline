package com.hhy.headline.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hhy.headline.model.user.pojos.ApUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.user.mapper
 * @Date 2023/7/26 17:25
 * @return
 * @Version 1.0
 * user -- 数据持久层
 */
@Mapper
public interface ApUserMapper extends BaseMapper<ApUser> {
}
