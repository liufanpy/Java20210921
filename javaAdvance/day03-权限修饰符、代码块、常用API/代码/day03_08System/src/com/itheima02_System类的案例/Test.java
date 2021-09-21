package com.itheima02_System类的案例;

/*
需求:在控制台输出100000次内容，计算这段代码执行了多少毫秒
步骤:
    获取开始时间
    干活
    获取结束时间
    结束时间-开始时间
 */
public class Test {

    public static void main(String[] args) {
        // 获取开始时间
        long startTime = System.currentTimeMillis();
        // 干活
        show();
        // 获取结束时间
        long endTime = System.currentTimeMillis();
        // 结束时间-开始时间
        long useTime = endTime - startTime;
        //展示使用时间
        System.out.println("总共使用了:" + useTime + "毫秒");
    }

    private static void show() {
        // 在控制台输出100000次内容
        System.out.println("开始运行");
        for (int i = 0; i < 100000; i++) {
            System.out.println("我是第" + i + "次执行");
        }
        System.out.println("结束运行");
    }
}
