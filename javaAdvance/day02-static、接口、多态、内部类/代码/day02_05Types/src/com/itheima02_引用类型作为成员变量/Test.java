package com.itheima02_引用类型作为成员变量;

/*
需求：根据如下定义一个英雄类
    英雄类
    属性：姓名，武器，法术
    行为：展示英雄

 */
public class Test {
    public static void main(String[] args) {
        //定义武器
        Weapon w = new Weapon("方天画戟");
        //定义法术
        Magic m = new Magic("天崩地裂");
        //定义英雄
        Hero h = new Hero("吕布", w, m);
        h.showHero();
    }
}
