package com.itheima01_成员内部类定义及使用;

public class Person {
    private boolean live;//false

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

     class Heart {
        public void jump() {
            if (live) {
                System.out.println("心脏在嘭嘭嘭的跳动....");
            } else {
                System.out.println("bi..bi..bi......");
            }
        }
    }
}
