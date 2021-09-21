package com.itheima.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller01")
public class Controller01 {

    @PreAuthorize("hasAuthority('add')")  //拥有add权限才能调用它
    @RequestMapping("/add")
    public String add(){
        return "add success~!~";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/delete")
    public String delete(){
        return "delete success~!~";
    }

    @PreAuthorize("hasRole('ROLE_ABC')")
    @RequestMapping("/update")
    public String update(){
        return "update success~!~";
    }
}
