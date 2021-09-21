package com.itheima04_多态的应用场景;

/*
变量多态的使用
    父类/接口名  变量名   = 子类/实现类对象;
    变量名.方法名();
形参多态的使用
    修饰符 返回值 方法名(父类名 变量名){
        变量名.方法名();
    }
返回值多态的使用
    修饰符 父类/接口名 方法名(参数) {
        return 子类/实现类对象;
    }
需求：通过如下类演示变量多态使用
    动物类：
        行为：吃
    猫类：
        行为：吃
    狗类：
        行为：吃

 */
public class Test {
    public static void main(String[] args) {
        // 变量多态的使用
        Animal a = new Cat();
        a.eat();
        a = new Dog();
        a.eat();
        System.out.println("--------");
        // 形参多态的使用
        Cat c = new Cat();
        showCat(c);
        Dog d = new Dog();
        showDog(d);
        //如果还有很多的动物，不得不为每一种动物都单独创建一个展示方法
        //有没有办法，之定义一个方法，就能展示所有的动物
        showAnimal(c);
        showAnimal(d);
        System.out.println("--------");
        // 返回值多态的使用
        Cat c2 = getCat();
        c2.eat();
        Dog d2 = getDog();
        d2.eat();
        //如果还有很多的动物，不得不为每一种动物都单独创建一个获取方法
        //有没有办法，只定义一个方法，就能获取所有的动物
        Animal a2 = getAnimal("猫");
        a2.eat();
        a2 = getAnimal("狗");
        a2.eat();
    }

    public static void showCat(Cat c) {
        c.eat();
    }

    public static void showDog(Dog d) {
        d.eat();
    }

    public static void showAnimal(Animal a) {
        a.eat();
    }

    public static Cat getCat() {
        return new Cat();
    }

    public static Dog getDog() {
        return new Dog();
    }

    public static Animal getAnimal(String type) {
        /*Animal a = null;
        if (type.equals("猫")) {
            a = new Cat();
        } else if (type.equals("狗")) {
            a = new Dog();
        } else {
            System.out.println("您输入的数据类型不存在");
        }

        return a;
        */
        if (type.equals("猫")) {
            return new Cat();
        } else if (type.equals("狗")) {
            return new Dog();
        } else {
            System.out.println("您输入的数据类型不存在");
            return null;
        }

    }
}
