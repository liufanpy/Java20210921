package com.itheima02_泛型的定义及使用.p01含有泛型的类的定义和使用;

public class GenericsClass<BMW> {

    public void show(BMW bmw) {
        System.out.println(bmw);
    }

    //假设我将来传入的数据类型一定是String
    public BMW get() {
        BMW bmw = (BMW) "abc";
        return bmw;
    }

}
