package com.itheima.demo7_工厂设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 10:20
 */
public class CarFactory {

    /**
     * 用来创建汽车对象的方法
     * @param carType
     * @return 汽车对象
     */
    public static Car createCar(String carType){
        if ("Falali".equalsIgnoreCase(carType)){
            // 返回Falali对象
            return new Falali();

        }else if ("Benchi".equalsIgnoreCase(carType)){
            // 返回Benchi对象
            return new Benchi();
        }else{
            return null;
        }
    }

}
