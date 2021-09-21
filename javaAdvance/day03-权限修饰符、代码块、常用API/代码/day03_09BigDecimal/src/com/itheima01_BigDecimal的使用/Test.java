package com.itheima01_BigDecimal的使用;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/*
概述:
    java.math.BigDecimal  为浮点数提供精准计算的类
    浮点数由指数和尾数组成，目的是增大数值范围，问题是容易丢失精确度，导致运算误差。
     	System.out.println(0.09 + 0.01);
     	System.out.println(1.0-0.32);
     	System.out.println(1.015*100);
     	System.out.println(1.301 / 100);
构造方法:
    (不推荐使用)public BigDecimal(double val)  将double类型的数据封装为BigDecimal对象.
   public BigDecimal(String val)  将 BigDecimal 的字符串表示形式转换为 BigDecimal
常用方法:
    加法运算	public BigDecimal add(BigDecimal value)
    减法运算	public BigDecimal subtract(BigDecimal value)
    乘法运算	public BigDecimal multiply(BigDecimal value)
    除法运算
    public BigDecimal divide(BigDecimal value)  不推荐
    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)
     	divisor：除数对应的BigDecimal对象；
     	scale:精确的位数；
     	roundingMode取舍模式  枚举类型，示例： RoundingMode.HALF_UP 四舍五入
需求：演示BigDecimal类的构造方法与常用方法

 */
public class Test {
    public static void main(String[] args) {
        // System.out.println(0.09 + 0.01);
        // System.out.println(1.0 - 0.32);
        // System.out.println(1.015 * 100);
        // System.out.println(1.301 / 100);
        System.out.println("--------");
        // public BigDecimal(double val)  不推荐使用
        // BigDecimal b1 = new BigDecimal(0.09);
        // BigDecimal b2 = new BigDecimal(0.01);
        // BigDecimal add = b1.add(b2);
        // System.out.println(add);
        System.out.println("--------");
        // public BigDecimal(String val)
        // public BigDecimal add(BigDecimal value)
        BigDecimal b1 = new BigDecimal("0.09");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.add(b2));
        // public BigDecimal subtract(BigDecimal value)
        BigDecimal b3 = new BigDecimal("1.0");
        BigDecimal b4 = new BigDecimal("0.32");
        System.out.println(b3.subtract(b4));
        // public BigDecimal multiply(BigDecimal value)
        BigDecimal b5 = new BigDecimal("1.015");
        BigDecimal b6 = new BigDecimal("100");
        System.out.println(b5.multiply(b6));
        // public BigDecimal divide(BigDecimal value)
        BigDecimal b7 = new BigDecimal("1.301");
        BigDecimal b8 = new BigDecimal("100");
        System.out.println(b7.divide(b8));
        System.out.println("--------");
        BigDecimal b9 = new BigDecimal("10");
        BigDecimal b10 = new BigDecimal("3");
        // System.out.println(b9.divide(b10));//java.lang.ArithmeticException
        // public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)
        System.out.println(b9.divide(b10,2,RoundingMode.HALF_UP));
    }
}
