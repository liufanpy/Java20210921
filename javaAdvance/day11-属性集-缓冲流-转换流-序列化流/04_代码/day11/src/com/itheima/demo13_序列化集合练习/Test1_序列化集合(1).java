package com.itheima.demo13_序列化集合练习;

import com.itheima.bean.Person;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 15:51
 */
public class Test1_序列化集合 {
    public static void main(String[] args) throws Exception{
        // 1.创建序列化流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\ccc\\list.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 2.创建ArrayList集合,限制集合元素的类型为Person类型
        ArrayList<Person> list = new ArrayList<>();

        // 3.往集合中存储多个Person对象
        list.add(new Person("张三",18));
        list.add(new Person("李四",28));
        list.add(new Person("王五",38));
        list.add(new Person("赵六",48));

        // 4.序列化集合
        oos.writeObject(list);// 集合中的元素都会序列化

        // 5.释放资源
        oos.close();

    }
}
