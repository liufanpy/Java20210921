package com.itheima05_获取异常信息;

/*
Throwable类中常用方法
    public String getMessage()：获取异常的描述信息,原因(提示给用户的时候,就提示错误原因
    public String toString()：获取异常的类型和异常描述信息(不用)
    public void printStackTrace()：打印异常的跟踪栈信息并输出到控制台
需求：通过除数为0异常演示获取异常信息的使用

 */
public class Test {
    public static void main(String[] args) {
        System.out.println("开始");
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException a) {
            System.out.println(a.getMessage());
            System.out.println(a.toString());
            a.printStackTrace();
        }
        System.out.println("结束");
    }
}
