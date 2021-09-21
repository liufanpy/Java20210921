package com.itheima.demo3_测试工具类;

import com.bean.User;
import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 11:00
 */
public class Test5_查多条记录 {
    public static void main(String[] args) throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 3.创建执行sql语句对象
        Statement statement = connection.createStatement();

        // 4.执行sql语句,处理结果
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);
        // 创建User对象
        User user = null;

        // 创建ArrayList集合对象,集合元素的类型为User
        ArrayList<User> list = new ArrayList<>();

        while (resultSet.next()){
            // 创建User对象
            user = new User(); // 1.优化内存    2.可以作为判断条件

            // 取值,然后赋值
            user.setId( resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));

            // 把user对象添加到集合中
            list.add(user);
        }


        // 5.释放资源
        JDBCUtils.release(resultSet,statement,connection);


        for (User user1 : list) {
            System.out.println(user1);
        }


    }
}
