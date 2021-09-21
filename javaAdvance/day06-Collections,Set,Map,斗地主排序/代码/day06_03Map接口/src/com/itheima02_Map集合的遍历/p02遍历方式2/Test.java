package com.itheima02_Map集合的遍历.p02遍历方式2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
java.util.Map.Entry 将键值对的对应关系封装成了对象。Map的内部接口定义，具体功能由Map子类负责具体实现。
Entry中的常用方法
    public K getKey()：获取Entry对象中的键。
    public V getValue()：获取Entry对象中的值。
步骤:
    获取Map集合中，所有的键值对(Entry)对象，以Set集合形式返回。方法提示:entrySet()。
    遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象。
    通过键值对(Entry)对象，获取Entry对象中的键与值。  方法提示:getkey() getValue()
需求：演示通过键找值的方式实现Map集合遍历

 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap();
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        //通过键值对的方式遍历
        // 获取Map集合中，所有的键值对(Entry)对象，以Set集合形式返回。方法提示:entrySet()。
        Set<Map.Entry<Integer, String>> entries = m.entrySet();
        // 遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象。
        for (Map.Entry<Integer, String> entry : entries) {
            // 通过键值对(Entry)对象，获取Entry对象中的键与值。  方法提示:getkey() getValue()
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key=" + key + "---" + "value=" + value);
        }
    }
}
