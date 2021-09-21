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
public class Test5_查询单条记录 {
    // 查询id为1的记录
    public static void main(String[] args) throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "select * from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数
        ps.setInt(1,1);

        // 4.执行sql语句,处理结果
        ResultSet resultSet = ps.executeQuery();

        // 定义User遍历
        User user = null;

        // 循环遍历
        while (resultSet.next()) {
            // 创建User对象
            user = new User();

            // 获取数据,并封装到User对象中
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));
        }

        // 5.释放资源
        JDBCUtils.release(resultSet,ps,connection);

        System.out.println(user);

    }
}
