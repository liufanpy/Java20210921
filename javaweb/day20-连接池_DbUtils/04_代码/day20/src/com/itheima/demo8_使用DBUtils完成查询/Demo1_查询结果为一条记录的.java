package com.itheima.demo8_使用DBUtils完成查询;

import com.itheima.bean.User;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 14:58
 */
public class Demo1_查询结果为一条记录的 {
    @Test // 查询id为1的记录,封装到数组中
    public void selectById1() throws Exception{
        // 1.创建QueryRunner对象,传入连接池对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用query方法
        String sql = "select * from user where id = ?";
        Object[] arr = qr.query(sql, new ArrayHandler(), 1);
        System.out.println(Arrays.toString(arr));
    }

    @Test // 查询id为1的记录,封装到User对象中
    public void selectById2() throws Exception{
        // 1.创建QueryRunner对象,传入连接池对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用query方法
        String sql = "select * from user where id = ?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), 1);
        System.out.println(user);
    }

    @Test // 查询id为1的记录,封装到Map集合
    public void selectById3() throws Exception{
        // 1.创建QueryRunner对象,传入连接池对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用query方法
        String sql = "select * from user where id = ?";
        Map<String, Object> map = qr.query(sql, new MapHandler(), 1);
        System.out.println(map);
    }
}
