package com.itheima.demo9_ObjectOutputStream类;

import com.itheima.bean.Person;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 14:55
 */
public class Test1_写对象 {
    public static void main(String[] args) throws Exception{
        // 需求:写一个Person对象到a.txt文件中
        // 1.创建序列化流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\ccc\\a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 2.创建一个Person对象
        Person p = new Person("张三",18);

        // 3.序列化对象-->把对象写到a.txt文件中
        oos.writeObject(p);// 已经把p对象的所有信息以字节的形式存储到a.txt文件中

        // 4.释放资源
        oos.close();
    }
}
