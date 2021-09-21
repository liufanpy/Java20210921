package com.itheima.demo3_Properties类;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 9:53
 */
public class Test2_修改配置文件 {
    public static void main(String[] args) throws Exception {
        // 需求:将配置文件中k3键对应的值改为value3
        // 1.创建Properties对象
        Properties pro = new Properties();

        // 2.调用load方法加载配置文件
        pro.load(new FileInputStream("day11\\aaa\\b.properties"));

        // 3.获取所有的键
        Set<String> keys = pro.stringPropertyNames();

        // 4.循环遍历所有的键
        for (String key : keys) {
            // 5.在循环中,判断遍历出来的键是否是k3,如果是,就修改对应的值
            if ("k3".equals(key)) {
                pro.setProperty(key, "value3");
            }
        }

        // 6.调用store()方法把Properties对象中所有的键值对写回到文件中-->覆盖之前文件的所有数据
        //pro.store(new FileOutputStream("day11\\aaa\\b.properties"),"szitheima113");
        pro.store(new FileWriter("day11\\aaa\\b.properties"),"szitheima113");
    }
}
