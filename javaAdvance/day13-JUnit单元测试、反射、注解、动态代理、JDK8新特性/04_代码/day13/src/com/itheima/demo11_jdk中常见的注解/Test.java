package com.itheima.demo11_jdk中常见的注解;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 12:17
 */
@SuppressWarnings("all")
public class Test {
    /*
        @Override:描述方法的重写.
        @SuppressWarnings:压制\忽略警告.
        @Deprecated:标记过时
     */
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        int num;
    }

    @Deprecated
    public static void show1(){
        System.out.println("过时的方法...");
    }

    public static void show2(){
        System.out.println("更新的方法...");
    }

}
