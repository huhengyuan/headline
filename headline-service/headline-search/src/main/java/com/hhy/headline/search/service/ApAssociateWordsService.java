package com.hhy.headline.search.service;


import com.hhy.headline.model.common.dtos.ResponseResult;
import com.hhy.headline.model.search.dtos.UserSearchDto;

public interface ApAssociateWordsService {

    /**
     * 搜索联想词
     * @param dto
     * @return
     */
    public ResponseResult search(UserSearchDto dto);
}
