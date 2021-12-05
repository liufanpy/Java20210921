package com.itheima.mybatis.binding;


import com.itheima.mybatis.executor.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * 为mapper接口产生动态代理增强的具体实现
 */
public class MapperProxyFactory implements InvocationHandler{

    private Connection connection;
    private Map<String,Mapper> mappers;

    public MapperProxyFactory(Connection connection, Map<String, Mapper> mappers) {
        this.connection = connection;
        this.mappers = mappers;
    }

    /**
     * 我们需要在invoke中完成statement的拼接，然后从mappers中获取需要执行的sql语句；
     * 需要将结果封装返回；
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. 需要通过method获取 方法名 、 全限定名 --> statementId (key) --> 得到想要执行的sql
        // 1.1 获取方法名：
        String methodName = method.getName();
        // 1.2 获取全限定名：
        String className = method.getDeclaringClass().getName();
        // 1.3 拼接statementId
        String statementId = className + "." + methodName;  // "com.itheima.dao.UserMapper.findAll"

        // 2. 需要根据 不同的返回值类型，调用不同的executor方法：
        // 2.1 获取返回值类型
        Class<?> returnType = method.getReturnType();

        // 2.2 判断
        if (List.class == returnType){
            // 此时调用 selectList
            return new Executor().selectList(mappers.get(statementId),connection);
        }
        if (List.class != returnType){
            // 此时调用 selectOne
            return new Executor().selectOne(mappers.get(statementId),connection);
        }


        return method.invoke(new Object(),args);
    }
}
