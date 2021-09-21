package com.itheima.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPasswordEncoder {

    @Test
    public void test01(){

        //1. 构建对象
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

        //2. 加密
        //$2a$10$H87N3UqBXPTtGSxRGR17t.1cRjG9o1I5lHkIjrrNCbQjy02di03P.
        //$2a$10$6BGDhd7nIueuuFT.sM3tBulfV0pOF0jKpLXSqqjdBlBIAh.ztDj9m
        System.out.println(pe.encode("1234"));
        System.out.println(pe.encode("1234"));

        //3. 匹配 参数一：明文密码，参数二： 密文密码
        boolean flag = pe.matches("1234" , "$2a$10$6BGDhd7nIueuuFT.sM3tBulfV0pOF0jKpLXSqqjdBlBIAh.ztDj9m");

        System.out.println("flag=" + flag);

    }
}
