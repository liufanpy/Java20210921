package com.itheima04_二分查找;

import java.util.Scanner;

/*
前提：数据有序
原理
    使用循环定义最小和最大索引位置，并判断最小索引小于等于最大索引时，执行以下操作
    根据最小索引和最大索引获取中间索引
    根据中间索引获取值，和要查找的元素比对，如果相同就返回索引
        如果不相同，就比较中间元素和要查找的元素的值
        如果中间元素大于查找元素，说明查找位置在中间元素左侧，修改最大索引为中间索引1
        如果中间元素小于查找元素，说明查找位置在中间元素右侧，修改最小索引为中间索引+1
    从第1步开始重复执行，直到找到内容，或判断条件为false
需求：将“1, 4, 16, 22, 25, 44, 55, 67, 88, 100”存入数组，并查找制定数值的位置

 */
public class Test {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {1, 4, 16, 22, 25, 44, 55, 67, 88, 100};
        //键盘录入要查找的数据
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //定义记录查找到的索引位置的变量
        int index = -1;
        // 使用循环定义最小和最大索引位置，并判断最小索引小于等于最大索引时，执行以下操作
        for (int start = 0, end = arr.length - 1; start <= end; ) {
            // 根据最小索引和最大索引获取中间索引
            int mid = (start + end) / 2;
            // 根据中间索引获取值，和要查找的元素比对，如果相同就返回索引
            if (num == arr[mid]) {
                index = mid;
                break;
            } else if (num > arr[mid]) {
                // 如果中间元素小于查找元素，说明查找位置在中间元素右侧，修改最小索引为中间索引+1
                start = mid + 1;
            } else {//num < arr[mid]
                // 如果中间元素大于查找元素，说明查找位置在中间元素左侧，修改最大索引为中间索引1
                end = mid - 1;
            }
        }
        if (index == -1) {
            System.out.println("元素中不存在该数值");
        } else {
            System.out.println("该元素在数组中的位置是:" + index);
        }
    }
}
