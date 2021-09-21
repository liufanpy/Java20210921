package com.itheima.demo2_增删改查练习;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 11:00
 */
public class Test3_删 {
    // 删除id为3的记录
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得连接
        String url = "jdbc:mysql://localhost:3306/day19_1";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        // 3.创建执行sql语句对象
        Statement statement = connection.createStatement();

        // 4.执行sql语句,处理结果
        String sql = "delete from user where id = 3";
        int rows = statement.executeUpdate(sql);
        System.out.println("受影响的行数:" + rows);

        // 5.释放资源
        statement.close();
        connection.close();
    }
}
