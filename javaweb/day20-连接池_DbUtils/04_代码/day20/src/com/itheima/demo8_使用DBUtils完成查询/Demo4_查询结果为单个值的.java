package com.itheima.demo8_使用DBUtils完成查询;

import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.util.List;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 14:58
 */
public class Demo4_查询结果为单个值的 {

    @Test // 查询记录的总条数,封装到一个对象中
    public void selectByColumn() throws Exception{
        // 1.创建QueryRunner对象,传入连接池对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        // 2.调用query方法
        String sql = "select count(*) from user";
        Long count = (Long)qr.query(sql, new ScalarHandler());
        System.out.println(count);

    }
}
