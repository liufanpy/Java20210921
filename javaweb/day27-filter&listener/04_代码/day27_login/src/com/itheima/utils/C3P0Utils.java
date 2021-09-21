package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 11:18
 */
public class C3P0Utils {
    // 定义为一个私有静态的连接池常量
    private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();

    // 提供一个公共的静态方法获得连接池
    public static DataSource getDataSource(){
        return DATA_SOURCE;
    }

    // 提供一个公共的静态方法获得连接
    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }

    // 提供一个公共的静态方法是否资源
    /**
     * 释放资源
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
