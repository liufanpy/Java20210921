package com.itheima.demo18_代理模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 16:25
 */
// 被代理者
public class JinLian implements FindHappy {
    @Override
    public void happy() {
        System.out.println("金莲正在happy...");
    }
}
