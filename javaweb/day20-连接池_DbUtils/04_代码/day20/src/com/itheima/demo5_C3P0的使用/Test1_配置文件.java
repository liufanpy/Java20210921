package com.itheima.demo5_C3P0的使用;

import com.itheima.bean.User;
import com.itheima.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 11:09
 */
public class Test1_配置文件 {
    public static void main(String[] args) throws Exception{
        // 创建C3P0连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 获取连接
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

        System.out.println("正在使用的:"+dataSource.getNumBusyConnections());// 正在使用连接数
        System.out.println("正在空闲的:"+dataSource.getNumIdleConnections());// 空闲连接数
        System.out.println("总的连接数:"+dataSource.getNumConnections());// 总连接数

        // 释放资源
        JDBCUtils.release(resultSet,ps,connection);
        System.out.println(user);


        Thread.sleep(5000);

        System.out.println("正在使用的:"+dataSource.getNumBusyConnections());// 正在使用连接数
        System.out.println("正在空闲的:"+dataSource.getNumIdleConnections());// 空闲连接数
        System.out.println("总的连接数:"+dataSource.getNumConnections());// 总连接数
    }
}
