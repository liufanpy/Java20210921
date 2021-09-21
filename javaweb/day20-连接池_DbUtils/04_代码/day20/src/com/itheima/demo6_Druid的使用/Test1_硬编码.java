package com.itheima.demo6_Druid的使用;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.itheima.bean.User;
import com.itheima.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 11:37
 */
public class Test1_硬编码 {
    public static void main(String[] args) throws Exception{
        //- 创建Druid连接池对象
        DruidDataSource dataSource = new DruidDataSource();

        //- 设置连接池的配置参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/day19_1");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setInitialSize(5);

        //- 通过连接池获得连接
        DruidPooledConnection connection = dataSource.getConnection();

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

        System.out.println("正在使用的:"+dataSource.getActiveCount());// 0
        System.out.println("正在空闲的:"+dataSource.getPoolingCount());// 5

        // 释放资源
        JDBCUtils.release(resultSet,ps,connection);
        System.out.println(user);

        System.out.println("正在使用的:"+dataSource.getActiveCount());// 0
        System.out.println("正在空闲的:"+dataSource.getPoolingCount());// 5
    }
}
