package com.hhy.headline.model.schedule.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.schedule.dtos
 * @Date 2023/10/26 16:14
 * @return
 * @Version 1.0
 */
@Data
public class Task implements Serializable {

    /**
     * 任务id
     */
    private Long taskId;
    /**
     * 类型
     */
    private Integer taskType;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 执行id
     */
    private long executeTime;

    /**
     * task参数
     */
    private byte[] parameters;

}
