package com.hhy.headline.search.service;



import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.search.dtos.UserSearchDto;

import java.io.IOException;

public interface ArticleSearchService {

    /**
     * es文章分页检索
     * @param dto
     * @return
     */
    public ResponseResult search(UserSearchDto dto) throws IOException;
}
