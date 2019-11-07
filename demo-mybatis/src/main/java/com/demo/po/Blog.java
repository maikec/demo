package com.demo.po;

import lombok.Data;

import java.util.Date;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/7
 */
@Data
public class Blog {
    private Integer id;
    private String name;
    private String content;
    private Date createDate;
}
