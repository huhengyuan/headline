package com.hhy.headline.article.controller.v1;

import com.hhy.headline.article.service.ApArticleService;
import com.hhy.headline.common.constants.ArticleConstants;
import com.hhy.headline.model.article.dtos.ArticleHomeDto;
import com.hhy.headline.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.article.controller.v1
 * @Date 2023/7/28 16:33
 * @return
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController {
    @Autowired
    private ApArticleService apArticleService;
    /**加载首页
     * @description:
     * @author: hhy
     * @date: 2023/7/28 16:37
     * @param: [dto]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    @PostMapping("/load")
    public ResponseResult load(@RequestBody ArticleHomeDto dto) {
        return apArticleService.load(ArticleConstants.LOADTYPE_LOAD_MORE,dto);
    }
    /**加载更多
     * @description:
     * @author: hhy
     * @date: 2023/7/28 16:37
     * @param: [dto]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    @PostMapping("/loadmore")
    public ResponseResult loadMore(@RequestBody ArticleHomeDto dto) {
        return apArticleService.load(ArticleConstants.LOADTYPE_LOAD_MORE,dto);
    }
    /**加载最新
     * @description:
     * @author: hhy
     * @date: 2023/7/28 16:37
     * @param: [dto]
     * @return: com.hhy.headline.model.common.dtos.ResponseResult
     **/
    @PostMapping("/loadnew")
    public ResponseResult loadNew(@RequestBody ArticleHomeDto dto) {
        return apArticleService.load(ArticleConstants.LOADTYPE_LOAD_NEW,dto);
    }
}
