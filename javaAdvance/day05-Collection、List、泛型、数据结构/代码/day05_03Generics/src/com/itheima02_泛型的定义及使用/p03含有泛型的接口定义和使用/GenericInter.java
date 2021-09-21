package com.itheima02_泛型的定义及使用.p03含有泛型的接口定义和使用;

import java.util.Collection;

public interface GenericInter<TSL> {
    public void show(TSL tsl);
    public TSL get();
}
