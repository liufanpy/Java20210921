package com.itheima.demo11_序列化的注意事项;

import java.io.Serializable;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 15:22
 */
public class Pet implements Serializable {
    String name;

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
