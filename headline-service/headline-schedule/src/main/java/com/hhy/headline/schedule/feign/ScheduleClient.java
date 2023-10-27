package com.hhy.headline.schedule.feign;

import com.hhy.headline.feign.api.schedule.IScheduleClient;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.schedule.dtos.Task;
import com.hhy.headline.schedule.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.schedule.feign
 * @Date 2023/10/26 16:23
 * @return
 * @Version 1.0
 */
@RestController
public class ScheduleClient implements IScheduleClient {
    @Autowired
    private TaskService taskService;
    /**
     * 添加延迟任务
     *
     * @param task
     * @return
     */
    @PostMapping("/api/v1/task/add")
    public ResponseResult addTask(@RequestBody Task task) {
        return ResponseResult.okResult(taskService.addTask(task));
    }

    /**
     * 取消任务
     *
     * @param taskId
     * @return
     */
    @GetMapping("/api/v1/task/{taskId}")
    public ResponseResult cancelTask(@PathVariable("taskId") long taskId){
        return ResponseResult.okResult(taskService.cancelTask(taskId));
    }

    /**
     * 按照类型和优先级拉取任务
     *
     * @param type
     * @param priority
     * @return
     */
    @GetMapping("/api/v1/task/{type}/{priority}")
    public ResponseResult poll(@PathVariable("type") int type,@PathVariable("priority") int priority) {
        return ResponseResult.okResult(taskService.poll(type,priority));
    }
}
