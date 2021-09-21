package com.itheima02_泛型的定义及使用.p03含有泛型的接口定义和使用;

public class GenericsInterImpl1 implements GenericInter<String> {

    @Override
    public void show(String s) {
        System.out.println("abc");
    }

    @Override
    public String get() {
        return "abc";
    }
}
