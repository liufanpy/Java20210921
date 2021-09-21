package com.itheima.demo13_使用注解;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 14:41
 */
@MyAnnotation01
@MyAnnotation02(name="张三",age=18,arr={3.14,4.2,5.6})
public class Test {

    @MyAnnotation01
    @MyAnnotation02(name="张三",age=18,arr={3.14,4.2,5.6})
    int num;

    @MyAnnotation01
    @MyAnnotation02(name="张三",age=18,arr={3.14,4.2,5.6})
    public static void main(String[] args) {
        // 不带属性的注解: @注解名  或者@注解名()
        // 带属性的注解:  @注解名(属性名=属性值,属性名=属性值,...)
        // 注意:
        //   1.使用带属性的注解必须给注解中所有的属性赋值
        //   2.某个位置使用同一个注解只能使用一次

        @MyAnnotation01
        @MyAnnotation02(name="张三",age=18,arr={3.14,4.2,5.6})
        int num;
    }
}
