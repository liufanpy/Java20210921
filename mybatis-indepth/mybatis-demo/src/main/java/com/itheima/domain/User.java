package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */

@Data
public class User implements Serializable{

    private Integer id;
    private String username;
    private String address;
    private String name;




}
