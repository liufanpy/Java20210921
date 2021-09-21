package com.itheima.test02;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext03.xml")
public class TestAccountDaoImpl {

    @Autowired
    private AccountDao dao;

    @Test
    public void testFindAll(){

        System.out.println(dao.findAll());
    }


}
