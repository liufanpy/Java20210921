package com.itheima.demo4_登录案例;

import com.bean.User;
import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 11:49
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //- 用户输入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();// zs

        System.out.println("请输入密码:");
        String password = sc.nextLine();// 123456

        //- 注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        //- 创建执行sql语句对象
        Statement statement = connection.createStatement();

        //- 执行sql语句,处理结果(判断是否登录成功,其实就是判断User对象是否为null)
        //String sql = "select * from user where username = 'zs' and password = '123456'";
        String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        // 定义User变量
        User user = null;
        while (resultSet.next()) {
            // 创建User对象
            user = new User();
            // 封装数据
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));

        }

        //- 释放资源
        JDBCUtils.release(resultSet, statement, connection);

        // 判断是否登录成功
        if (user == null) {
            System.out.println("登录失败!");
        } else {
            System.out.println("登录成功!");
        }
    }
}
