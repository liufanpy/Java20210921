package com.itheima.mm.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.UserService;
import com.itheima.mm.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    /**
     * 退出登录
     * @param req
     * @param resp
     */
    @RequestMapping("/logout")
    public void logout(HttpServletRequest req , HttpServletResponse resp){

        try {
            //1. 清空session作用域
            //req.getSession().removeAttribute("user");
            req.getSession().invalidate();

            //2. 给响应
            Result result = new Result(true , "退出成功");
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();

            try {
                Result result = new Result(false , "退出失败");
                resp.getWriter().write(JSON.toJSONString(result));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    //定义映射路径的时候 / 不要省掉。
    @RequestMapping("/login")
    public void login(HttpServletRequest req , HttpServletResponse resp){

        try {
            //1. 获取请求参数
            User user =  JSON.parseObject(req.getInputStream() , User.class);
            System.out.println("user=" + user);

            //2. 交代service干活
            UserService us = new UserService();
            User loginUser = us.login(user);


            //3. 响应
            Result result = null;
            if(loginUser != null){ //登录成功

                //3.1 把用户对象存储到session作用域
                req.getSession().setAttribute("user" , loginUser);

                //3.2 告诉页面，登录成功了。 不需要把登录的loginUser给前端页面
                result = new Result(true , "登录成功");
            }else{ //登录失败
                result = new Result(false , "登录失败");
            }

            //写出去
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
