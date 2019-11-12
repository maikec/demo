package com.demo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/7
 */
@Alias("blog")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog extends BasePO {
    private String name;
    private String content;
    private Integer type;
}
