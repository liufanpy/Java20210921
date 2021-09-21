package com.itheima.controller;

import com.itheima.bean.Account;
import com.itheima.bean.Account02;
import com.itheima.bean.User;
import com.itheima.bean.User02;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class Controller01 {

    /*
        获取简单的请求参数
         要求：
            方法的形参的名字，必须和页面提交过来的name属性的值一样。
             用户名: <input type="text" name="username"/><br/>
     */
    @RequestMapping("/getSimpleParams")
    public String getSimpleParams(String username , String password){
        System.out.println(username + "=" + password);
        return "success";
    }


    /*
        获取对象参数
            要求：
               1. 方法形参必须是对象类型
               2. 页面的name属性的值必须和对象类里面的属性名字一样。否则接收不到数据。
     */
    @RequestMapping("/getObjectParams")
    public String getObjectParams(Account a){
        System.out.println("a=" + a);
        return "success";
    }


    /*
        获取数组参数
            要求：
                1. 方法参数的名字，必须和页面的name属性的值一样。
     */
    @RequestMapping("/getArrayParams")
    public String getArrayParams(String [] hobby){
        System.out.println("hobby=" + Arrays.toString(hobby));
        return "success";
    }

    /*
        获取对象包含对象的参数
            要求：
                1. 方法的形参必须是最终要包装出来的对象类型
                2. 页面里面的name属性的值必须要和类里面的属性一样。
                3. 如果希望把页面的某个数据封装到内部对象里面的属性去，那么name的属性需要写成这样
                    name="对象属性.属性"  如： name="address.city"
     */
    @RequestMapping("/getObjectInObjectParams")
    public String getObjectInObjectParams(Account02 a){
        System.out.println("a=" + a);
        return "success";
    }


    /*
        对象包含List集合
            要求：
                1. 方法的形参必须是对象类型
                2. 页面的name属性赋值的时候，需要使用 集合属性[下标].对象属性的方式赋值
     */
    @RequestMapping("/getListInObjectParams")
    public String getListInObjectParams(User user){
        System.out.println("user=" + user);
        return "success";
    }


    /*
        获取对象包含Map集合

     */
    @RequestMapping("/getMapInObjectParams")
    public String getMapInObjectParams(User02 user){
        System.out.println("user=" + user);
        return "success";
    }
}
