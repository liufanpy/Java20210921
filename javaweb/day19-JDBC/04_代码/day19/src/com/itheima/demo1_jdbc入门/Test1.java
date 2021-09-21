package com.itheima.demo1_jdbc入门;

import com.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 9:47
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        //DriverManager.registerDriver(new Driver());
        // 改: 只要加载Driver类就会注册驱动(Driver类的静态代码块中会注册驱动)
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得连接
        String url = "jdbc:mysql://localhost:3306/day19_1";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3.创建执行sql语句对象
        Statement statement = connection.createStatement();

        // 4.执行sql语句,处理结果
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);

        // 处理结果
        ArrayList<User> list = new ArrayList<>();
        while (resultSet.next()) {
            // 创建User对象
            User user1 = new User();

            // 取值
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String pwd = resultSet.getString("password");
            String nickname = resultSet.getString("nickname");

            // 设置值
            user1.setId(id);
            user1.setUsername(username);
            user1.setPassword(pwd);
            user1.setNickname(nickname);

            // 添加到集合中
            list.add(user1);
        }

        // 5.释放资源
        resultSet.close();
        statement.close();
        connection.close();

        for (User user1 : list) {
            System.out.println(user1);
        }

    }
}
