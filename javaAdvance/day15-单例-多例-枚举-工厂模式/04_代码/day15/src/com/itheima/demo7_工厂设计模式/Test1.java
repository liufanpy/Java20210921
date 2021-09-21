package com.itheima.demo7_工厂设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 10:17
 */
public class Test1 {
    public static void main(String[] args) {
       /* // 创建Falali汽车对象
        Falali fll = new Falali();
        fll.run();

        // 创建Benchi汽车对象
        Benchi bc = new Benchi();
        bc.run();*/

        // 创建Falali汽车对象
        Car car1 = CarFactory.createCar("Falali");
        car1.run();

        // 创建Benchi汽车对象
        Car car2 = CarFactory.createCar("Benchi");
        car2.run();


    }
}
