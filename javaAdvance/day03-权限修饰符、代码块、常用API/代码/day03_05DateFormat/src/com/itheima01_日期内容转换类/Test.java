package com.itheima01_日期内容转换类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
概述:
    java.text.DateFormat 该类可以使得在Date对象与String对象之间进行来回转换.
    格式化：按照指定的格式，把Date对象转换为String对象。
    解析：按照指定的格式，把String对象转换为Date对象。
构造方法:
    DateFormat为抽象类，需要使用其子类java.text.SimpleDateFormat创建对象。
    public SimpleDateFormat(String pattern)：用给定模式和默认语言环境日期格式符号构造参数
        pattern是一个字符串，代表日期时间的自定义格式。
        构造格式常见规则:y--年   M--月  d--日  H--时  m--分   s--秒
        格式举例:yyyyMMdd HH:mm:ss  或者  yyyy年MM月dd日 HH:mm:ss .... 或者yyyyMMdd
常见功能:
    public String format(Date date)：将Date对象格式化为字符串。
    public Date parse(String source)：将字符串解析为Date对象。
需求：演示Date类与字符串类型的格式化和解析

 */
public class Test {
    public static void main(String[] args) throws ParseException {
        // public SimpleDateFormat(String pattern)：2021年04月03日 11:50:00
        DateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        // public String format(Date date)
        Date d = new Date();
        String format = f.format(d);
        System.out.println(format);
        // public Date parse(String source)
        // String time ="2021-04-03";
        String time ="2021年04月03日 11:50:00";
        Date parse = f.parse(time);// java.text.ParseException: Unparseable date: "2021-04-03"
        System.out.println(parse);

    }

}
