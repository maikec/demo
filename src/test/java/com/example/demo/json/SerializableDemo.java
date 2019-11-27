package com.example.demo.json;
/**
 * 公司名称
 * <p>
 * 本源代码由《demo》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import cn.hutool.json.JSONUtil;
import com.example.demo.basic.Page;
import com.example.demo.basic.Stu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/27
 */
public class SerializableDemo {
    public static void main(String[] args) throws JsonProcessingException {
        final Page page = new Page();
        page.setTotal(1);
        page.setPage(2);
        page.setPageNum(10);
        final List<Stu> list = new LinkedList<>();
        list.add(new Stu(1, "maikec"));
        list.add(new Stu(2, "maikec"));
        page.setList(list);

        System.out.println(page);

        final ObjectMapper objectMapper = new ObjectMapper();
        final String s = objectMapper.writeValueAsString(page);
        System.out.println(s);

        final String toJsonPrettyStr = JSONUtil.toJsonPrettyStr(page);
        System.out.println(toJsonPrettyStr);
    }
}