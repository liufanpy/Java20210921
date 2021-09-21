package com.itheima03_Stream流常用功能;

import java.util.stream.Stream;

/*
概述
    终结方法：返回值类型不再是Stream接口的方法，支持链式调用。
    非终结方法(函数拼接方法)：返回值类型仍然是Stream接口的方法，不支持链式调用。

方法介绍：
    方法名 	作用		分类	    链式调用	    详解
    count	统计个数	    终结		    否	    long count();返回流中的元素个数。
    forEach	逐一处理	    终结		    否	    void forEach(Consumer<? super T> action);对此流的每个元素进行操作
    filter	过滤		非终结		是	    Stream<T> filter(Predicate<? super T> predicate);返回经过筛选，满足的条件的元素组成的流
    limit	取前n个	    非终结		是	    Stream<T> limit(long maxSize);返回由此流(包含)第maxSize个之前的元素组成的流
    skip	跳过前n个    非终结		是	    Stream<T> skip(long n);返回由此流(不含)第n个之后元素组成的流
    map		映射		非终结		是	    <R> Stream<R> map(Function<? super T, ? extends R> mapper);返回流中旧元素经指定规则转换后的心元素组成的流
    concat	组合		非终结		是	    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b);返回将两个流中的元素合并到一其组成的流
需求:演示 Stream流常用功能
*/
public class Test {
    public static void main(String[] args) {
        // long count();返回流中的元素个数。
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        System.out.println(stream1.count());
        System.out.println("--------");
        // void forEach(Consumer<? super T> action)
        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        stream2.forEach((Integer num) -> {
            System.out.println(num);
        });
        System.out.println("--------");
        // Stream<T> filter(Predicate<? super T> predicate)
        Stream<Integer> stream3 = Stream.of(1, 2, 3);
        Stream<Integer> stream31 = stream3.filter((Integer i) -> {
            return i == 2;
        });
        stream31.forEach((Integer num) -> {
            System.out.println(num);
        });
        System.out.println("--------");
        // Stream<T> limit(long maxSize)
        Stream<Integer> stream4 = Stream.of(1, 2, 3);
        Stream<Integer> stream41 = stream4.limit(2);
        stream41.forEach((Integer num) -> {
            System.out.println(num);
        });
        System.out.println("--------");
        // Stream<T> skip(long n)
        Stream<Integer> stream5 = Stream.of(1, 2, 3);
        Stream<Integer> stream51 = stream5.skip(1);
        stream51.forEach((Integer num) -> {
            System.out.println(num);
        });
        System.out.println("--------");
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        Stream<Integer> stream6 = Stream.of(1, 2, 3);
        Stream<Integer> stream61 =stream6.map((Integer i)->{ return i*10;});
        stream61.forEach((Integer num) -> {
            System.out.println(num);
        });
        System.out.println("--------");
        // static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
        Stream<Integer> stream71 = Stream.of(1, 2, 3);
        Stream<Integer> stream72 = Stream.of(4, 5, 6);
        Stream<Integer> stream7 =Stream.concat(stream71,stream72);
        stream7.forEach((Integer num) -> {
            System.out.println(num);
        });
    }

}
