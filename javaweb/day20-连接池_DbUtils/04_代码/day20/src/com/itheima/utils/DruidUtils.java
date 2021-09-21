package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itheima.demo6_Druid的使用.Test2_配置文件;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 11:57
 */
public class DruidUtils {
    // - 0.定义一个DataSource成员变量
    private static DataSource dataSource;

    // - 1.在静态代码块中,加载配置文件,创建Druid连接池对象
    static {
        try {
            //- 创建Properties对象,加载配置文件中的数据
            Properties pro = new Properties();
            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //- 创建Druid连接池对象,传入Properties对象--->不会自动读src路径下的配置文件
            dataSource = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {

        }
    }

    // - 2.提供一个公共的静态方法获得连接池
    public static DataSource getDataSource() {
        return dataSource;
    }

    // - 3.提供一个公共的静态方法获得连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // - 4.提供一个公共的静态方法是否资源
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
