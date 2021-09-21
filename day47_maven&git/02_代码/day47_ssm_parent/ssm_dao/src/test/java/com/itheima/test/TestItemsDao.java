package com.itheima.test;

import com.itheima.bean.Items;
import com.itheima.dao.ItemsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestItemsDao {

    @Test
    public void testFindAll(){

        //1 创建spring的工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");

        //2. 问spring的工厂要ItemsDao的代理对象。
        ItemsDao dao = context.getBean(ItemsDao.class);

        //3. 调用方法
        List<Items> all = dao.findAll();

        System.out.println("all=" + all);

    }
}
