package com.itheima.demo9_反射操作成员方法;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 11:12
 */
public class Person {

    public void show1(){
        System.out.println("无参数无返回值show1...");
    }

    public double show2(int num,String str){
        System.out.println("有参数有返回值show2...num:"+num+",str:"+str);
        return 3.14;
    }

    public void show3(int num){
        System.out.println("有参数无返回值show3...num:"+num);
    }

    public String show4(){
        System.out.println("无参数有返回值show4...");
        return "itheima";
    }

    private double show1(int num,String str){
        System.out.println("有参数有返回值show1...num:"+num+",str:"+str);
        return 4.2;
    }
}
