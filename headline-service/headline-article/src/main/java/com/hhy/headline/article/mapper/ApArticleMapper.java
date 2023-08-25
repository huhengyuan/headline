package com.hhy.headline.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hhy.headline.model.article.dtos.ArticleHomeDto;
import com.hhy.headline.model.article.pojos.ApArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.article.mapper
 * @Date 2023/7/28 16:38
 * @return
 * @Version 1.0
 */
@Mapper
public interface ApArticleMapper extends BaseMapper<ApArticle> {
    /**
     * @description: 加载文章列表
     * @author: hhy
     * @date: 2023/7/28 16:42
     * @param: [dto, type]  1-加载更多；2-加载最新
     * @return: java.util.List<com.hhy.headline.model.article.pojos.ApArticle>
     **/
    public List<ApArticle> loadArticleList(@Param("dto")ArticleHomeDto dto, @Param("type")Short type );
}
