package com.itheima05_收集Stream流结果;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
概述：对流操作完成之后，如果需要将其结果进行收集,可以根据需要收集到集合和数组中。
方法介绍
    方法名 	作用	            分类	    链式调用	详解
    collect  收集结果到集合中	    终结	 否		R collect(Collector<T,A, R> coll)：转换为指定的集合，R代表最终转为的集合的具体类型
    toArray	 收集结果到数组中	    终结	 否		Object[] toArray()：转换为Object数组
java.util.stream.Collectors类提供一些方法，可以作为Collector接口的实例。
        public static <T> Collector<T, ?, List<T>> toList()：转换为List集合。
        public static <T> Collector<T, ?, Set<T>> toSet()：转换为Set集合。
需求:演示将流中的数据转换到集合与数组中

*/
public class Test {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        List<Integer> collect1 = stream1.collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("--------");
        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        Set<Integer> collect2 = stream2.collect(Collectors.toSet());
        System.out.println(collect2);
        System.out.println("--------");
        Stream<Integer> stream3 = Stream.of(1, 2, 3);
        Object[] objects = stream3.toArray();
        System.out.println(Arrays.toString(objects));
    }

}
