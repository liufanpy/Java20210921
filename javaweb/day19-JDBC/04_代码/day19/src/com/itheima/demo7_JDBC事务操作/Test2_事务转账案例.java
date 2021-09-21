package com.itheima.demo7_JDBC事务操作;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/27 15:09
 */
public class Test2_事务转账案例 {
    public static void main(String[] args)  {
        Connection connection = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            //- 1.注册驱动,获得连接
            connection = JDBCUtils.getConnection();

            //- 2.开启事务
            connection.setAutoCommit(false);

            //- 3.预编译sql语句,得到预编译对象
            String sql1 = "update account set money = money - ? where name = ?";
            String sql2 = "update account set money = money + ? where name = ?";
            ps1 = connection.prepareStatement(sql1);
            ps2 = connection.prepareStatement(sql2);

            //- 4.设置sql语句参数
            ps1.setDouble(1,100);
            ps1.setString(2,"zs");

            ps2.setDouble(1,100);
            ps2.setString(2,"ls");

            //- 5.执行sql语句,处理结果
            int rows1 = ps1.executeUpdate();
            int rows2 = ps2.executeUpdate();
            System.out.println("rows1:"+rows1);
            System.out.println("rows2:"+rows2);

            int i = 1/0;

            if (rows1 > 0  && rows2 > 0){
                //- 6.提交事务
                connection.commit();
            } else{
                //- 6.回滚事务
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        } catch (Exception e) {
            //- 6.回滚事务
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            //- 7.释放资源
            JDBCUtils.release(null,ps1,connection);
            JDBCUtils.release(null,ps2,null);
        }

    }
}
