package com.demo.plugin;
/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《大项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 除了用插件来修改 MyBatis 核心行为之外，还可以通过完全覆盖配置类来达到目的。只需继承后覆盖其中的每个方法，
 * 再把它传递到 SqlSessionFactoryBuilder.build(myConfig) 方法即可。再次重申，这可能会严重影响 MyBatis 的行为，
 * 务请慎之又慎
 *
 *
 * MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：
 *
 * Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
 * ParameterHandler (getParameterObject, setParameters)
 * ResultSetHandler (handleResultSets, handleOutputParameters)
 * StatementHandler (prepare, parameterize, batch, update, query)
 *  @author maikec
 *  @date 2019/11/7
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args ={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}
                )
})
public class DefaultPlugin implements Interceptor {
    private final Logger logger = LogManager.getLogger(DefaultPlugin.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("invocation method:{}",invocation.getMethod());
        final Object proceed = invocation.proceed();
        return proceed;
    }
}
