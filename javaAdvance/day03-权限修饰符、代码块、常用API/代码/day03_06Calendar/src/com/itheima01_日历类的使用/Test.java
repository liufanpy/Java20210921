package com.itheima01_日历类的使用;

import java.util.Calendar;

/*
概述:
    java.util.Calendar类表示一个“日历类”，可以进行日期运算。
    注意事项：
      日历对象中的星期是从1-7来表示，1表示星期天。
      日历对象中的月份是从0-11来表示，0表示一月份
构造方法:
    Calendar类是一个抽象类，可以使用它的子类：java.util.GregorianCalendar类
    通过Calendar的静态方法getInstance()方法获取GregorianCalendar对象
       public static Calendar getInstance()   获取一个它的子类GregorianCalendar对象
常用方法
    public int get(int field)  获取某个字段的值。
    public void set(int field,int value)  设置某个字段的值
    public void add(int field,int amount)  为某个字段增加/减少指定的值
    field参数表示获取哪个字段的值，可以使用Calender中定义的常量来表示。
     	    Calendar.YEAR : 年 | Calendar.MONTH ：月 | Calendar.DAY_OF_MONTH：日
     	    Calendar.HOUR : 时 | Calendar.MINUTE：分 | Calendar.SECOND：秒
     	    Calendar.DAY_OF_WEEK：星期
需求：按照下述需求，演示Calendar类的构造方法与常用方法
    1.获取当前日期对象，并展示当前日期详细时间。
    2.设置当前日期对象为一个月以后的第一天，查看当时的详细时间。
    3.将当前日期对象的月份增加100000分钟，查看当时的详细时间。

 */
public class Test {
    public static void main(String[] args) {
        // public static Calendar getInstance()
        Calendar c = Calendar.getInstance();
        //1.获取当前日期对象，并展示当前日期详细时间。
        // System.out.println(c);
        // public int get(int field)
        // ctrl+alt+M 抽取方法
        showCalendar(c);
        // 2.设置当前日期对象为一个月以后的第一天，查看当时的详细时间。
        // public void set(int field,int value)
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.MONTH,4);
        c2.set(Calendar.DAY_OF_MONTH,1);
        showCalendar(c2);
        // 3.将当前日期对象的月份增加100000分钟，查看当时的详细时间。
        //public void add(int field,int amount)
        Calendar c3 = Calendar.getInstance();
        c3.add(Calendar.MINUTE,100000);
        showCalendar(c3);

    }

    public static void showCalendar(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        // int hour = c.get(Calendar.HOUR);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        System.out.println(year + "年" + (++month) + "月" + day + "日 " + hour + "时" + minute + "分" + second + "秒");

        String week = getWeek(c);
        System.out.println(week);
    }


    public static String getWeek(Calendar c) {
        String[] weeks = {"星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int weekNum = c.get(Calendar.DAY_OF_WEEK);
        weekNum--;
        String week = weeks[weekNum];//7
        return week;

    }
}
