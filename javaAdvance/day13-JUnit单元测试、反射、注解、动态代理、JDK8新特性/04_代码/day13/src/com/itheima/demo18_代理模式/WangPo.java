package com.itheima.demo18_代理模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 16:26
 */
// 代理者
public class WangPo implements FindHappy {

    FindHappy fh;

    public WangPo(FindHappy fh) {
        this.fh = fh;
    }

    @Override
    public void happy() {
        System.out.println("王婆开好房间,把2人约到房间...");
        // 被代理者去happy
        fh.happy();

        System.out.println("王婆打扫战场....");
    }
}
