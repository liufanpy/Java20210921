package com.itheima.demo6_枚举中的其他内容;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 10:02
 */
public class Test {
    public static void main(String[] args) {
        // 使用Sex枚举
        // 1.定义一个Sex枚举类型的变量
        Sex sex1 = Sex.GIRL;

        // 2.使用sex1访问成员变量或者成员方法
        System.out.println(sex1.num);// 10
        sex1.show();// show...
    }
}
