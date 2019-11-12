package com.demo.plugin;
/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《大项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Statement;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/8
 */
@Intercepts({
        @Signature(type = StatementHandler.class,method = "update",
                args = {Statement.class}
                )
})
public class UpdatePlugin implements Interceptor {
    private final Logger logger = LogManager.getLogger(UpdatePlugin.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("UpdatePlugin:{}",invocation.getMethod());
        final Object proceed = invocation.proceed();
        return 11111;
    }
}
