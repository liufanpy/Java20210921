package com.itheima.demo6_preparedStatement完成CRUD;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 14:34
 */
public class Test1_增 {
    public static void main(String[] args) throws Exception {
        //- 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        //- 2.预编译sql语句,得到预编译对象
        String sql = "insert into user values(null,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        //- 3.为sql语句设置参数
        ps.setString(1, "tq");
        ps.setString(2, "123456");
        ps.setString(3, "田七");

        //- 4.执行sql语句,处理结果
        int rows = ps.executeUpdate();
        System.out.println("受影响的行数:" + rows);

        //- 5.释放资源
        JDBCUtils.release(null,ps,connection);
    }
}
