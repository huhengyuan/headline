package com.hhy.headline.schedule.mapper;

import com.hhy.headline.model.schedule.pojos.Taskinfo;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.schedule.mapper
 * @Date 2023/10/26 16:20
 * @return
 * @Version 1.0
 */
@Mapper
public interface TaskinfoMapper extends BaseMapper<Taskinfo> {

    public List<Taskinfo> queryFutureTime(@Param("taskType")int type, @Param("priority")int priority, @Param("future") Date future);
}
