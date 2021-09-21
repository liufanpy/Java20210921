package com.itheima03_基本类型与字符串之间的转换;

/*
基本类型转换为String
    方式一：直接在数字后加一个空字符串 数据+""
    方式二：通过String类静态方法valueOf(Xxx)
String转换成基本类型
    方式一：指定包装类的静态方法valueOf(String s)将字符串转为对应包装类
    方式二：通过包装类的静态方法parseXxx(String s)将字符串转为对应包装类
    String转char类型只能使用String类中非静态方法char charAt(int index)
    注意事项：数据要符合对应数据的类型格式
需求：演示基本类型与字符串之间的转换

 */
public class Test {
    public static void main(String[] args) {
        // 基本类型转换为String
        int i1 = 10;
        String s1 = "" + i1;
        String s2 = String.valueOf(i1);
        System.out.println(s1);
        System.out.println(s2);
        // String转换成基本类型
        String s3 = "10";
        // Integer integer = Integer.valueOf(s3);
        // int i3 =integer;
        int i3 = Integer.valueOf(s3);
        int i4 = Integer.parseInt(s3);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println("--------");
        String s4 = "abc";
        System.out.println(s4.charAt(0));
        System.out.println(s4.charAt(1));
        System.out.println(s4.charAt(2));
        // 注意事项：数据要符合对应数据的类型格式
        // java.lang.NumberFormatException
        // System.out.println(Integer.valueOf("shi"));
        // System.out.println(Integer.valueOf("拾"));
    }
}
