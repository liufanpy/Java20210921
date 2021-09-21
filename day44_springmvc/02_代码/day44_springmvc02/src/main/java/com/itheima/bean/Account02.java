package com.itheima.bean;

import lombok.Data;

@Data
public class Account02 {
    private int id;
    private String name;
    private int money;

    //表示这个账户的地址信息 （省 + 城市）
   private Address address;

}
