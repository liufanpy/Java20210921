package com.itheima02_匿名内部类定义及使用;

/*
匿名内部类是内部类的简化写法。它的本质是一个`带具体实现的`父类或者父接口的`匿名的` 子类/实现类对象。
匿名内部类意义:简化步骤，当接口或类中的功能只需要使用一次的时候，可以使用。
    使用格式:
    new 父类名或者接口名(){
        // 方法重写
    };
使用场景
    通过多态的形式指向父类引用
    直接调用方法
    作为方法参数传递
需求：通过定义如下接口，并演示匿名内部类使用
飞行接口
	行为：飞行
 */
public class Test {
    public static void main(String[] args) {
        //普通形式
        // FlyClass fc = new FlyClass();
        Flyable f = new FlyClass();
        f.fly();
        //匿名内部类
        // 通过多态的形式指向父类引用
        f = new Flyable() {
            @Override
            public void fly() {
                System.out.println("我要比第1次飞的更高...");
            }
        };
        f.fly();
        // 直接调用方法
        new Flyable() {
            @Override
            public void fly() {
                System.out.println("我要比第2次飞的更高...");
            }
        }.fly();
        // 作为方法参数传递
        showFly(new Flyable() {
            @Override
            public void fly() {
                System.out.println("我要比第3次飞的更高...");
            }
        });
    }

    public static void showFly(Flyable f) {
        f.fly();
    }
}
