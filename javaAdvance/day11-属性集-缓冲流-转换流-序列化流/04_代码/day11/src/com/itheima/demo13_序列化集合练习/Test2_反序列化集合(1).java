package com.itheima.demo13_序列化集合练习;

import com.itheima.bean.Person;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 15:54
 */
public class Test2_反序列化集合 {
    public static void main(String[] args) throws Exception {
        // 1.创建反序列化流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\ccc\\list.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 2.重构对象
        ArrayList<Person> list = (ArrayList<Person>) ois.readObject();

        // 3.释放资源
        ois.close();

        // 4.循环遍历重构的集合,打印输出
        for (Person p : list) {
            System.out.println(p);
        }

    }
}
