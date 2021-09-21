package com.itheima.controller;

import com.itheima.bean.User03;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;

@Controller
public class Controller02 {

    @RequestMapping("/getDateParams")
    public String getDateParams(User03 user){
        System.out.println("user=" + user);


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sf.format(user.getBirthday());
        System.out.println("birtyday=" + birthday);

        return "success";
    }
}
