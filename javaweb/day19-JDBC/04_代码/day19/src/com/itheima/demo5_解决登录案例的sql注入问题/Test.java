package com.itheima.demo5_解决登录案例的sql注入问题;

import com.bean.User;
import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 12:21
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //- 用户输入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();// zs

        System.out.println("请输入密码:");
        String password = sc.nextLine();// 123456

        //- 注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 预编译sql语句,得到预编译对象
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 给sql语句设置参数
        ps.setString(1,username);
        ps.setString(2,password);

        // 执行sql语句,处理结果
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        while (resultSet.next()){
            // 创建User对象
            user = new User();
            // 封装数据
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));

        }

        JDBCUtils.release(resultSet, ps, connection);

        // 判断是否登录成功
        if (user == null) {
            System.out.println("登录失败!");
        } else {
            System.out.println("登录成功!");
        }

    }
}
