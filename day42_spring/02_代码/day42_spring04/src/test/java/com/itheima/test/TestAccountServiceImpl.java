package com.itheima.test;

import com.itheima.bean.Account;
import com.itheima.config.AppConfig;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestAccountServiceImpl {

    @Autowired
    private AccountService as;

    @Test
    public void testAdd() throws SQLException {

        Account a = new Account();
        a.setName("德玛");
        a.setMoney(2);

        as.add(a);
    }

    @Test
    public void testDelete() throws SQLException {
        as.delete(6);
    }


    @Test
    public void testUpdate() throws SQLException {

        //先查
        Account a = as.findById(3);
        a.setMoney(70);

        //再改
        as.update(a);
    }

    @Test
    public void testFindAll() throws SQLException {
        System.out.println(as.findAll());
    }
}
