package com.itheima.demo8_使用DBUtils完成查询;

import com.itheima.bean.User;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 14:58
 */
public class Demo2_查询结果为多条记录的 {

    @Test // 查询所有记录,封装到List集合,每条记录封装到数组中
    public void selectAll1() throws Exception{
        // 1.创建QueryRunner对象,传入连接池对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用query方法
        String sql = "select * from user";
        List<Object[]> list = qr.query(sql, new ArrayListHandler());
        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test // 查询所有记录,封装到List集合,每条记录封装到javaBean对象中
    public void selectAll2() throws Exception{
        // 1.创建QueryRunner对象,传入连接池对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用query方法
        String sql = "select * from user";
        List<User> list = qr.query(sql, new BeanListHandler<User>(User.class));
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test // 查询所有记录,封装到List集合,每条记录封装到Map中
    public void selectAll3() throws Exception{
        // 1.创建QueryRunner对象,传入连接池对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用query方法
        String sql = "select * from user";
        List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }
}
