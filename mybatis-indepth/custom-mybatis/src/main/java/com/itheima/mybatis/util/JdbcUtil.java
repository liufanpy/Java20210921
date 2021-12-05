package com.itheima.mybatis.util;


import com.itheima.mybatis.session.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于获取数据源连接
 */
public class JdbcUtil {


    // 获取连接
    public static Connection getConnection(Configuration configuration) {
        try {
            Class.forName(configuration.getDriver());
            return DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("创建连接异常....");
        }
    }
}
