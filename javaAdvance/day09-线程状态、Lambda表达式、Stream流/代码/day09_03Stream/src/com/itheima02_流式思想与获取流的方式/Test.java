package com.itheima02_流式思想与获取流的方式;

import java.util.*;
import java.util.stream.Stream;

/*
概述
    Stream流，类似于车间的流水线，每次操作流，都可以将结果发送给下一个操作。
    Stream流基于一定的函数模型思想设计，目的是为了拥有更好的性能和便利性。
    Stream流包含了过滤、映射、跳过、计数等模型，调用指定方法，会使流模型转为另一个流模型。
    Stream中将操作模型分为了延迟性与终结性两种，以便更好的执行流策略。
Stream特点
    Stream流是一次性的,不能重复使用，当执行流的某个方法，这个流将将失效，并将结果存储到新流中。
    Stream流不会存储数据
    Stream流不会修改数据源
    Stream流搭建的函数模型，只有终结方法存在,前面的延迟性方法才会执行。
获取方式
    java.util.Collection接口中加入的default方法用来获取流，所以其所有实现类均可获取流。
        Stream  stream()
    java.util.Map接口不是Collection的子接口，且K-V数据结构不符合流元素的单一特征，需分别根据其键和值的集合获取流对象。
        获取键集合:Set keySet
        获取值集合:Collection  values
    数组对象没有方法，所以Stream接口中提供了静态方法of获取数组对应的流。
        Stream  of(T...t)

需求：分别获取Collection、Map及数组的Stream流对象

*/
public class Test {
    public static void main(String[] args) {
        //获取单列集合的流对象
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Stream<String> stream1 = list.stream();
        //获取双列集合的流对象
        Map<String, String> m = new HashMap<>();
        m.put("1", "a");
        m.put("2", "b");
        m.put("3", "c");
        //键集的流对象
        Set<String> keys = m.keySet();
        Stream<String> stream2 = keys.stream();
        //值集的流对象
        Collection<String> values = m.values();
        Stream<String> stream3 = values.stream();
        //获取数组的流对象
        int[] arr = {1, 2, 3};
        Stream<int[]> stream4 = Stream.of(arr);//of(T t)
        Stream<Integer> stream5 = Stream.of(1, 2, 3);//of(T...t)
    }
}
