package com.itheima.demo1_InetAddress类;

import java.net.InetAddress;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 10:06
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //- static InetAddress getLocalHost()   获得本地主机IP地址对象
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println("ip1:" + ip1);// ESKTOP-U8Q5F96/10.254.4.56

        //- static InetAddress getByName(String host) 根据IP地址字符串或主机名获得对应的IP地址对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println("ip2:" + ip2);// www.baidu.com/14.215.177.38

        //- String getHostName();获得主机名
        System.out.println("主机名:"+ip1.getHostName());// ESKTOP-U8Q5F96
        System.out.println("主机名:"+ip2.getHostName());// www.baidu.com

        //- String getHostAddress();获得IP地址字符串
        System.out.println("ip地址字符串:"+ip1.getHostAddress());// 10.254.4.56
        System.out.println("ip地址字符串:"+ip2.getHostAddress());// 14.215.177.38
    }
}
