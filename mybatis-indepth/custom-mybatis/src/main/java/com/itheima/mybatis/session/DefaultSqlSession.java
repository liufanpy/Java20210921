package com.itheima.mybatis.session;

import com.itheima.mybatis.binding.Mapper;
import com.itheima.mybatis.binding.MapperProxyFactory;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class DefaultSqlSession implements  SqlSession {

    private Connection connection;
    private Map<String,Mapper> mappers;

    public DefaultSqlSession(Connection connection, Map<String, Mapper> mappers) {
        this.connection = connection;
        this.mappers = mappers;
    }

    /**
     * 获取代理对象：
     *          通过JDK的proxy生成代理对象，对dao接口创建动态代理实现
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> type) {

        return (T) Proxy.newProxyInstance(
                // 参数1： 固定写法 --> 类加载器
                type.getClassLoader(),
                //参数2： 固定写法 --> 接口数组
                new Class[]{type},
                // 参数3： 真正需要增强的逻辑
                new MapperProxyFactory(connection,mappers)
        );

    }


    /**
     * 释放资源
     */
    @Override
    public void close() {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
