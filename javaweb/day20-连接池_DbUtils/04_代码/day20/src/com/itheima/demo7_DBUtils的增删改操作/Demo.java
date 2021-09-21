package com.itheima.demo7_DBUtils的增删改操作;

import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 12:16
 */
public class Demo {
    @Test
    public void insert() throws SQLException {
        // 1.创建QueryRunner对象,传入连接池
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用update方法执行sql语句
        int rows = qr.update("insert into user values(null,?,?,?)", "gg", "ggg", "ggggg");
        System.out.println("rows:" + rows);
    }

    @Test
    public void update() throws Exception{
        // 1.创建QueryRunner对象,传入连接池
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用update方法执行sql语句
        int rows = qr.update("update user set password = ? where id = ?", "ssss",8);
        System.out.println("rows:" + rows);
    }

    @Test
    public void delete() throws Exception{
        // 1.创建QueryRunner对象,传入连接池
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用update方法执行sql语句
        int rows = qr.update("delete from user where id = ?", 1);
        System.out.println("rows:" + rows);
    }
}
