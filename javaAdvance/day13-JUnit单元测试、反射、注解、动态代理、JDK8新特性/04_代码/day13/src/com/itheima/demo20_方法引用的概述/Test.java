package com.itheima.demo20_方法引用的概述;

import java.util.Collections;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 17:07
 */
public class Test {

    public static void printStr(){
        System.out.println("哈哈哈哈,快要下课啦....");
        System.out.println("哈哈哈哈,快要下课啦....");
        System.out.println("哈哈哈哈,快要下课啦....");
    }

    public static void main(String[] args) {
        /*
            - 概述:方法引用使用一对冒号 :: , 方法引用就是用来在一定的情况下,替换Lambda表达式
            - 使用场景:
              - 如果一个Lambda表达式大括号中的代码和另一个方法中的代码一模一样,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式
              - 如果一个Lambda表达式大括号中的代码就是调用另一方法,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式

             Lambda表达式使用套路:
                1.分析能不能使用Lambda表达式--->判断是否是函数接口
                2.如果可以使用Lambda表达式,就直接写上()->{}
                3.填充小括号里面的内容---->小括号中的内容和函数式接口中抽象方法的形参列表一致
                4.填充大括号里面的内容---->大括号中的内容和实现函数式接口中抽象方法的方法体一致

             Lambda表达式省略规则:
                1.小括号中的参数类型可以省略
                2.小括号中如果只有一个参数,那么小括号也可以省略
                3.大括号中如果只有一条语句,那么大括号,分号,return可以省略(必须一起省略)
         */
        // 如果一个Lambda表达式大括号中的代码和另一个方法中的代码一模一样
        /*new Thread(()->{
            System.out.println("哈哈哈哈,快要下课啦....");
            System.out.println("哈哈哈哈,快要下课啦....");
            System.out.println("哈哈哈哈,快要下课啦....");
        }).start();*/

        //如果一个Lambda表达式大括号中的代码就是调用另一方法
        /*new Thread(()->{
            Test.printStr();
        }).start();*/

        new Thread(Test::printStr).start();


    }
}
