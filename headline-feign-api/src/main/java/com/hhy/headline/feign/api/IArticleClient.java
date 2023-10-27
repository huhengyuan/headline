package com.hhy.headline.feign.api;

import com.hhy.headline.feign.api.fallback.IArticleClientFallback;
import com.hhy.headline.model.article.dtos.ArticleDto;
import com.hhy.headline.model.common.dtos.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.feign.api
 * @Date 2023/10/9 15:30
 * @return
 * @Version 1.0
 */
@FeignClient(value = "headline-article", fallback = IArticleClientFallback.class)
public interface IArticleClient {
    @PostMapping("/api/v1/article/save")
    public ResponseResult saveArticle(@RequestBody ArticleDto dto) ;
}
