package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
    使用ModelAndView对象返回页面与数据
 */
@Controller
public class Controller03 {


    /*
        自己new ModelAndView对象，封装数据，然后返回
     */
    @RequestMapping("/page05")
    public  ModelAndView page05(){
        System.out.println("page05...");

        //1. 创建对象
        ModelAndView mv = new ModelAndView();

        //2. 设置数据： 模型
        mv.addObject("username" , "admin");

        //3. 设置页面：视图
        mv.setViewName("success");

        //4. 返回mv
        return mv;
    }


    /*
        使用ModelAndView对象，返回数据和页面， 但是不要自己new ModelAndView
     */
    @RequestMapping("/page06")
    public  ModelAndView page06(ModelAndView mv){
        System.out.println("page06...");

        //1. 设置数据： 模型
        mv.addObject("username" , "admin");

        //2. 设置页面：视图
        mv.setViewName("success");

        //3. 返回mv
        return mv;
    }


    /*
        使用Model来封装数据，然后方法返回页面的名字
     */
    @RequestMapping("/page07")
    public  String page07(Model model){
        System.out.println("page07...");

        //1. 设置数据： 模型
       model.addAttribute("username", "admin");

       //2. 直接返回页面： 视图
        return "success";
    }
    /*
        使用HttpServletRequest来封装数据，然后方法返回页面的名字
     */
    @RequestMapping("/page08")
    public  String page08(HttpServletRequest request){
        System.out.println("page08...");

        //1. 设置数据： 模型
        request.setAttribute("username", "admin");

       //2. 直接返回页面： 视图
        return "success";
    }

    /*
      使用HttpSession来封装数据，然后方法返回页面的名字
   */
    @RequestMapping("/page09")
    public  String page09(HttpSession session){
        System.out.println("page09...");

        //1. 设置数据： 模型
        session.setAttribute("username", "admin");

        //2. 直接返回页面： 视图
        return "redirect:/success.jsp";
    }
}
