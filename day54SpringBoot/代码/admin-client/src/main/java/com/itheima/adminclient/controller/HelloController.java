package com.itheima.adminclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: yp
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public  String sayHello(){
        return "hello sz113";
    }

}
