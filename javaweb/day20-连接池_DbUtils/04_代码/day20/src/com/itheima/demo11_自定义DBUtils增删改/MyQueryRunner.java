package com.itheima.demo11_自定义DBUtils增删改;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 16:18
 */
public class MyQueryRunner {
    // 定义一个DataSource连接池成员变量
    DataSource dataSource;

    // 定义一个空参和满参构造方法
    public MyQueryRunner() {
    }

    public MyQueryRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // 定义一个update方法完成增删改操作
    public int update(String sql, Object... params) throws SQLException {
        // 1.通过连接池获得连接
        Connection connection = dataSource.getConnection();

        // 2.预编译sql语句,得到预编译对象
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.设置参数
        // 3.1 获取参数的元数据对象
        ParameterMetaData pmd = ps.getParameterMetaData();

        // 3.2 通过参数的元数据对象获取参数的个数
        int count = pmd.getParameterCount();

        // 3.3 循环遍历,给参数赋值
        for (int i = 0; i < count; i++) {
            ps.setObject(i+1,params[i]);
        }

        // 4.执行sql语句
        int rows = ps.executeUpdate();

        // 5.返回结果
        return rows;
    }
}
