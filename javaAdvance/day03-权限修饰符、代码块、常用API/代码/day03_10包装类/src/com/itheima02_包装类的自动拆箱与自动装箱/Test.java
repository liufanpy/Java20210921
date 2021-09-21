package com.itheima02_包装类的自动拆箱与自动装箱;

/*
概述:
    基本类型与包装类的转换较为常见，Java 5开始，装箱、拆箱动作可以自动完成。
    自动装箱：基本类型传递给包装类型
    自动拆箱：包装类型传递给基本类型
需求：演示自动装箱与自动拆箱

 */
public class Test {
    public static void main(String[] args) {
        //自动装箱
        int i1 = 10;
        Integer ii1 = i1;
        System.out.println(ii1);
        // 自动拆箱
        Integer ii2 = new Integer(20);
        int i2 =ii2;//intValue
    }
}
