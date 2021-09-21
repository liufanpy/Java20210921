package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    private Integer rid;
    private String rName;
    private String rDesc;

    //改造 角色的实体类  添加多方对象集合属性
    private List<User> users;
}
