package com.itheima02_引用类型作为成员变量;

public class Weapon {
    private String name;

    public Weapon() {
    }

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void nearAttack() {
        System.out.println("使用" + name + "砍人");
    }
}
