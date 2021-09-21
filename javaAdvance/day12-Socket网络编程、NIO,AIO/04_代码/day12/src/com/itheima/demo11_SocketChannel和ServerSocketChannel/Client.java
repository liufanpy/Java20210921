package com.itheima.demo11_SocketChannel和ServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 17:09
 */
public class Client {
    public static void main(String[] args) throws Exception{
        // 1.打开客户端通道
        SocketChannel sc = SocketChannel.open();

        // 2.调用connect()连接方法
        sc.connect(new InetSocketAddress("127.0.0.1",6666));

        System.out.println("客户端: 连接成功..");
    }
}
