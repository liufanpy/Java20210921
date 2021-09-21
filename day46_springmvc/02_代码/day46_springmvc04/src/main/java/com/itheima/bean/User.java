package com.itheima.bean;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class User {
    @NotBlank(message = "用户名不能为空！")
    private String username;

    @Min(value=18 , message = "年龄不达标！")
    private int age ;
}
