package com.itheima.demo5_C3P0的使用;

import com.itheima.bean.User;
import com.itheima.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 10:51
 */
public class Test2_硬编码 {
    public static void main(String[] args) throws Exception {
        //- 创建C3P0连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //- 设置连接池参数
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day19_1");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setInitialPoolSize(5);

        //- 获得连接
        Connection connection = dataSource.getConnection();

        // 预编译sql语句,得到预编译对象
        String sql = "select * from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 设置参数
        ps.setInt(1, 7);

        // 执行sql语句,处理结果
        ResultSet resultSet = ps.executeQuery();
        // 定义User变量
        User user = null;
        while (resultSet.next()) {
            // 创建User对象
            user = new User();
            // 取值,赋值
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));
        }

        // 释放资源
        JDBCUtils.release(resultSet,ps,connection);
        System.out.println(user);
    }
}
