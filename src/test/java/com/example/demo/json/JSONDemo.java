package com.example.demo.json;
/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《大项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/8
 */
public class JSONDemo {
    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper(); // can use static singleton, inject: just make sure to reuse!
        Map<String, String> t = new HashMap<>();
        t.putIfAbsent("id","1");
        t.putIfAbsent("name","3");

        final String string = mapper.writeValueAsString(t);
        final MyValue myValue = mapper.readValue(string, MyValue.class);
        System.out.println(myValue.getId());
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class MyValue {
        MyValue(){}
        MyValue(Integer id, String name){
            this.id = id;
            this.name = name;
        }
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }
}
