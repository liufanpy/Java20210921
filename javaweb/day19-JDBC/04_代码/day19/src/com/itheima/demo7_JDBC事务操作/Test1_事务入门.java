package com.itheima.demo7_JDBC事务操作;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 14:58
 */
public class Test1_事务入门 {
    // 修改id为6的密码
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // 1.注册驱动,获得连接
            connection = JDBCUtils.getConnection();

            // 2.开启事务
            connection.setAutoCommit(false);

            // 3.预编译sql语句,得到预编译对象
            String sql = "update user set password = ? where id = ?";
            ps = connection.prepareStatement(sql);

            // 4.设置参数
            ps.setString(1,"abcdef");
            ps.setInt(2,6);

            // 5.执行sql语句,处理结果
            int rows = ps.executeUpdate();
            System.out.println("受影响的行数:"+rows);

            // 发生异常
            int i = 1/0;

            // 6.没有异常提交事务
            connection.commit();

        } catch (Exception e) {
            // 7.有异常回滚事务
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            // 8.释放资源
            JDBCUtils.release(null,ps,connection);
        }

    }
}
