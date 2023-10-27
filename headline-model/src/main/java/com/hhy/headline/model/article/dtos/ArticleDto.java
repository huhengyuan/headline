package com.hhy.headline.model.article.dtos;

import com.hhy.headline.model.article.pojos.ApArticle;
import lombok.Data;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.article.dtos
 * @Date 2023/10/9 15:27
 * @return
 * @Version 1.0
 */
@Data
public class ArticleDto extends ApArticle {
    /**
     * 文章内容
     */
    private String content;
}
