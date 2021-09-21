package com.itheima02_泛型的定义及使用.p03含有泛型的接口定义和使用;

public class GenericsInterImpl2<WL> implements GenericInter<WL> {


    public void show(WL bmw) {
        System.out.println(bmw);
    }

    //假设我将来传入的数据类型一定是String
    public WL get() {
        WL wl = (WL) "def";
        return wl;
    }
}
