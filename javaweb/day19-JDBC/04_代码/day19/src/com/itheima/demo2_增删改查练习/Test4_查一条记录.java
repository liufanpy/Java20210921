package com.itheima.demo2_增删改查练习;

import com.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 11:00
 */
public class Test4_查一条记录 {
    // 查询id为1的记录
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得连接
        String url = "jdbc:mysql://localhost:3306/day19_1";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        // 3.创建执行sql语句对象
        Statement statement = connection.createStatement();

        // 4.执行sql语句,处理结果
        String sql = "select * from user where id = 1";
        ResultSet resultSet = statement.executeQuery(sql);
        // 创建User对象
        User user = null;

        while (resultSet.next()){
            // 创建User对象
            user = new User(); // 1.优化内存    2.可以作为判断条件

            // 取值,然后赋值
            user.setId( resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));
        }


        // 5.释放资源
        resultSet.close();
        statement.close();
        connection.close();

        if (user == null){
            System.out.println("没有查询到数据!");
        }else{
            System.out.println("查询到了数据: "+user);
        }

    }
}
