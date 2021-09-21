package com.itheima.demo9_参数元数据对象的使用;

import com.itheima.utils.C3P0Utils;
import com.itheima.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 15:58
 */
public class Test {
    public static void main(String[] args) throws Exception{
        // 1.注册驱动,获得连接
        Connection connection = JDBCUtils.getConnection();

        // 2.预编译sql语句,得到预编译对象
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.获取参数元数据对象--->使用预编译对象获取
        ParameterMetaData pmd = ps.getParameterMetaData();

        // 3.获取参数的个数-->使用参数元数据对象
        int count = pmd.getParameterCount();
        System.out.println("参数的个数:"+count);// 参数的个数:2

        // 3.获取参数的类型--->mysql不支持获取参数的类型
        //System.out.println(pmd.getParameterTypeName(1));
        //System.out.println(pmd.getParameterClassName(1));

    }
}
