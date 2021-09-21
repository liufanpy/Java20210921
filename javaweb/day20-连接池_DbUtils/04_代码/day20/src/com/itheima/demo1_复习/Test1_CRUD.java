package com.itheima.demo1_复习;

import com.itheima.bean.User;
import com.itheima.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 8:52
 */
public class Test1_CRUD {

    @Test
    public void insert() throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "insert into user values(null,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数
        ps.setString(1,"ww");
        ps.setString(2,"123456");
        ps.setString(3,"老王");

        // 4.执行sql语句,处理结果
        int rows = ps.executeUpdate();
        System.out.println("rows:"+rows);

        // 5.释放资源
        JDBCUtils.release(null,ps,connection);

    }

    @Test
    public void update() throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "update user set password = ? where username = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数
        ps.setString(1,"abcdef");
        ps.setString(2,"ww");


        // 4.执行sql语句,处理结果
        int rows = ps.executeUpdate();
        System.out.println("rows:"+rows);

        // 5.释放资源
        JDBCUtils.release(null,ps,connection);

    }

    @Test
    public void delete() throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "delete from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数
        ps.setInt(1,4);


        // 4.执行sql语句,处理结果
        int rows = ps.executeUpdate();
        System.out.println("rows:"+rows);

        // 5.释放资源
        JDBCUtils.release(null,ps,connection);

    }

    @Test
    public void selectById() throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "select * from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数
        ps.setInt(1,7);

        // 4.执行sql语句,处理结果
        ResultSet resultSet = ps.executeQuery();
        // 定义User变量
        User user = null;
        while (resultSet.next()){
            // 创建User对象
            user = new User();
            // 取值,赋值
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));

        }

        // 5.释放资源
        JDBCUtils.release(resultSet,ps,connection);
        System.out.println(user);

    }

    @Test
    public void selectAll() throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "select * from user";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数

        // 4.执行sql语句,处理结果
        ResultSet resultSet = ps.executeQuery();

        // 创建List集合
        ArrayList<User> list = new ArrayList<>();

        // 定义User变量
        User user = null;
        while (resultSet.next()){
            // 创建User对象
            user = new User();
            // 取值,赋值
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));
            // 添加到集合中
            list.add(user);
        }

        // 5.释放资源
        JDBCUtils.release(resultSet,ps,connection);

        for (User user1 : list) {
            System.out.println(user1);
        }

    }

}
