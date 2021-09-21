package com.itheima.demo2_Junit的其他注解;

import org.junit.*;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 9:16
 */
public class Demo {
    /*
        - @Before：用来修饰方法，该方法会在每一个测试方法执行之前执行一次。
        - @After：用来修饰方法，该方法会在每一个测试方法执行之后执行一次。
        - @BeforeClass：用来修饰静态方法，该方法会在所有测试方法之前执行一次，而且只执行一次。
        - @AfterClass：用来修饰静态方法，该方法会在所有测试方法之后执行一次，而且只执行一次
     */
    @BeforeClass
    public static void bc1(){
        System.out.println("bc1...");
    }


    @Before
    public void b1(){
        System.out.println("b1...");
    }

    @Test
    public void test1(){
        System.out.println("test1...");
    }

    @Test
    public void test2(){
        System.out.println("test2...");
    }

    @After
    public void a1(){
        System.out.println("a1...");
    }

    @AfterClass
    public static void ac1(){
        System.out.println("ac1...");
    }

}
