package com.itheima.demo18_代理模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 16:25
 */
public class Test {
    public static void main(String[] args) {
        // 创建JinLian对象
        JinLian jl = new JinLian();
        //fh.happy();

        // 创建YanPoXi对象
        YanPoXi ypx = new YanPoXi();

        // 创建代理对象WangPo
        WangPo wp = new WangPo(ypx);
        //WangPo wp = new WangPo(jl);
        wp.happy();
    }
}
