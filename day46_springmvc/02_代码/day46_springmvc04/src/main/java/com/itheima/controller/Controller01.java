package com.itheima.controller;

import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class Controller01 {

    @RequestMapping("/add")
    public String addUser(@Valid User user , Errors errors , Model model){
        System.out.println("user=" + user);

        //1. 判断字段校验是否不满足条件，如果不满足，就得到所有不满足的字段和错误的信息
        if(errors.hasErrors()){
            //2. 得到所有字段的错误
            List<FieldError> fieldErrors = errors.getFieldErrors();

            //3. 遍历每一个字段和它的错误信息
            for (FieldError fe : fieldErrors) {

                //得到字段的名字
                String fieldName = fe.getField();

                //得到这个字段为什么不满足规则的信息
                String message = fe.getDefaultMessage();

                System.out.println(fieldName + "=" + message);

                model.addAttribute(fieldName , message);

            }
            return "index";
        }
        return  "success";
    }
}
