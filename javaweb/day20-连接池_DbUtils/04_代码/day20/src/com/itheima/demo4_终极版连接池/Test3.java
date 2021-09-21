package com.itheima.demo4_终极版连接池;

import com.itheima.bean.User;
import com.itheima.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 10:10
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        // 1.创建连接池对象,获得连接
        MyDataSource03 dataSource = new MyDataSource03();
        System.out.println("获得连接之前,池子中的连接数量:"+ MyDataSource03.size());// 5

        // 返回的是增强的连接对象
        Connection connection = dataSource.getConnection();


        // 2.预编译sql语句,得到预编译对象
        String sql = "select * from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数
        ps.setInt(1, 7);

        // 4.执行sql语句,处理结果
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
        System.out.println("归还连接之前,池子中的连接数量:"+ MyDataSource03.size());// 4

        // 归还连接
        //connection.close();// 增强连接对象的close方法--->功能:把被增强的连接对象归还到连接池中

        // 5.释放资源
        JDBCUtils.release(resultSet, ps, connection);// connection.close()
        System.out.println(user);

        System.out.println("归还连接之后,池子中的连接数量:"+ MyDataSource03.size());// 5


    }
}
