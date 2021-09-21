package com.itheima03_泛型通配符.p02泛型通配符的应用;


import java.util.ArrayList;
import java.util.Collection;

/*
概述:使用含泛型通配符形式,将拥有泛型的类或接口作为参数
应用形式
    形式1：修饰符  返回值 方法名(类名<?> 变量名){}
    形式2：修饰符  返回值 方法名(类名<? extends 数据类型>  变量名){}
    形式3：修饰符  返回值 方法名(类名<? super 数据类型>  变量名){}
需求：使用父子孙类演示泛型受限的使用

 */
public class Test {
    public static void main(String[] args) {
        Collection<Ye> co1 = new ArrayList<>();
        Collection<Fu> co2 = new ArrayList<>();
        Collection<Zi> co3 = new ArrayList<>();
        // 形式1：修饰符  返回值 方法名(类名<?> 变量名){}
        showCollection1(co1);
        showCollection1(co2);
        showCollection1(co3);
        // 形式2：修饰符  返回值 方法名(类名<? extends 数据类型>  变量名){}
        // showCollection2(co1);
        showCollection2(co2);
        showCollection2(co3);
        // 形式3：修饰符  返回值 方法名(类名<? super 数据类型>  变量名){}
        showCollection3(co1);
        showCollection3(co2);
        // showCollection3(co3);
    }

    // 形式1：修饰符  返回值 方法名(类名<?> 变量名){}
    public static void showCollection1(Collection<?> c) {
        System.out.println("" + c);
    }

    // 形式2：修饰符  返回值 方法名(类名<? extends 数据类型>  变量名){}
    public static void showCollection2(Collection<? extends Fu> c) {
        System.out.println("" + c);
    }

    // 形式3：修饰符  返回值 方法名(类名<? super 数据类型>  变量名){}
    public static void showCollection3(Collection<? super Fu> c) {
        System.out.println("" + c);
    }
}
