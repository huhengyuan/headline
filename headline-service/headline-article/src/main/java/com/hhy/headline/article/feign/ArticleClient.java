package com.hhy.headline.article.feign;

import com.hhy.headline.article.service.ApArticleService;
import com.hhy.headline.feign.api.IArticleClient;
import com.hhy.headline.model.article.dtos.ArticleDto;
import com.hhy.headline.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.article.feign
 * @Date 2023/10/9 15:34
 * @return
 * @Version 1.0
 */
@RestController
public class ArticleClient implements IArticleClient {
    @Autowired
    private ApArticleService apArticleService;

    @Override
    @PostMapping("/api/v1/article/save")
    public ResponseResult saveArticle(@RequestBody ArticleDto dto) {
        return apArticleService.saveArticle(dto);
    }
}
