package com.demo.repository;

import com.demo.annotation.Column;
import com.demo.mapper.BaseMapper;
import com.demo.mapper.BlogMapper;
import com.demo.po.Blog;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.Alias;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/8
 */
@NoArgsConstructor
public class BlogRepository<PO extends Blog> implements BlogMapper<Blog>, BaseMapper {
    @Setter
    private SqlSessionFactory sqlSessionFactory;
    public BlogRepository(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Blog selectBlogById(Integer id) {
        return sqlSessionFactory.openSession(true)
                .getMapper(BlogMapper.class).selectBlogById(id);
    }

    @Override
    public Blog selectBlog(Integer id) {
        return null;
    }

    @Override
    public Integer insertBlog(Blog blog) {
        return null;
    }

    @Override
    public Integer insertBlogWithoutId(Blog blog) {
        return null;
    }

    @Override
    public Integer deleteBlog(Integer id) {
        return null;
    }

    @Override
    public Integer insertBlog() {
        return null;
    }

    public String insert(){
        return new SQL().INSERT_INTO("blog")
                .VALUES("name","name")
                .VALUES("type","1").toString();
    }
}
