package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCustom extends Account {
    ////用户表查询得到的数据。
    private String username;
    private String address;
}
