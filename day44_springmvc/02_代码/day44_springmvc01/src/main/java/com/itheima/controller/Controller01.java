package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
    @Controller
        作用： 仅仅是为了让spring把这个类给托管起来，没有别的用意。
    @RequestMapping
        作用： 用于设置请求地址路径，也就是什么样的请求地址，能够执行对应的方法。
        属性：
            value |  path : 指的就是请求的地址是什么
            method : 请求方式，指定什么样的请求方式，能够到达这个方法，默认get和post都可以
            params: 表示请求一定要携带具体的参数过来，否则即报错
         位置：
            1. 可以写在方法上，也可以写类身上,要想写在类身上，必须方法上也要有。
            2. 写在类上，主要是为了做区分，跟其他的controller做进一步区分。模块化管理。
 */

@Controller
public class Controller01 {


    @RequestMapping( value = "/sayHi04" , method = RequestMethod.GET , params = "username")
    public String sayHi04(){
        System.out.println("执行了Controller01的sayHi04方法~！~");
        return "success";
    }

    @RequestMapping("/sayHi")
    public String sayHi(){
        System.out.println("执行了Controller01的sayHi方法~！~");
        //返回页面
        return "success.jsp";
    }


    /*
        物理视图的写法：完整路径
            优点： 直观，一看就知道是哪个页面，这个页面在哪个位置下。
            缺点： 如果页面位于多级目录下，那么这里的返回值就要连着写很多的目录结构
                比如：return "/a/b/c/d/success.jsp";
     */
    @RequestMapping("/sayHi02")
    public String sayHi02(){
        System.out.println("执行了Controller01的sayHi02方法~！~");
        //返回页面
        return "/success.jsp";
        //return "success.jsp";
    }


    /*
        返回页面： 逻辑视图的写法
            优点： 简单，方便，快捷，
            缺点： 不直观，看名字不知道它在哪个位置下，也不知道这个文件的后缀面是 .jsp还是.html
                需要配合视图解析器来用

     */
    @RequestMapping("/sayHi03")
    public String sayHi03(){
        System.out.println("执行了Controller01的sayHi03方法~！~");
        //返回页面
        return "success";
    }


}
