package com.demo;

import com.demo.mapper.BlogMapper;
import com.demo.po.Blog;
import com.demo.repository.BlogRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

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
        doDemo(sqlSessionFactory,2);


//        final InputStream resource2 = Resources.getResourceAsStream(configPath);
//        final SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(resource2,"development");
//        getData(sqlSessionFactory2,1);

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

    private static void doDemo(SqlSessionFactory sqlSessionFactory,Integer id) {
        try (final SqlSession sqlSession = sqlSessionFactory.openSession();) {

            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//
            insertBlogWithoutId(mapper,sqlSession);


//            final BlogRepository<Blog> repository = new BlogRepository<>(sqlSessionFactory);
//            System.out.println(repository.selectBlogById(2));
//
//            repository.insertBlog();

//            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//
//            insertBlogWithoutId(mapper,sqlSession);

//            final Blog blog = mapper.selectBlogById(id);
//            System.out.println(blog.getName());
//
//            if (null != blog.getId()) {
//                final Integer integer = mapper.deleteBlog(id);
//                sqlSession.commit();
//            }
//
//            blog.setCreateDate(LocalDateTime.now());
//            final Integer integer = mapper.insertBlog(blog);
//            insertBlogWithoutId(mapper,sqlSession);
//            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertBlogWithoutId(BlogMapper mapper, SqlSession sqlSession) {
        final Blog blog = Blog.builder().name("withoutId").content("11")
                .type(1).build();
        blog.setCreateDate(LocalDateTime.now());
        final Integer integer = mapper.insertBlogWithoutId(blog);
        sqlSession.commit();
    }

}
