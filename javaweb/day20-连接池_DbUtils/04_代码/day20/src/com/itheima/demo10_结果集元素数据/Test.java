package com.itheima.demo10_结果集元素数据;

import com.itheima.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 16:09
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "select * from user";
        PreparedStatement ps = connection.prepareStatement(sql);
        // 3.设置参数
        // 4.执行sql语句,处理结果
        ResultSet resultSet = ps.executeQuery();

        // 获得结果集对应的结果集元数据对象
        ResultSetMetaData metaData = resultSet.getMetaData();

        // 使用结果集元数据对象获得结果的元数据(列的个数,类的名称,列的sql类型,列的java类型....)
        int columnCount = metaData.getColumnCount();
        System.out.println("列的个数:"+columnCount);
        for (int i = 1; i <= columnCount; i++) {
            System.out.println("列的名称:"+metaData.getColumnName(i));
            System.out.println("列的sql类型:"+metaData.getColumnTypeName(i));
            System.out.println("列的java类型:"+metaData.getColumnClassName(i));
        }

    }
}
