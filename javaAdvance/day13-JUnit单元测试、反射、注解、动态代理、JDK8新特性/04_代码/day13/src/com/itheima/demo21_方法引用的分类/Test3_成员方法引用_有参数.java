package com.itheima.demo21_方法引用的分类;

import java.util.stream.Stream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 17:15
 */
public class Test3_成员方法引用_有参数 {
    public static void main(String[] args) {
        /*
            成员方法引用_有参数: 对象名::方法名
         */
        // 获取一个流
        Stream<String> stream = Stream.of("110", "120", "114");

        // 需求: 把stream流中的元素打印输出
        /*stream.forEach((String t)->{
            System.out.println(t);
        });*/

        // 发现: forEach方法传入的Lambda表达式大括号中其实就是调用System.out对象的println方法,符合
        stream.forEach(System.out::println);
    }

}
