package com.hhy.headline.wemedia.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.wemedia.pojos.WmMaterial;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.server
 * @Date 2023/8/8 15:50
 * @return
 * @Version 1.0
 */
public interface WmMaterialService extends IService<WmMaterial> {
    /**
     * @description:图片上传
     * @author: hhy
     * @date: 2023/8/8 15:52
     * @param: [multipartFile]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    public ResponseResult uploadPicture(MultipartFile multipartFile);
}
