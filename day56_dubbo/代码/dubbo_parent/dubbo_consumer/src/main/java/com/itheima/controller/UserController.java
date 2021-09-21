package com.itheima.controller;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: yp
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //@Autowired
    //UserService对象在提供者的项目里面,在另外一个服务器里面,使用Dubbo提供的@Reference
//    @Reference(cluster = "failfast",mock = "force:return null")  //timeout:配置超时时间 ,retries设置重试次数, loadbalance = 负载均衡模式
    @Reference
    private UserService userService;

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        System.out.println("UserController...findById()");
        User user =  userService.findById(id);
        return user;
    }

}
