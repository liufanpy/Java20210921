package com.itheima.mybatis.session;


import com.itheima.mybatis.util.JdbcUtil;

/**
 * sqlsession工厂的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {


    private  Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 创建sqlsession对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        // 通过传入 connection  mappers 创建sqlsession对象：
        DefaultSqlSession sqlSession = new DefaultSqlSession(JdbcUtil.getConnection(configuration), configuration.getMappers());

        return sqlSession;
    }
}
