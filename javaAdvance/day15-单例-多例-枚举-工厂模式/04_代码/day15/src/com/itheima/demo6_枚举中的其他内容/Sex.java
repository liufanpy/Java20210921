package com.itheima.demo6_枚举中的其他内容;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 10:00
 */
// 枚举本质其实就是一个使用了多例设计模式的类,所以枚举中还可以有成员变量，成员方法,构造方法等。
public enum Sex {
    BOY,GIRL,YAO;

    // 成员变量
    public int num = 10;

    // 构造方法
    private Sex(){

    }

    // 成员方法
    public void show(){
        System.out.println("show....");
    }

}
