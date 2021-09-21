package com.itheima.demo5_C3P0的使用;

import com.itheima.bean.User;
import com.itheima.utils.C3P0Utils;
import com.itheima.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 11:21
 */
public class Test3_测试C3P0工具类 {
    public static void main(String[] args) throws Exception {
        // 获得连接
        Connection connection = C3P0Utils.getConnection();

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

        // 释放资源
        JDBCUtils.release(resultSet, ps, connection);
        System.out.println(user);
    }
}
