package com.itheima.third.controller;

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
