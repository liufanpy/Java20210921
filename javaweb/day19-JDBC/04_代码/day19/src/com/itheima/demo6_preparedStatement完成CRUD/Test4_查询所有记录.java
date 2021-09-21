package com.itheima.demo6_preparedStatement完成CRUD;

import com.bean.User;
import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 14:48
 */
public class Test4_查询所有记录 {
    public static void main(String[] args) throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "select * from user";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数---->sql语句没有参数
        // 4.执行sql语句,处理结果
        ResultSet resultSet = ps.executeQuery();

        // 创建集合对象
        ArrayList<User> list = new ArrayList<>();

        // 循环遍历
        while (resultSet.next()) {
            // 创建User对象
            User user = new User();

            // 获取数据,并封装到User对象中
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));

            // 把User对象添加到集合中
            list.add(user);

        }

        // 5.释放资源
        JDBCUtils.release(resultSet,ps,connection);

        for (User user : list) {
            System.out.println(user);
        }

    }
}
