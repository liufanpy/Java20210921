package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private Integer aid;
    private double money;
    private Integer uid;
    //表示Account和User 1:1关系  当你查询出一条Account账户信息时 同时可以得到它对应的用户信息
    //在一方添加另外一个一方的javabean属性
    private User user;
}
