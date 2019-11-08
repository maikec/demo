package com.demo;

import com.demo.mapper.BlogMapper;
import com.demo.po.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
        String environment = "development";
        environment = getProfile(args, environment);
        String configPath = "mybatis-config.xml";
        final InputStream resource = Resources.getResourceAsStream(configPath);
        final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource,environment);
        getData(sqlSessionFactory,2);


        final InputStream resource2 = Resources.getResourceAsStream(configPath);
        final SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(resource2,"development");
        getData(sqlSessionFactory2,1);

    }

    private static String getProfile(String[] args, String environment) {
        for (String arg : args) {
            final String[] key = arg.split(",");
            for (String tmp : key) {
                if (tmp.contains("profile")){
                    environment = tmp.split("=")[1];
                }
            }
        }
        return environment;
    }

    private static void getData(SqlSessionFactory sqlSessionFactory,Integer id) {
        try (final SqlSession sqlSession = sqlSessionFactory.openSession();) {
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            final Blog blog = mapper.selectBlogById(id);
            System.out.println(blog.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
