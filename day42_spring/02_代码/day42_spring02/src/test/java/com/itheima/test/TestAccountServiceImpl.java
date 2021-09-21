package com.itheima.test;

import com.itheima.bean.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAccountServiceImpl {

    @Autowired
    private AccountService as;

    @Test
    public void testAdd() throws SQLException {

        Account a = new Account();
        a.setName("卡特琳娜");
        a.setMoney(100);

        as.add(a);
    }
    @Test
    public void testDelete() throws SQLException {
        as.delete(5);
    }

    @Test
    public void testUpdate() throws SQLException {

        Account a = as.findById(3);
        a.setMoney(1);


        as.update (a);
    }


    @Test
    public void testFindAll() throws SQLException {
        System.out.println(as.findAll());
    }
}
