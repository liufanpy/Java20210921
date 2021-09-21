package com.itheima02_选择排序;

import java.util.Arrays;

/*
原理
    对要进行排序的数组中，使某个元素依次和后面的元素逐个比较，将较大的数据放在后面
    每一轮比较完毕，最小值在最前面，下一轮比较就少一个数据参与
    每轮比较都从下一个(轮数+1)元素开始
    依次执行，直至所有数据按要求完成排序
    如果有n个数据进行排序，总共需要比较n1轮
需求：在数组中存储，“7, 6, 5, 4, 3”五个数据，并使用选择进行排序

 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3};
        //选择排序
        //比较的轮数  因为比较的轮数比数组元素的个数少1，所以 arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            //因为每一轮比较，开始的元素随着轮数发生变化 所以j = i
            //为了提高比较的效率 所以i+1
            for (int j = i + 1; j < arr.length; j++) {
                int qian = arr[i];
                int hou = arr[j];
                if (qian > hou) {
                    int temp = qian;
                    arr[i] = hou;
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
