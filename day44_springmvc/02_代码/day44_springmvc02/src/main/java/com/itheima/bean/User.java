package com.itheima.bean;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id ;
    private String name;
    private int age ;

    //账户信息
    private List<Account> accountList;
}
