package com.itheima.controller;

import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/*
    常用注解
         @RequestParam
 */
@Controller
public class Controller01 {

    /*
        @RequestParam
            value :
                1. 要求一定要携带指定的参数
                2. 如果携带了这个参数，那么就会把这个参数的值赋给方法形参 username
            required:
                表示是否一定要携带指定的参数，true: 一定要携带， false: 可以不携带。 默认是true
            defaultValue：
                表示默认值，如果没有携带指定的参数，那么就会把默认值赋给方法形参username

            如果只是写了@RequestParam ，然后没有给上任何的属性，那么即表示
                要求客户端来请求的的时候，一定要携带上参数 username
     */
    @RequestMapping("/requestParam")
    public String requestParam(@RequestParam String username ){

        System.out.println("username666666=" + username);

        return "success";
    }


    /*
        @RequestBody
            1. 获取请求体，并且把请求的内容赋给方法的形参。 （但是一般不怎么用。）
     */
    @RequestMapping("/requestBody01")
    public String requestBody01(@RequestBody String data ) throws UnsupportedEncodingException {

        System.out.println("data=" + data);

        // 从页面上提交上来的中文，都会经过URLEncoder.encode(内容, utf-8); 编码
        // 如果希望看到正常的中文，那么再来一次解码即可
        String cc = URLDecoder.decode(data , "utf-8");
        System.out.println("cc=" + cc);

        return "success";
    }


    /*
        @RequestBody
            1、 接收页面提交上来的json数据 使用javaBean 对象来接收
            2. 要求：
                2.1 页面提交的必须是json格式的数据
                2.2 必须要添加Jackson依赖，否则无法解析json
                2.3 必须要在springmvc.xml中打开注解的开关
                    <mvc:annotation-driven/>
     */
    @RequestMapping("/requestBody02")
    public String requestBody02(@RequestBody User user )  {
        System.out.println("user=" + user);
        return "success";
    }

    /*
        @RequestBody
            接收页面提交上来的json数据 使用Map集合来接收。
    */
    @RequestMapping("/requestBody03")
    public String requestBody03(@RequestBody Map<String , String > map )  {
        System.out.println("map=" + map);
        return "success";
    }


    /*
        @PathVariable
            一般是配合RestFul 这种风格使用。

            以前删除的api : localhost:8080/项目映射名/delete?id=3
            现在的api :   localhost:8080/项目映射名/delete/3

            解释：
                1. 地址里面需要包含{变量名}这样的字符串存在，用于匹配的地址
                2. @PathVariable("变量名") ，里面的名字必须和上面的 {} 里面的一样
                3. 截取到数据之后，就把这个数据赋值给方法的形参，方法的形参叫什么名字都可以。随意
     */
    @RequestMapping("/delete/{id}")
    public String pathVariable(@PathVariable("id")  int a )  {
        System.out.println("a="+a);
        return "success";
    }


    /*
        @RequestHeader
            获取指定的请求头，然后把 这个头的数值，赋值给方法形参
     */
    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader("User-Agent") String value )  {
        System.out.println("value="+value);
        return "success";
    }


    /*
        @CookieValue
            1、获取请求头里面指定的cookie数据，然后赋值给方法的形参
            2. @CookieValue("JSESSIONID") 即表示获取Session的id值
            3. 答疑：
                3.1 整个方法里面并没有创建|获取session，为什么就有session的id了呢？
                3.2 其实是这样的，当我们的项目启动的时候，默认就访问了首页 index.jsp
                3.3 jsp文件最终是会被翻译 servlet, 它里面内置了session对象。
                3.4 所以再来访问这个方法，就会有session的id值。
     */

    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String value )  {
        System.out.println("value="+value);
        return "success";
    }
}
