package com.itheima02_Map集合的遍历.p01遍历方式1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
通过元素中的键，获取键所对应的值
步骤
    获取Map中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键。方法提示:keyset()
    遍历键的Set集合，得到每一个键。
    根据键，获取键所对应的值。方法提示:get(K key)
需求：演示通过键找值的方式实现Map集合遍历

 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap();
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        //通过键，找值的方式遍历
        // 获取Map中所有的键
        Set<Integer> set = m.keySet();
        // 遍历键的Set集合，得到每一个键。
        for (Integer key : set) {
            String value = m.get(key);
            System.out.println("key=" + key + "---" + "value=" + value);
        }
    }
}
