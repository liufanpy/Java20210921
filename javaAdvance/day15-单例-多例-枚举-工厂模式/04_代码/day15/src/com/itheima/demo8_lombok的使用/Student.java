package com.itheima.demo8_lombok的使用;


import lombok.*;

import java.util.Objects;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 10:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private int age;
    private double score;


}
