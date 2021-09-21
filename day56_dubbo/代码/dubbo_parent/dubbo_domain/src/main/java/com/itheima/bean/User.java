package com.itheima.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    //public class User {
    private Integer id;
    private String username;
    private Integer age;
}