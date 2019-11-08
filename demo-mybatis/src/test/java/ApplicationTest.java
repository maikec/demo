import com.demo.mapper.BlogMapper;
import com.demo.po.Blog;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/7
 */
public class ApplicationTest {
    SqlSessionFactory build;
    @Before
    public void init() throws IOException {
        final Properties properties = Resources.getResourceAsProperties("database.properties");
        final PooledDataSource pooledDataSource = new PooledDataSource(
                properties.getProperty("driver","com.mysql.cj.jdbc.Driver"),
                properties.getProperty("url",
                        "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false"),
                properties.getProperty("username","root"),
                properties.getProperty("password","root")
                );

        final JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", jdbcTransactionFactory,  pooledDataSource);
        final Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(true);
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        configuration.setDefaultStatementTimeout(3);
        configuration.setLogPrefix("mybatisLog");

        build = new SqlSessionFactoryBuilder().build(configuration);
    }
    @Test
    public void  selectBlog(){
        final BlogMapper blogMapper = build.openSession().getMapper(BlogMapper.class);
        final Blog blog = blogMapper.selectBlog(1);
        Assert.assertEquals("maikec",blog.getName());
    }
}
