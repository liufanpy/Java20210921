package com.itheima.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 10:04
 */
public class Utils {

    public static String driverClass;
    public static String jdbcUrl;
    public static String username;
    public static String password;

    static {
        try {
            // 1.创建Properties对象
            Properties pro = new Properties();

            // 2.调用load方法,加载配置文件---一定要在src路径下
            //FileInputStream is = new FileInputStream("day13\\src\\db.properties");
            // 返回的流默认就已经到达了src路径
            InputStream is = Utils.class.getClassLoader().getResourceAsStream("db.properties");
            pro.load(is);

            // 3.取出数据
            driverClass = pro.getProperty("driverClass");
            jdbcUrl = pro.getProperty("jdbcUrl");
            username = pro.getProperty("username");
            password = pro.getProperty("password");

        } catch (IOException e) {

        }
    }
}
