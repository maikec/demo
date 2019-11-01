package com.example.demo.invoke;
/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《大项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 说明
 *  @author maikec
 *  @date 2019/10/25
 */
public class FooInvocationHandler implements InvocationHandler{

    private final Object target;
    public FooInvocationHandler(Object target){
        this.target = target;
    };
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return  method.invoke(target,args);
    }
}
