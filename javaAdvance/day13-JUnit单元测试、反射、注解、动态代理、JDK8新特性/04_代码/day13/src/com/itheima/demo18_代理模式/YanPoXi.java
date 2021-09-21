package com.itheima.demo18_代理模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 16:25
 */
// 被代理者
public class YanPoXi implements FindHappy {
    @Override
    public void happy() {
        System.out.println("阎婆惜正在happy...");
    }
}
