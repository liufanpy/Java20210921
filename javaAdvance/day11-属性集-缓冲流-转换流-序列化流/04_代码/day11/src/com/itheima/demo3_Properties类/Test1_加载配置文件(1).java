package com.itheima.demo3_Properties类;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 9:46
 */
public class Test1_加载配置文件 {
    public static void main(String[] args) throws Exception {
        // 需求: 加载配置文件中的数据到Properties对象中,并取出所有数据
        // 1.创建Properties对象
        Properties pro = new Properties();

        // 2.调用load()方法加载配置文件中的键值对到Properties对象中
        pro.load(new FileInputStream("day11\\aaa\\a.txt"));// -->如果文件中有中文,就会乱码
        //pro.load(new FileReader("day11\\aaa\\a.txt"));// --->如果文件中有中文,不会乱码

        // 3.获取所有的键
        Set<String> keys = pro.stringPropertyNames();

        // 4.循环遍历所有的键
        for (String key : keys) {
            // 5.在循环中,根据键找值,打印输出
            String value = pro.getProperty(key);
            System.out.println(key + " = " + value);
        }
    }
}
