package com.itheima02_引用类型作为成员变量;

public class Magic {
    private String name;

    public Magic() {
    }

    public Magic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void farAttack() {
        System.out.println("使用技能" + name);
    }
}
