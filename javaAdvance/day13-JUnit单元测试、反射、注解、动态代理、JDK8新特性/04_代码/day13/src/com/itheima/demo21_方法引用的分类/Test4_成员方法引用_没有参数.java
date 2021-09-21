package com.itheima.demo21_方法引用的分类;

import java.util.stream.Stream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 17:15
 */
public class Test4_成员方法引用_没有参数 {
    public static void main(String[] args) {
         /*
            成员方法引用_没有参数: 类名::方法名
         */
        // 获取一个流
        Stream<String> stream = Stream.of("迪丽热巴", "杨颖","马尔扎哈", "古力娜扎");

        // 需求: 把stream流中的元素转换为这些元素的字符串长度,打印输出
        //stream.map((String t)->{return t.length();}).forEach(System.out::println);

        // 发现: map方法传入的Lambda表达式大括号中就是调用String类的length方法,符合方法引用的场景
        stream.map(String::length).forEach(System.out::println);

    }

}
