package com.itheima06_引用数据类型转换.p02类型转换问题演示;

/*
需求:通过下述需求,演示类型转换中存在的异常问题
猫类：
	行为：吃，抓耗子
狗类：
	行为：吃，看家
类型转换的异常问题:类型转换异常(ClassCastException)
原因:
    子类引用指向父类对象
    不存在继承/实现关系


 */
public class Test {
    public static void main(String[] args) {

        //展示猫
        Cat c = new Cat();
        showAnimal(c);
        //展示狗
        Dog d = new Dog();
        showAnimal(d);
    }

    public static void showAnimal(Animal a) {
        a.eat();
        Cat c = (Cat) a;// java.lang.ClassCastException  把狗对象转为了猫的引用，索引报错(它们俩没有子父类关系)
        c.catchMouse();
    }
}
