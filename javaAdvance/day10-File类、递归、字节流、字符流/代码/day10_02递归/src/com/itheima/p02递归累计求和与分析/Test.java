package com.itheima.p02递归累计求和与分析;

/*
需求：计算1 ~ n的和
分析：num的累和 = num + (num-1)的累和，所以可以把累和的操作定义成一个方法，递归调用。
 */
public class Test {
    public static void main(String[] args) {
        int sum = getSum(5);
        System.out.println(sum);
    }

    public static int getSum(int n) {
        // getSum(n-1) 1~(n-1)的总和
        //1~(n-1)的总和  +   n  就是1~n的总和

        // 出口: n=1   和就是1本身
        if (n == 1) {
            return 1;
        }
        return n + getSum(n - 1);
    }
}
