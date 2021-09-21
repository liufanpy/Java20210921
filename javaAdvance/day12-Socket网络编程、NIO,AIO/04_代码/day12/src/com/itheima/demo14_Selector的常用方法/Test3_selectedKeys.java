package com.itheima.demo14_Selector的常用方法;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 17:52
 */
public class Test3_selectedKeys {
    public static void main(String[] args) throws Exception {
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
        System.out.println("已注册的通道:" + set.size());// 已注册的通道:3

        while (true) {
            System.out.println(1);
            selector.select();// 等待客户端连接

            // 7.处理客户端的请求
            // 7.1 获取已连接的所有通道集合
            Set<SelectionKey> channels = selector.selectedKeys();

            // 7.2 循环遍历已连接的所有通道
            Iterator<SelectionKey> it = channels.iterator();
            while (it.hasNext()){
                SelectionKey channel = it.next();

                // ServerSocketChannel会封装成SelectionKey对象
                // 如果要获取ServerSocketChannel需要使用SelectionKey对象调用channel方法
                // SelectableChannel是ServerSocketChannel的父类

                // 7.3 在循环中,拿遍历出来的连接通道处理客户端的请求
                ServerSocketChannel ssc = (ServerSocketChannel)channel.channel();

                // 7.4 处理客户端的请求
                // 7.4.1 接收客户端请求,建立连接
                SocketChannel sc = ssc.accept();
                // 7.4.2 读客户端传过来的数据
                ByteBuffer b = ByteBuffer.allocate(1024);
                int len = sc.read(b);
                System.out.println(new String(b.array(),0,len));

                // 7.4.3 释放资源
                sc.close();

                // 7.4.4 处理完了,就需要把当前已连接的服务器通道从集合中删除,下一次遍历的时候就没有之前的连接
                it.remove();
            }


            System.out.println(2);
        }

    }
}
