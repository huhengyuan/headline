package com.hhy.headline.wemedia.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.headline.file.service.FileStorageService;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.common.enums.AppHttpCodeEnum;
import com.hhy.headline.model.wemedia.pojos.WmMaterial;
import com.hhy.headline.utils.common.thread.WmThreadLocalUtil;
import com.hhy.headline.wemedia.mapper.WmMaterialMapper;
import com.hhy.headline.wemedia.server.WmMaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.server.impl
 * @Date 2023/8/8 15:53
 * @return
 * @Version 1.0
 */
@Service
@Slf4j
@Transactional
public class WmMaterialServiceImpl extends ServiceImpl<WmMaterialMapper, WmMaterial> implements WmMaterialService {
    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public ResponseResult uploadPicture(MultipartFile multipartFile) {
        // 1. 检查参数
        if(multipartFile == null || multipartFile.getSize() == 0){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        // 2. 上传图片到minio
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = multipartFile.getOriginalFilename();
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileId = null;
        try {
            fileId = fileStorageService.uploadImgFile("", fileName + postfix, multipartFile.getInputStream());
            log.info("上传图片到MinIO中，fileId:{}",fileId);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("WmMaterialServiceImpl-上传文件失败");
        }
        // 3. 保存数据到数据库
        WmMaterial wmMaterial = new WmMaterial();
        wmMaterial.setUserId(WmThreadLocalUtil.getUser().getId());
        wmMaterial.setUrl(fileId);
        wmMaterial.setIsCollection((short)0);
        wmMaterial.setType((short)0);
        wmMaterial.setCreatedTime(new Date());
        // 保存到数据库
        save(wmMaterial);

        //4.返回结果
        return ResponseResult.okResult(wmMaterial);
    }
}
