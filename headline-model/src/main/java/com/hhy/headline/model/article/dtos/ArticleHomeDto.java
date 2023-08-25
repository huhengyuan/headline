package com.hhy.headline.model.article.dtos;

import lombok.Data;

import java.util.Date;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.article.dtos
 * @Date 2023/7/28 16:31
 * @return
 * @Version 1.0
 * @description 文章主页传输对象
 */
@Data
public class ArticleHomeDto {

    // 最大时间
    Date maxBehotTime;
    // 最小时间
    Date minBehotTime;
    // 分页size
    Integer size;
    // 频道ID
    String tag;
}
