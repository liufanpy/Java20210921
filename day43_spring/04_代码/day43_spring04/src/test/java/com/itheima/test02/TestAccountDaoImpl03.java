package com.itheima.test02;

import com.itheima.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext05.xml")
public class TestAccountDaoImpl03 {

    @Autowired
    private AccountDao dao;

    @Test
    public void testFindAll(){

        System.out.println(dao.findAll());
    }


}
