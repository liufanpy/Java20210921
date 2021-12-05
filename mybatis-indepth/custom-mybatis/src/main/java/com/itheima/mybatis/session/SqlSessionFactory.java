package com.itheima.mybatis.session;


/**
 * sqlsession工厂接口
 */
public interface SqlSessionFactory {

    public SqlSession openSession();
}
