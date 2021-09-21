package com.itheima02_泛型的定义及使用.p02含有泛型的方法定义和使用;

public class GenericsMethod {
    public <BYD> void show(BYD byd){
        System.out.println(byd);
    }
    //假设我将来传入的数据类型一定是String
    public <BYD> BYD get(BYD byd){
        BYD b = (BYD)"abc";
        return b;
    }
}
