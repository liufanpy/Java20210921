package com.itheima.springboot.controller;

import com.itheima.springboot.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: yp
 */
//@RestController
public class HelloController {
    @Value("${name}")
    private String name;

    @Value("${city[0]}")
    private String city;

    @Value("${students[0].age}")
    private int age;

    @Autowired
    private Person person;


    @Autowired
    private Environment environment; //环境对象

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("name="+name);
        System.out.println("city="+city);
        System.out.println("age="+age);
        System.out.println("person="+person);

        System.out.println("name="+environment.getProperty("name"));
        return "hello...";
    }

}
