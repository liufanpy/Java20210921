package com.itheima06_引用数据类型转换.p03引用类型转换问题解决;


/*
解决办法:变量名 instanceof 数据类型
    如果变量属于该数据类型，返回true。
    如果变量不属于该数据类型，返回false。
需求:使用instanceof解决上述问题

 */
public class Test {
    public static void main(String[] args) {
        Cat c = new Cat();
        showAnimal(c);
        Dog d = new Dog();
        showAnimal(d);
    }

    public static void showAnimal(Animal a) {
        if (a instanceof Cat) {
            a.eat();
            Cat c = (Cat) a;
            c.catchMouse();
        } else if (a instanceof Dog) {
            a.eat();
            Dog d = (Dog) a;
            d.lookHome();
        }
    }
}
