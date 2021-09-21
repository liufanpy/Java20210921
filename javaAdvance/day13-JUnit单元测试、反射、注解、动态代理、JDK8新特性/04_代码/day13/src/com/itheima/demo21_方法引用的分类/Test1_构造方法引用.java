package com.itheima.demo21_方法引用的分类;

import java.util.stream.Stream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 17:15
 */
public class Test1_构造方法引用 {

    public static void main(String[] args) {
        /*
            构造方法引用:   类名::new
         */
        // 获取一个流
        Stream<String> stream = Stream.of("迪丽热巴", "马尔扎哈", "古力娜扎");

        // 需求: 把stream流中的元素转换为Person对象,打印输出
        //stream.map((String t)->{return new Person(t);}).forEach((Person p)->{System.out.println(p);});

        // 发现: map方法传入的Lambda表达式大括号中就是调用Person类的构造方法,符合方法引用的场景
        stream.map(Person::new).forEach((Person p)->{System.out.println(p);});


    }
}
