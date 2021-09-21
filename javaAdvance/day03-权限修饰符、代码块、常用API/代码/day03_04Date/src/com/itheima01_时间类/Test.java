package com.itheima01_时间类;

import java.math.BigDecimal;
import java.util.Date;

/*
概述:
    java.util.Date类 表示特定的瞬间，精确到毫秒。
    标准基准时间:【历元(epoch):1970年1月1日00:00:00 GMT)】,也称为时间原点。
    表示距离时间原点以来的毫秒代表的时间。
构造方法:
    public Date():为运行程序时到时间原点经历毫秒值，分配的Date对象,以表示该时刻。
    public Date(long date):为到时间原点的指定毫秒值，分配的Date对象,以表示该时刻。
常见功能:
    public long getTime() 把日期对象转换成对应的时间毫秒值。
    public void setTime(long time) 把方法参数给定的毫秒值设置给日期对象
需求：Date类的构造方法与常用方法

 */
public class Test {
    public static void main(String[] args) {
         // public Date()
        Date d1 = new Date();
        System.out.println(d1);
         // public Date(long date)
        Date d2 = new Date(0);
        System.out.println(d2);
        //public long getTime()
        System.out.println(d1.getTime());
        // public void setTime(long time)
        d1.setTime(0);
        System.out.println(d1);
    }
}
