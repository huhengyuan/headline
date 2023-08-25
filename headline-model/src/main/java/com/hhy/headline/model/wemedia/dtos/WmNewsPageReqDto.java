package com.hhy.headline.model.wemedia.dtos;

import com.hhy.headline.model.common.dtos.PageRequestDto;
import lombok.Data;

import java.util.Date;
/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.wemedia.dtos
 * @Date 2023/8/1 16:01
 * @return
 * @Version 1.0
 */
@Data
public class WmNewsPageReqDto extends PageRequestDto {

    /**
     * 状态
     */
    private Short status;
    /**
     * 开始时间
     */
    private Date beginPubDate;
    /**
     * 结束时间
     */
    private Date endPubDate;
    /**
     * 所属频道ID
     */
    private Integer channelId;
    /**
     * 关键字
     */
    private String keyword;
}
