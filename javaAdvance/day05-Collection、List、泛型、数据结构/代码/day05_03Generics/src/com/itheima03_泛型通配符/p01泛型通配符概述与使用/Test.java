package com.itheima03_泛型通配符.p01泛型通配符概述与使用;

import java.util.ArrayList;
import java.util.Collection;

/*
概述:泛型通配符用问号表示(?）
    泛型本身不存在继承关系，不可以给已指定泛型的变量接收有其他泛型类型的对象
        Collection<Object> list = new ArrayList<String>()//错误格式，泛型不存在继承关系
    如果想要使变量在未来接收有泛型定义的对象，又不确定泛型要定义的类型可以使用泛型通配符
使用格式
    数据类型 <?> 对象名称
    对象名 = 带具体泛型类型的对象
受限泛型:限制泛型数据类型的定义区间
    泛型的上限：接收泛型为该泛型数据类型或其子类的对象
        格式：数据类型 <? extends 泛型数据类型 > 对象名称
    泛型的下限：接收泛型为该泛型数据类型或其父类的对象
        格式： 数据类型 <? super 泛型数据类型 > 对象名称
需求：定义父子孙三个类，在测试类中演示泛型的基本使用及泛型受限的使用

 */
public class Test {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Collection<Object> c2;
        // c2=c;//不同泛型即使有字父类关系，也不能这么写，格式不支持
        // 如果想要使变量在未来接收有泛型定义的对象，又不确定泛型要定义的类型可以使用泛型通配符
        Collection<?> c3;//这里的<?>整体如果不写，效果是一样的
        c3 = c;

        System.out.println("--------");
        Collection<Ye> co1 = new ArrayList<>();
        Collection<Fu> co2 = new ArrayList<>();
        Collection<Zi> co3 = new ArrayList<>();
        //泛型的上限：接收泛型为该泛型数据类型或其子类的对象
        // 需求:c4将来只能接收co2和co3
        Collection<? extends Fu> c4;
        // c4 =co1;
        c4 = co2;
        c4 = co3;
        // 泛型的下限：接收泛型为该泛型数据类型或其父类的对象
        //需求:c4将来只能接收co1和co2
        Collection<? super Fu> c5;
        c5 = co1;
        c5 = co2;
        // c5=co3;
    }
}
