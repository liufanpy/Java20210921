package com.itheima01_冒泡排序;

import java.util.Arrays;

/*
原理
    对要进行排序的数据中相邻的数据进行两两比较，将较大的数据放在后面
    每一轮比较完毕，最大值在最后面，下一轮比较就少一个数据参与
    每轮比较都从第一个元素(索引为0的元素)开始
    依次执行，直至所有数据按要求完成排序
    如果有n个数据进行排序，总共需要比较n1轮
需求：在数组中存储，“7, 6, 5, 4, 3”五个数据，并使用冒泡排序进行排序

 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3};
        //比较的轮数  因为比较的轮数比数组元素的个数少1，所以 arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            //为了让我们每轮计算的时候，不必要比较后面得出来的最大值，从而提高效率,所以需要arr.length - i
            //为了避免角标越界，还需要执行arr.length  - 1
            for (int j = 0; j < arr.length - i - 1; j++) {
                int qian = arr[j];
                int hou = arr[j + 1];
                if (qian > hou) {
                    int temp = qian;
                    arr[j] = hou;
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
