package com.itheima.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class User02 {
    private int id ;
    private String name;
    private int age ;

    //账户信息
    private Map<String , Account> accountMap;
}
