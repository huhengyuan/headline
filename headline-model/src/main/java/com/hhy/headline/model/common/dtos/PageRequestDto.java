package com.hhy.headline.model.common.dtos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.common.dtos
 * @Date 2023/7/22 19:37
 * @return
 * @Version 1.0
 */
@Data
@Slf4j
public class PageRequestDto {

    protected Integer size;
    protected Integer page;

    public void checkParam() {
        if (this.page == null || this.page < 0) {
            setPage(1);
        }
        if (this.size == null || this.size < 0 || this.size > 100) {
            setSize(10);
        }
    }
}
