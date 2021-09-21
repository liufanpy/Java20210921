package com.itheima.test;

import com.itheima.bean.Items;
import com.itheima.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestItemsServiceImpl {

    @Test
    public void testFindAll(){

        //1 建工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");

        //2. 问工厂要对象
        ItemsService is = context.getBean(ItemsService.class);

        //3. 调用方法
        System.out.println(is.findAll());


    }

    @Test
    public void testSave(){

        //1 建工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");

        //2. 问工厂要对象
        ItemsService is = context.getBean(ItemsService.class);

        //3. 调用方法
        Items i = new Items();
        i.setName("yyyyy");
        int row = is.save(i);
        System.out.println("row=" + row);


    }
}
