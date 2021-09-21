package com.itheima.demo10_ObjectInputStream类;

import com.itheima.bean.Person;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 15:15
 */
public class Test1_读对象 {
    public static void main(String[] args) throws Exception{
        // 1.创建反序列化流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\ccc\\a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 2.重构对象
        Person p = (Person) ois.readObject();

        // 3.释放资源
        ois.close();

        // 4.打印对象
        System.out.println(p.toString());//Person{name='张三', age=18}
        System.out.println(p);//Person{name='张三', age=18}

    }
}
