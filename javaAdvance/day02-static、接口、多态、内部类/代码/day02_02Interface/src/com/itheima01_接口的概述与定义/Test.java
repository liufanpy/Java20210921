package com.itheima01_接口的概述与定义;

/*
什么是接口
    java的一种引用类型，是方法的集合。
    如果说类中封装了成员变量、构造方法和成员方法，那么接口中封装了方法。
接口中的成员
    没有静态代码块，没有成员变量，没有构造方法，只能定义常量。
    有抽象方法（JDK 7及以前），默认方法(类似于类中的成员方法)和静态方法（JDK 8）
接口的编译
    接口的定义，它与定义类方式相似，但是使用 `interface` 关键字。
    接口会被编译成.class文件，但它并不是类，而是另外一种引用数据类型。
    接口中没有构造方法，不能创建对象，可以被实现(重写方法)，类似于继承，通过其实现类创建对象

接口格式
    public interface 接口名称 {
    	// 静态常量
    	// 抽象方法
    	// 默认方法
    	// 静态方法
    }
接口中的成员定义规则
    静态常量格式:public static final 数据类型 变量名 = 值;
        public static final可以省略
    抽象方法格式：public abstract 返回值 方法名(参数列表);
        public abstract 可以省略，供实现类重写。
    默认方法格式：public default 返回值 方法名(参数列表) { // 执行语句  }
        default 不可省略，供实现类调用或者实现类重写。
    静态方法格式：public  static 返回值 方法名(参数列表) { // 执行语句  }
        static 不可省略，供实现类调用或者实现类重写
需求:定义一个接口，演示接口的成员的定义
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(MyInter.NUM);//证明了num是被static修饰的
        // MyInter.NUM=20;//Cannot assign a value to final variable 'num' 证明了num是被final修饰的
    }
}
