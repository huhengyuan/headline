package com.hhy.headline.schedule.service;

import com.hhy.headline.model.schedule.dtos.Task;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.schedule.service
 * @Date 2023/10/26 16:15
 * @return
 * @Version 1.0
 */
public interface TaskService {

    /**
     * 添加任务
     * @param task   任务对象
     * @return       任务id
     */
    public long addTask(Task task) ;

    /**
     * 取消任务
     * @param taskId
     * @return
     */
    public boolean cancelTask(long taskId);

    /**
     * 按照类型和优先级拉取任务
     * @param type
     * @param priority
     * @return
     */
    public Task poll(int type,int priority);

}
