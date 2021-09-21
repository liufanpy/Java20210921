package com.itheima08_自定义异常;

import java.util.ArrayList;
import java.util.Scanner;

/*
概述
    在开发中根据自己业务的异常情况来定义异常类表示某种异常问题.
    Java中异常类具备异常发生中断程序的功能，但一些异常情况是java没有定义的,需要根据业务自行定义(例：年龄负数问题)
    自定义异常类分类
        自定义编译期异常： 自定义类 并继承于java.lang.Exception
        自定义运行时期异常：自定义类 并继承于java.lang.RuntimeException
需求：按照如下要求完成案例
    模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册
分析:
    首先定义一个注册异常类RegisterException
    模拟注册操作，使用数组模拟数据库中存储的数据，并提供当前注册账号是否存在方法用于判断。

 */
public class Test {

    public static void main(String[] args) {

        //模拟数据库中存在的用户名
        String[] useNames = {"zhangsan", "lisi", "wangwu"};
        //使用键盘录入模拟输入用户名的操作
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您想要申请的账户名...");
        String useName = sc.nextLine();
        //做验证
        // try {
        //     boolean flag = checkUseName(useName, useNames);
        // } catch (RegisterException r) {
        //     r.printStackTrace();
        //     //弹出一个对话框
        // }
        try {
            if (checkUseName(useName, useNames)) {
                System.out.println("恭喜您，您注册的账号未被是申请，您可以继续录入您的专属密码...");
            }
        } catch (RegisterException r) {
            // r.printStackTrace();
            //弹出一个对话框
            System.out.println("抱歉，您输入的账户名已被他人注册，请您重新输入您要申请的账号");
        }

    }

    public static boolean checkUseName(String useName, String[] useNames) throws RegisterException {

        for (int i = 0; i < useNames.length; i++) {
            String sysUseName = useNames[i];
            //一旦发现用户名在数组用已经存在了，抛出一个用户名已存在异常
            if (sysUseName.equals(useName)) {
                throw new RegisterException("已被注册的用户名:" + useName);
            }
        }
        return true;
    }
}
