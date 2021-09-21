package com.itheima.proxy.jdk;

public class SuperStar implements Star {
    public void sing(String name) {
        System.out.println("明星在唱歌：" + name);
    }

    public void dance(String name) {
        System.out.println("明星在跳舞：" + name);
    }
}
