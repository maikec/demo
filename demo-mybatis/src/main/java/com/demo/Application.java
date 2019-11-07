package com.demo;

import cn.hutool.db.ds.DSFactory;
import cn.hutool.setting.Setting;
import com.demo.mapper.BlogMapper;
import com.demo.po.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/7
 */
public class Application {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String configPath = "mybatis-config.xml";
        final InputStream resource = Resources.getResourceAsStream(configPath);
        final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        try ( final SqlSession sqlSession = sqlSessionFactory.openSession();){
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            final Blog blog = mapper.selectBlogById(1);
            System.out.println(blog.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
