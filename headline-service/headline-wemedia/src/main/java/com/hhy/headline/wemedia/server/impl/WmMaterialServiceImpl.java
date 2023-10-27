package com.hhy.headline.wemedia.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.headline.file.service.FileStorageService;
import com.hhy.headline.model.common.dtos.PageResponseResult;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.common.enums.AppHttpCodeEnum;
import com.hhy.headline.model.wemedia.dtos.WmMaterialDto;
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
    @Autowired
    private WmMaterialMapper wmMaterialMapper;

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
        log.info("保存图片信息：", wmMaterial);
        save(wmMaterial);

        //4.返回结果
        return ResponseResult.okResult(wmMaterial);
    }
    /**
     * @description: 素材列表查询
     * @author: hhy
     * @date: 2023/8/25 16:58
     * @param: [wmMaterialDto]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    @Override
    public ResponseResult getPictureList(WmMaterialDto wmMaterialDto) {
        // 1. 检查参数，page 和 size
        wmMaterialDto.checkParam();
        // 2. 分页查询
        IPage page = new Page(wmMaterialDto.getPage(),wmMaterialDto.getSize());
        LambdaQueryWrapper<WmMaterial> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //是否收藏
        if(wmMaterialDto.getIsCollection() != null && wmMaterialDto.getIsCollection() == 1){
            lambdaQueryWrapper.eq(WmMaterial::getIsCollection,wmMaterialDto.getIsCollection());
        }

        //按照用户查询
        lambdaQueryWrapper.eq(WmMaterial::getUserId,WmThreadLocalUtil.getUser().getId());

        //按照时间倒序
        lambdaQueryWrapper.orderByDesc(WmMaterial::getCreatedTime);


        page = page(page,lambdaQueryWrapper);

        //3.结果返回
        ResponseResult responseResult = new PageResponseResult(wmMaterialDto.getPage(),wmMaterialDto.getSize(),(int)page.getTotal());
        responseResult.setData(page.getRecords());
        return responseResult;
    }

    @Override
    public ResponseResult delPicture(Integer id) {
        QueryWrapper<WmMaterial> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);

        int deletedRows = wmMaterialMapper.delete(queryWrapper);
        if (deletedRows > 0) {
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
        } else {
            return ResponseResult.errorResult(-1, "删除图片失败或图片不存在！");
        }
    }
    private final Short COLLECTED = 1;
    private final  Short NOT_COLLECTED = 0;
    @Override
    public ResponseResult cancelCollect(Integer id) {
        // QueryWrapper<WmMaterial> queryWrapper = new QueryWrapper<>();
        WmMaterial wmMaterial = wmMaterialMapper.selectById(id);
        if (wmMaterial == null) {
            return ResponseResult.errorResult(-1, "图片不存在！");
        }
        // 切换收藏状态
        wmMaterial.setIsCollection(wmMaterial.getIsCollection() == COLLECTED
                ? NOT_COLLECTED : COLLECTED);
        int updatedRows = wmMaterialMapper.updateById(wmMaterial);
        if (updatedRows > 0) {
            return ResponseResult.okResult(200,
                    wmMaterial.getIsCollection() == COLLECTED ? "收藏成功" : "取消收藏成功");
        } else {
            return ResponseResult.errorResult(-1, "操作失败");
        }
    }
}
