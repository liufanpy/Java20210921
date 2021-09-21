package com.itheima06_Map集合练习;

import java.util.HashMap;
import java.util.Scanner;

/*
需求:输入一个字符串中每个字符出现次数
分析:
    获取一个字符串对象
    创建一个Map集合，键代表字符，值代表次数。
    遍历字符串得到每个字符。
    判断Map中是否有该键(public boolean containKey(Object key):判断该集合中是否有此键)
    如果没有，第一次出现，存储次数为1；如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
    打印最终结果
实现
    按照分析步骤实现


 */
public class Test {
    public static void main(String[] args) {
        // 获取一个字符串对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一段字符串内容");
        String line = sc.nextLine();
        // 创建一个Map集合，键代表字符，值代表次数。
        HashMap<Character, Integer> hm = new HashMap<>();
        // 遍历字符串得到每个字符。
        for (int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);
            // 判断Map中是否有该键(public boolean containKey(Object key):判断该集合中是否有此键)
            if (!hm.containsKey(key)) {
                // 如果没有，第一次出现，存储次数为1；
                hm.put(key, 1);
            } else {
                // 如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
                Integer count = hm.get(key);
                count++;
                hm.put(key, count);
            }
        }
        // 打印最终结果
        System.out.println(hm);
    }
}
