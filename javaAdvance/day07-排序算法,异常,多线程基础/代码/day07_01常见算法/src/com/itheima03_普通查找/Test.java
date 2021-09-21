package com.itheima03_普通查找;

import java.util.Scanner;

/*
原理
    遍历数组，获取每一个元素，
    判断当前遍历的元素是否和要查找的元素相同，
    如果相同就返回该元素的索引，结束循环
    循环结束视为没有找到，就返回一个负数作为标识(一般是1)
需求：定义数组存储“7, 6, 5, 4, 3”五个数据，使用普通查找找到7的位置

 */
public class Test {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {7, 6, 5, 4, 3};
        //键盘录入一个数据
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //定义一个索引，记录找到的元素的位置
        int index = -1;
        //遍历数组，查找元素位置
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("元素中不存在该数值");
        } else {
            System.out.println("该元素在数组中的位置是:" + index);
        }
    }
}
