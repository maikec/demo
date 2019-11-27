package com.example.demo.basic;
/**
 * 公司名称
 * <p>
 * 本源代码由《demo》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import java.io.Serializable;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/28
 */
public class Stu implements Serializable {
    public Stu(Integer id, String name) {
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
