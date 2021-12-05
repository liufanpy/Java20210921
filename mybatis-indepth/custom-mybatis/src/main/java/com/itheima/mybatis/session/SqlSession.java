package com.itheima.mybatis.session;


/**
 * 可以获取代理对象，用于执行sql
 */
public interface SqlSession {

    //获取代理对象
    <T> T getMapper(Class<T> type);

    //释放资源
    void close();

}
