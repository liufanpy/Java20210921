package com.itheima03_声明异常;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
概述:
    处理异常的方式，在方法上声明方法中存在的一个或多个问题标识，提醒调用者处理这些异常
    处理方式：
        如果是运行时异常,默认被声明抛出(也可以显示抛出)
        如果是编译时异常，且没有以捕获方式处理，就必须通过throws声明，否则报错
        当异常出现，将这个异常对象传递到调用者处，并结束当前方法的执行。
    格式：修饰符 返回值类型 方法名(参数)  throws 异常类名1,异常类名2…{   }
需求：通过被除数为0异常和日期解析异常，演示thorws的使用
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        method();// ParseException
    }

    // public static void method() throws ParseException{// 如果是运行时异常,默认被声明抛出(也可以显示抛出)
    public static void method() throws RuntimeException, ParseException {
        System.out.println(10 / 0);

        String time = "2020-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(time);
    }
}
