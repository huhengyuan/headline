package com.hhy.headline.wemedia.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.wemedia.dtos.WmNewsDto;
import com.hhy.headline.model.wemedia.dtos.WmNewsPageReqDto;
import com.hhy.headline.model.wemedia.pojos.WmNews;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.wemedia.server
 * @Date 2023/9/9 16:43
 * @return
 * @Version 1.0
 */
public interface WmNewsService extends IService<WmNews> {
    /**
     * @description: 查询文件，分页
     * @author: hhy
     * @date: 2023/9/9 16:46
     * @param: [dto]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    public ResponseResult findAll(WmNewsPageReqDto dto);

    /**
     * @description: 发布文章或者保存草稿
     * @author: hhy
     * @date: 2023/9/9 19:32
     * @param: [dto]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    public ResponseResult submitNews(WmNewsDto dto);

}
