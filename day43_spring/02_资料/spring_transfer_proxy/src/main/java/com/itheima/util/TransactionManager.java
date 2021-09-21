package com.itheima.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class TransactionManager {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    //需要注入一个连接池
    @Autowired
    private DataSource dataSource;

    /**
     * 开启事务
     */
    public void startTransaction() throws Exception{
        //1.创建连接对象
        Connection connection = dataSource.getConnection();
        //2.开启事务
        connection.setAutoCommit(false);
        //3.使用ThreadLocal对象，把连接绑定到当前线程上
        tl.set(connection);
    }

    /**
     * 从当前线程上获取绑定的那个连接对象
     */
    public Connection getConnection(){
        return tl.get();
    }

    /**
     * 提交事务并关闭连接
     */
    public void commitAndClose(){
        try {
            //从当前线程上获取连接
            Connection connection = tl.get();
            //提交事务
            connection.commit();
            //关闭连接
            connection.close();
            //把连接从当前线程上清理掉
            tl.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务并关闭连接
     */
    public void rollbackAndClose(){
        try {
            //从当前线程上获取连接
            Connection connection = tl.get();
            //回滚事务
            connection.rollback();
            //关闭连接
            connection.close();
            //把连接从当前线程上清理掉
            tl.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}