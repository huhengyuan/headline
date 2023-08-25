package com.hhy.headline.wemedia.controller.v1;

import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.wemedia.server.WmMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
