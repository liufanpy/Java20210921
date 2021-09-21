package com.itheima.demo11_SocketChannel和ServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 17:13
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 1.打开服务器通道
        ServerSocketChannel ssc = ServerSocketChannel.open();

        // 2.绑定端口号
        ssc.bind(new InetSocketAddress(6666));

        // 3.设置服务器通道非阻塞
        ssc.configureBlocking(false);

        while (true) {
            // 3.等待客户端连接,接收请求,建立连接
            SocketChannel sc = ssc.accept();

            if (sc == null) {
                System.out.println("没有人连接,玩会游戏...");
            } else {
                System.out.println("服务器:连接成功...");
                break;
            }
        }
    }
}
