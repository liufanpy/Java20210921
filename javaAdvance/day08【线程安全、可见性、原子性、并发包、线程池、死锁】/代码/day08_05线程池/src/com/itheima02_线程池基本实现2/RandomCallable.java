package com.itheima02_线程池基本实现2;

import java.util.concurrent.Callable;

public class RandomCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int random = (int) (Math.random() * 100);//基本数据类型  自动类型转换 强制类型转换
        return random;
    }
}
