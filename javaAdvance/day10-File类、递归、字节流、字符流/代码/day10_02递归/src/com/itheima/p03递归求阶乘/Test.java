package com.itheima.p03递归求阶乘;

/*
需求:使用递归实现5的阶乘运算。
分析
    阶乘：所有小于及等于该数的正整数的积。n的阶乘：n! = n * (n-1) *...* 3 * 2 * 1
    理解：这与累加求和类似,只不过换成了乘法运算，同学们可以自己练习，需要注意阶乘值符合int类型的范围。
    推理得出：n! = n * (n-1)!
规律:   n!  =   n*(n-1)!
出口:   n=1，结果=1
 */
public class Test {
    public static void main(String[] args) {
        int multiply = getMultiply(5);
        System.out.println(multiply);
    }

    public static int getMultiply(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getMultiply(n - 1);
    }
}
