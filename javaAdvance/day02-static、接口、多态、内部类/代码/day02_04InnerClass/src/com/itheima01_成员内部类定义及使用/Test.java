package com.itheima01_成员内部类定义及使用;

/*
将类B定义在类A里面，类B就称为内部类，类A则称为类B的外部类
内部类是一个独立的类，在编译后，有自己独立的class文件，前面冠以:外部类名+$+内部类类名标识
内部类的分类
    成员内部类
    匿名内部类
    局部内部类(自行了解)
定义在成员位置（类中方法外）的类称为成员内部类。
定义格式
    class 外部类 {
        class 内部类{
        }
    }
使用格式  外部类名.内部类名 对象名 = new 外部类型().new 内部类型();
成员内部类访问特点
    内部类可以直接访问外部类的成员，包括私有成员。
    外部类要访问内部类的成员，必须要建立内部类的对象。
需求：使用成员内部类的关系定义如下类
人类
    属性：是否存活
心脏：
    行为：跳动

 */
public class Test {
    public static void main(String[] args) {
        // Person.Heart ph = new  Person().new Heart();
        Person p = new Person();
        Person.Heart ph  =p.new Heart();
        p.setLive(true);
        ph.jump();
        p.setLive(false);
        ph.jump();
    }
}
