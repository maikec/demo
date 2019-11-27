package com.example.demo.basic;
/**
 * 公司名称
 * <p>
 * 本源代码由《demo》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */


import java.util.List;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/28
 */
public class Page {
    private Integer num;

    public Integer getPageNum() {
        return num;
    }

    public void setPageNum(Integer num) {
        this.num = num;
    }

    public List<Stu> getList() {
        return list;
    }

    public void setList(List<Stu> list) {
        this.list = list;
    }

    private List<Stu> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    private Integer total;
    private Integer page;
    class Sort{

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }
}