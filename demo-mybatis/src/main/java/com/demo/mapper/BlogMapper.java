package com.demo.mapper;

import com.demo.po.Blog;
import com.demo.repository.BlogRepository;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
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
    /**
     * 写入
     * @param blog
     * @return
     */
    Integer insertBlog(Blog blog);
    /**
     * 写入
     * @param blog
     * @return
     */
    Integer insertBlogWithoutId(Blog blog);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer deleteBlog(Integer id);
}
