package com.hhy.headline.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.headline.model.article.dtos.ArticleDto;
import com.hhy.headline.model.article.dtos.ArticleHomeDto;
import com.hhy.headline.model.article.pojos.ApArticle;
import com.hhy.headline.model.common.dtos.ResponseResult;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.article.service
 * @Date 2023/7/28 16:59
 * @return
 * @Version 1.0
 */

public interface ApArticleService extends IService<ApArticle> {
    /**
     * 根据参数加载文章列表
     * @param loadtype 1为加载更多  2为加载最新
     * @param dto
     * @return
     */
    ResponseResult load(Short loadtype, ArticleHomeDto dto);

    ResponseResult saveArticle(ArticleDto dto);
}
