package com.itheima.mybatis.session;


import com.itheima.mybatis.builder.XMLConfigBuilder;

import java.io.InputStream;

/**
 * sqlsession工厂的构建器
 */
public class SqlSessionFactoryBuilder {


    /**构建sqlsession工厂
     * @param in
     * @return
     */
    public SqlSessionFactory build(InputStream in) {

        Configuration configuration = XMLConfigBuilder.parseConfiguration(in);
        DefaultSqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(configuration);
        return sessionFactory;

    }
}
