package com.itheima.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 11:23
 */
public class JDBCUtils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            // 1.创建Properties对象
            Properties pro = new Properties();

            // 2.加载配置文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            pro.load(is);

            // 3.取值
            driverClass = pro.getProperty("driverClass");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");

            // 1.注册驱动
            Class.forName(driverClass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        // 2.获得连接
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

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
