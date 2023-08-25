package com.hhy.freemarker.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.freemarker.entity
 * @Date 2023/7/28 17:45
 * @return
 * @Version 1.0
 */
@Data
public class Student {
    private String name;//姓名
    private int age;//年龄
    private Date birthday;//生日
    private Float money;//钱包
}