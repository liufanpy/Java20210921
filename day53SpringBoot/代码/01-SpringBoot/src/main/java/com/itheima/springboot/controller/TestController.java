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
@RestController
public class TestController {
    @RequestMapping("/test")
    public String sayHello(){
        return "hello...";
    }

}
