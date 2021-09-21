package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    设计RestFul风格的API接口
 */
@Controller
public class Controller05 {

    /*
        添加操作：
            以前： localhost:8080/项目映射名/addUser   GET|POST
            RestFul: localhost:8080/项目映射名/user    POST
     */
    //完整的写法： @RequestMapping(value = "/user" , method = RequestMethod.POST)
    @ResponseBody
    @PostMapping("/user")
    public String add(User user ){
        System.out.println("add: user=" + user);
        return "add success~!";
    }


    /*
        删除操作
            以前：localhost:8080/项目映射名/deleteUser?id=3  GET|POST
            RestFul: localhost:8080/项目映射名/user/3        DELETE
     */
    @ResponseBody
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int id ){
        System.out.println("delete: id=" + id);
        return "delete success~!";
    }


    /*
        修改：
            以前：localhost:8080/项目映射名/updateUser     GET|POST
            RestFul: localhost:8080/项目映射名/user       PUT
     */
    @ResponseBody
    @PutMapping("/user")
    public String update(User user){
        System.out.println("update: user=" + user);
        return "update success~!";
    }


    /*
        根据id查询用户：
             以前：localhost:8080/项目映射名/findUserById?id=3     GET|POST
             RestFul: localhost:8080/项目映射名/user/3            GET
     */
    @ResponseBody
    @GetMapping("/user/{id}")
    public String findById(@PathVariable("id") int id){
        System.out.println("findById: id=" + id);
        return "findById success~!";
    }

    /*
        查询所有
             以前：localhost:8080/项目映射名/findAllUser     GET|POST
             RestFul: localhost:8080/项目映射名/user         GET
     */
    @ResponseBody
    @GetMapping("/user")
    public String findAll(){
        System.out.println("findAll...");
        return "findAll success~!";
    }




}
