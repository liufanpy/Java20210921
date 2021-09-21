package com.itheima.demo11_序列化的注意事项;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 15:15
 */
public class Test2_反序列化 {
    public static void main(String[] args) throws Exception{
        // 1.创建反序列化流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\ccc\\b.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 2.重构对象
        Student stu = (Student) ois.readObject();

        // 3.释放资源
        ois.close();

        // 4.打印对象
        System.out.println(stu);// Student{name='李四', age=19, pet=Pet{name='旺财'}}

    }
}
