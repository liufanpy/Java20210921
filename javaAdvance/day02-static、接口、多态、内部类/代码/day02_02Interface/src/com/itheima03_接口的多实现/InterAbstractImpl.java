package com.itheima03_接口的多实现;

import javax.sound.midi.Soundbank;

public abstract class InterAbstractImpl implements MyInterA, MyInterB {
    @Override
    public void defaultMethod() {
        System.out.println("抽象类重写了父接口中的同名默认方法");
    }
}
