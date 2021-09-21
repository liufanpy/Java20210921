package com.itheima.demo14_Selector的常用方法;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 17:52
 */
public class Test2_select {
    public static void main(String[] args) throws Exception{
        // 1.打开服务器通道
        ServerSocketChannel ssc1 = ServerSocketChannel.open();
        ServerSocketChannel ssc2 = ServerSocketChannel.open();
        ServerSocketChannel ssc3 = ServerSocketChannel.open();

        // 2.绑定端口号
        ssc1.bind(new InetSocketAddress(7777));
        ssc2.bind(new InetSocketAddress(8888));
        ssc3.bind(new InetSocketAddress(9999));

        // 3.设置非阻塞
        ssc1.configureBlocking(false);
        ssc2.configureBlocking(false);
        ssc3.configureBlocking(false);

        // 4.获取选择器
        Selector selector = Selector.open();

        // 5.把Channel注册到选择器上
        ssc1.register(selector, SelectionKey.OP_ACCEPT);
        ssc2.register(selector, SelectionKey.OP_ACCEPT);
        ssc3.register(selector, SelectionKey.OP_ACCEPT);

        // 6.获取所有已注册的连接通道
        Set<SelectionKey> set = selector.keys();
        System.out.println("已注册的通道:"+set.size());// 已注册的通道:3

        while (true) {
            System.out.println(1);
            selector.select();// 等待客户端连接
            System.out.println(2);
        }

    }
}
