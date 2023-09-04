package com.hhy.headline.wemedia.controller.v1;

import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.wemedia.dtos.WmMaterialDto;
import com.hhy.headline.wemedia.server.WmMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.controller.v1
 * @Date 2023/8/3 16:55
 * @return
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/v1/material")
public class WmMaterialController {
    @Autowired
    private WmMaterialService wmMaterialService;

    @PostMapping("/upload_picture")
    public ResponseResult uploadPicture(MultipartFile multipartFile){
        return wmMaterialService.uploadPicture(multipartFile);
    }

    @PostMapping("/list")
    public ResponseResult getPictureList(@RequestBody WmMaterialDto wmMaterialDto){

        return wmMaterialService.getPictureList(wmMaterialDto);
    }
    /**
     * @description:删除图片
     * @author: hhy
     * @date: 2023/8/30 16:33
     * @param: [id]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    @GetMapping("/del_picture/{id}")
    public ResponseResult delPicture(@PathVariable Integer id){

        return wmMaterialService.delPicture(id);
    }
    /**
     * @description:取消收藏方法
     * @author: hhy
     * @date: 2023/8/30 16:33
     * @param: [id]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    @GetMapping("/cancel_collect/{id}")
    public ResponseResult cancelCollect(@PathVariable Integer id){
        return wmMaterialService.cancelCollect(id);
    }
}
