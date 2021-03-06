package com.itheima06_引用数据类型转换.p01引用类型转换实现;

/*
为什么转换
    由于多态弊端，不能调用子类/实现类的特有方法，若强行调用子类/实现类特有方法，导致编译报错。
引用类型转换分类
    向上转型:子类/实现类类型向父类/接口类型转换的过程，称为向上转型。这个过程是默认的。
        格式:父类类型  变量名 = new 子类类型()  或 子类对象引用;
    向下转型:父类/接口类型向子类/实现类类型转换的过程，称为向下转型，这个过程需要强制执行。
        格式:子类类型 变量名 = (子类类型) 父类变量名;
需求：根据如下类演示类型转换
Fu类
    行为:method
Zi类
    行为:method show


 */
public class Test {
    public static void main(String[] args) {
        //自动类型转换
        Fu f = new Zi();
        // f.show();//父类引用不能调用子类特有方法，需要转换为子类自己的引用
        Zi z = (Zi) f;
        z.show();
        z.method();

    }
}
