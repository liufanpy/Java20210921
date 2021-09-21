package com.itheima.demo3_测试工具类;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 11:00
 */
public class Test1_增 {
    public static void main(String[] args) throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 3.创建执行sql语句对象
        Statement statement = connection.createStatement();

        // 4.执行sql语句,处理结果
        String sql = "insert into user values(null,'wangwu','123456','王五')";
        int rows = statement.executeUpdate(sql);
        System.out.println("受影响的行数:"+rows);

        // 5.释放资源
        JDBCUtils.release(null,statement,connection);

    }
}
