package com.itheima.demo6_preparedStatement完成CRUD;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 14:34
 */
public class Test3_删 {
    // 删除username=wangwu的记录
    public static void main(String[] args) throws Exception {
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "delete from user where username = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.为sql语句设置参数
        ps.setString(1,"wangwu");

        // 4.执行sql语句,处理结果
        int rows = ps.executeUpdate();
        System.out.println("受影响的行数:"+rows);

        // 5.释放资源
        JDBCUtils.release(null,ps,connection);


    }
}
