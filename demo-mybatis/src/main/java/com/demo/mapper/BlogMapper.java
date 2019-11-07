package com.demo.mapper;

import com.demo.po.Blog;
import org.apache.ibatis.annotations.Select;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/7
 */
public interface BlogMapper<PO extends Blog> {
    /**
     * 获取博客
     * @param id
     * @return
     */
    PO selectBlogById(Integer id);

    /**
     * 获取博客
     * @param id
     * @return
     */
    @Select("SELECT * FROM blog WHERE id = #{id}")
    PO selectBlog(Integer id);
}
