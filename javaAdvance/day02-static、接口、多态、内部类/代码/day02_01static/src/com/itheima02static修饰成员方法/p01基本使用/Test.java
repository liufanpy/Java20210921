package com.itheima02static修饰成员方法.p01基本使用;

/*
理解:static修饰成员位置的方法，称为类方法。类方法可以且建议直接使用类名调用。
定义格式:
    修饰符 static 返回值类型 方法名 (参数列表){
    	// 执行语句
    }；
使用格式:
    类名.静态方法名(参数)；
需求：通过Utils方法定义一个静态方法，快速计算两个数的和


 */
public class Test {
    public static void main(String[] args) {
        int sum = Utils.getSum(10, 20);
        System.out.println(sum);
        int a = 10;
        int b = 20;
        System.out.println(Utils.getSum(a, b));
    }
}
