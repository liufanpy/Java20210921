package com.itheima.demo8_使用DBUtils完成查询;

import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 14:58
 */
public class Demo3_查询结果为单列多值的 {

    @Test // 查询某列的所有值,封装到List集合
    public void selectByColumn() throws Exception{
        // 1.创建QueryRunner对象,传入连接池对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用query方法
        String sql = "select username from user";
        List<Object> list = qr.query(sql, new ColumnListHandler());
        System.out.println(list);
    }
}
