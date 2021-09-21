package com.itheima02_泛型的定义及使用.p02含有泛型的方法定义和使用;

/*
概述:含有泛型的方法参数为泛型时才有意义，近似于参数为Object类型的使用，节省了向下转型的过程，在调用方法时，确定泛型类型
定义格式
    修饰符  <代表泛型的变量> 返回值类型 方法名(代表泛型的变量  变量名...){  }
使用格式
    对象.方法名()
需求：定义泛型方法，并将该泛型应用到参数和返回值类型中

 */
public class Test {
    public static void main(String[] args) {
        GenericsMethod gm = new GenericsMethod();
        gm.show("abc");
        String s = gm.get("abc");
        System.out.println(s);
    }
}
