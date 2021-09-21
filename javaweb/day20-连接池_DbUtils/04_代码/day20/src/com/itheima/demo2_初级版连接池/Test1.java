package com.itheima.demo2_初级版连接池;

import com.itheima.bean.User;
import com.itheima.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 9:41
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        // 1.创建连接池对象,获得连接
        MyDataSource01 dataSource = new MyDataSource01();
        System.out.println("获得连接之前,池子中的连接数量:"+MyDataSource01.size());// 5

        Connection connection = dataSource.getAbc();


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
        System.out.println("归还连接之前,池子中的连接数量:"+MyDataSource01.size());// 4

        // 归还连接
        dataSource.addBack(connection);

        // 5.释放资源
        JDBCUtils.release(resultSet, ps, null);
        System.out.println(user);

        System.out.println("归还连接之后,池子中的连接数量:"+MyDataSource01.size());// 5


    }
}
