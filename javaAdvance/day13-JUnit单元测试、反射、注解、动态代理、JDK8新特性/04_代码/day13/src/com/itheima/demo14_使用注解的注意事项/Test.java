package com.itheima.demo14_使用注解的注意事项;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 14:49
 */
public class Test {
    //  - 一旦注解有属性了,使用注解的时候,属性必须有值
    @MyAnnotation01(name = "zs", age = 18)
    public void method1() {
    }

    //  - 若属性类型是一维数组的时候,当数组的值只有一个的时候可以省略{}
    //@MyAnnotation02(names={"itheima"},age=15) // 标准
    @MyAnnotation02(names="itheima",age=15) // 省略
    public void method2(){

    }

    //  - 如果注解中只有一个属性,并且属性名为value,那么使用注解给注解属性赋值的时候,注解属性名value可以省略
    //@MyAnnotation03(value="itcast")// 标准
    @MyAnnotation03("itcast")// 标准
    public void method3(){

    }

    //  - 若属性类型是一维数组的时候,当数组的值只有一个的时候可以省略{}
    //  - 如果注解中只有一个属性,并且属性名为value,那么使用注解给注解属性赋值的时候,注解属性名value可以省略
    //@MyAnnotation033(value={"java"}) // 标准
    //@MyAnnotation033(value="java") // 省略
    @MyAnnotation033("java") // 省略
    public void method33(){

    }

    //  - 注解属性可以有默认值  格式:属性类型 属性名() default 默认值;
    //@MyAnnotation04     // 可以不赋值,使用默认值
    @MyAnnotation04(name="小三",age=19)   // 可以赋值,其实就是修改值
    public void method04(){

    }

}
