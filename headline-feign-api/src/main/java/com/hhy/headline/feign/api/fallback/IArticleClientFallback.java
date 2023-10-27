package com.hhy.headline.feign.api.fallback;

import com.hhy.headline.feign.api.IArticleClient;
import com.hhy.headline.model.article.dtos.ArticleDto;
import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.common.enums.AppHttpCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.feign.api.fallback
 * @Date 2023/10/9 15:56
 * @return
 * @Version 1.0
 */
@Component
public class IArticleClientFallback implements IArticleClient {
    @Override
    public ResponseResult saveArticle(ArticleDto dto) {
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR,"获取数据失败");
    }
}
