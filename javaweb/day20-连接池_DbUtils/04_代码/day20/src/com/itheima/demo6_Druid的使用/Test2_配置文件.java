package com.itheima.demo6_Druid的使用;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itheima.bean.User;
import com.itheima.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 11:50
 */
public class Test2_配置文件 {
    public static void main(String[] args) throws Exception{
        //- 创建Properties对象,加载配置文件中的数据
        Properties pro = new Properties();
        InputStream is = Test2_配置文件.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        //- 创建Druid连接池对象,传入Properties对象--->不会自动读src路径下的配置文件
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        //- 通过连接池获得连接
        Connection connection = dataSource.getConnection();

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
        JDBCUtils.release(resultSet,ps,connection);
        System.out.println(user);


    }
}
