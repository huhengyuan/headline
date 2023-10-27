package com.hhy.headline.model.wemedia.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.model.wemedia.pojos
 * @Date 2023/8/1 11:50
 * @return
 * @Version 1.0
 * @description 频道信息表
 */
@TableName("wm_channel")
@Data
public class WmChannel implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * @description:频道名称
     * @author: hhy
     * @date: 2023/8/1 15:47
     * @param:
     * @return:
     **/
    @TableField("name")
    private String name;
    /**
     * @description:频道描述
     * @author: hhy
     * @date: 2023/8/1 15:47
     * @param:
     * @return:
     **/
    @TableField("description")
    private String description;
    /**
     * @description:是否是默认频道 1-默认-true；0-非默认-false
     * @author: hhy
     * @date: 2023/8/1 15:49
     * @param:
     * @return:
     **/
    @TableField("is_default")
    private Boolean isDefault;
    /**
     * @description:是否禁用 1-启用-true；0-禁用-false
     * @author: hhy
     * @date: 2023/8/1 15:50
     * @param:
     * @return:
     **/
    @TableField("status")
    private Boolean status;
    /**
     * @description:默认排序
     * @author: hhy
     * @date: 2023/8/1 15:51
     * @param:
     * @return:
     **/
    @TableField("ord")
    private Integer ord;
    /**
     * @description:创建时间
     * @author: hhy
     * @date: 2023/8/1 15:52
     * @param:
     * @return:
     **/
    @TableField("created_time")
    private Date createdTime;
}
