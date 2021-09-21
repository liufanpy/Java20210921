package com.itheima.demo3_Junit断言;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 9:30
 */
public class Demo {


    @Test
    public void test1() {
        int sum = getSum(10, 20);

        // 断言：预先判断某个条件一定成立，如果条件不成立，则直接报错。 使用Assert类中的assertEquals()方法
        // 参数1: 期望的值
        // 参数2: 实际的值
        // 如果时间的值和期望的值相等,就不报错,否则就直接报错
        Assert.assertEquals(30,sum);

        sum += 10;
        System.out.println("sum:" + sum);// sum: 40
    }


    public int getSum(int num1, int num2) {
        return num1 * num2;
    }

}
