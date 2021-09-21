package com.itheima.web;

import com.itheima.utils.C3P0Utils;

import java.sql.Connection;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/7 15:36
 */
public class ConnectionManager {
    // 创建ThreadLocal对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    // 提供一个方法获得连接对象
    public static Connection getConnection() throws Exception{
        // 获取ThreadLocal中的值(连接对象)
        Connection connection = threadLocal.get();

        // 没有获取到Connection对象,就添加一个Connection对象
        if (connection == null){
            connection = C3P0Utils.getConnection();
            threadLocal.set(connection);
        }

        // 返回连接对象
        return connection;
    }
}
