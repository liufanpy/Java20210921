package com.itheima.test;

import com.itheima.bean.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext02.xml")
public class TestJdbcTemplate {

    @Autowired
    private JdbcTemplate template;

    @Test
    public void testAdd(){

        String sql = "insert into t_account values (null , ?, ?)";
        template.update(sql , "张三" , 10);
    }

    @Test
    public void testDelete(){
        String sql = "delete from t_account where id = ? ";
        template.update(sql ,7);
    }

    @Test
    public void testUpdate(){
        //1. 先查询账户，根据id来查询
        String sql = "select  * from t_account where id = ? ";
        Account a = template.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), 3);

        a.setMoney(50);

        //2. 更新
        sql = "update t_account set money = ? , name = ? where id  = ?";
        template.update(sql , a.getMoney() , a.getName() , a.getId());
    }


    //查询...

    //查询所有
    @Test
    public void testFindAll(){
        String sql = "select * from t_account ";
        List<Account> list = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println("list=" + list);
    }

    //查询得到一个数据（聚合查询）
    @Test
    public void testFindCount(){
        String sql = "select count(*) from t_account ";
        long count = template.queryForObject(sql , long.class);
        System.out.println("count=" + count);
    }

    //查询得到一个map集合
    @Test
    public void testFindMap(){
        String sql = "select * from t_account where id = ? ";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println("map=" + map);
    }

    //查询得到一个List<map>集合
    @Test
    public void testFindListMap(){
        String sql = "select * from t_account ";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println("list=" + list);
    }


}
