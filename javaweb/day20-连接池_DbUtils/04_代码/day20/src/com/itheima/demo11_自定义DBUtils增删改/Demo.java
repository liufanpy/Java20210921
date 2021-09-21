package com.itheima.demo11_自定义DBUtils增删改;

import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 16:24
 */
public class Demo {

    @Test
    public void insert() throws SQLException {
        // 创建MyQueryRunner对象,传入连接池对象
        MyQueryRunner qr = new MyQueryRunner(C3P0Utils.getDataSource());
        // 调用update方法
        int rows = qr.update("insert into user values(null,?,?,?)","zl","123456","老赵" );
        System.out.println(rows);

    }

    @Test
    public void update() throws SQLException {
        // 创建MyQueryRunner对象,传入连接池对象
        MyQueryRunner qr = new MyQueryRunner(C3P0Utils.getDataSource());
        // 调用update方法
        int rows = qr.update("update user set password = ? where username = ?", "abcdef","zl");
        System.out.println(rows);

    }

    @Test
    public void delete() throws Exception{
        // 1.创建QueryRunner对象,传入连接池
        MyQueryRunner qr = new MyQueryRunner(C3P0Utils.getDataSource());

        // 2.调用update方法执行sql语句
        int rows = qr.update("delete from user where id = ?", 9);
        System.out.println("rows:" + rows);
    }

}
