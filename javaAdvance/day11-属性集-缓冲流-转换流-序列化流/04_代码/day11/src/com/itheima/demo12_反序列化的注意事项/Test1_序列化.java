package com.itheima.demo12_反序列化的注意事项;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 15:21
 */
public class Test1_序列化 {
    public static void main(String[] args) throws Exception{
        // 需求:写一个Student对象到c.txt文件中
        // 1.创建序列化流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\ccc\\c.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 2.创建一个Pet对象
        Pet p = new Pet("旺财");
        // 2.创建一个Student对象
        Student stu = new Student("李四",19,p);

        // 3.序列化对象-->把对象写到c.txt文件中
        oos.writeObject(stu);// 已经把stu对象的所有信息以字节的形式存储到c.txt文件中

        // 4.释放资源
        oos.close();
    }
}
