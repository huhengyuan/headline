package com.hhy.headline.model.wemedia.dtos;

import com.hhy.headline.model.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.wemedia.dtos
 * @Date 2023/8/1 16:02
 * @return
 * @Version 1.0
 */
@Data
public class WmMaterialDto extends PageRequestDto {

    /**
     * 1 收藏
     * 0 未收藏
     */
    private Short isCollection;
}
