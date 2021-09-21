package com.itheima02_引用类型作为成员变量;

public class Hero {
    private String name;
    private Weapon wuqi;
    private Magic fashu;

    public Hero() {
    }

    public Hero(String name, Weapon wuqi, Magic fashu) {
        this.name = name;
        this.wuqi = wuqi;
        this.fashu = fashu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWuqi() {
        return wuqi;
    }

    public void setWuqi(Weapon wuqi) {
        this.wuqi = wuqi;
    }

    public Magic getFashu() {
        return fashu;
    }

    public void setFashu(Magic fashu) {
        this.fashu = fashu;
    }

    public void showHero() {
        System.out.println("展示英雄");
        System.out.println("英雄大名:" + name);
        System.out.println("英雄武器");
        System.out.println("武器名:" + wuqi.getName());
        System.out.println("武器技能");
        wuqi.nearAttack();
        System.out.println("英雄法术");
        System.out.println("法术名:" + fashu.getName());
        System.out.println("法术技能");
        fashu.farAttack();
    }
}
