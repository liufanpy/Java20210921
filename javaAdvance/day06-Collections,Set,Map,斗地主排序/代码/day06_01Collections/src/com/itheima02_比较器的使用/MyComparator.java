package com.itheima02_比较器的使用;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        System.out.println("o1：" + o1+"---"+"o2：" + o2);
        //o2表示前面的那个数据
        //o1表示后面的那个数据

        //返回值
            // 返回的是0  不操作
            // 如果是负数  o1放到前面
            // 如果是正数  o2放到前面

        int num = o1 - o2;//升序
        // int num = o2 - o1;//降序
        return num;
    }
}
