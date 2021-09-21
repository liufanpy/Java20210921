package com.itheima.demo1_jdbc入门;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 9:47
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        //DriverManager.registerDriver(new Driver());
        // 改: 只要加载Driver类就会注册驱动(Driver类的静态代码块中会注册驱动)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.获得连接
        String url = "jdbc:mysql://localhost:3306/day19?useSSL=false";
        String user = "root";
        String password = "88888888";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3.创建执行sql语句对象
        Statement statement = connection.createStatement();

        // 4.执行sql语句,处理结果
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);

        // 处理结果
        while (resultSet.next()) {
            // 取数据
            /*System.out.println(resultSet.getObject("id"));
            System.out.println(resultSet.getObject("username"));
            System.out.println(resultSet.getObject("password"));
            System.out.println(resultSet.getObject("nickname"));*/

            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String pwd = resultSet.getString("password");
            String nickname = resultSet.getString("nickname");

            System.out.println("id:"+id);
            System.out.println("username:"+username);
            System.out.println("pwd:"+pwd);
            System.out.println("nickname:"+nickname);
            System.out.println("--------------");
        }

        // 5.释放资源
        resultSet.close();
        statement.close();
        connection.close();

    }
}
