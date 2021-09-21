package com.itheima06_抽象类和接口的练习;

/*
需求:针对下面的类，演示抽象类和接口的用法
犬：
    行为：吼叫；吃饭；
缉毒犬：
    行为：吼叫；吃饭；缉毒；
分析
    吼叫和吃饭是所有狗都具备的功能，应该定义在父类中，即对于属性和行为的抽取放到父类中。
    缉毒功能，除狗之外，还有缉毒猪，缉毒鼠等。属于狗可能拥有的额外功能，应该定义到接口中。
实现：定义抽象修饰的狗类--定义拥有缉毒功能的接口--定义子类继承狗类，并实现接口

 */
public class Test {
    public static void main(String[] args) {
        JiDuDog jdd = new JiDuDog();
        jdd.eat();
        jdd.jiDu();
        jdd.cry();
    }
}
