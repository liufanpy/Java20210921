package com.itheima.demo21_方法引用的分类;

import java.util.stream.Stream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 17:15
 */
public class Test2_静态方法引用 {
    public static void main(String[] args) {
        /*
            静态方法引用: 类名::方法名
         */
        // 获取一个流
        Stream<String> stream = Stream.of("110", "120", "114");

        // 需求: 把stream流中的元素转换为Integer对象,打印输出
        // stream.map((String t)->{return Integer.parseInt(t);}).forEach((Integer i)->{System.out.println(i+1);});

        // 发现: map方法传入的Lambda表达式大括号中就是调用Interger类的parseInt静态方法,符合方法引用的场景
        stream.map(Integer::parseInt).forEach((Integer i)->{System.out.println(i+1);});

    }
}
