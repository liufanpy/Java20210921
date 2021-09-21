package com.itheima04static在开发中的应用;

public class MathUtils {
    //表示圆周率
    public static final double PI = 3.14;

    /**
     * @param arr  这里的arr表示传入的要求最大值的数组
     * @return  这里的返回值表示的是数组中的最大值
     */
    public static int getMax(int[] arr) {
        int max = arr[0];

        //itar 快速生成数组遍历
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
