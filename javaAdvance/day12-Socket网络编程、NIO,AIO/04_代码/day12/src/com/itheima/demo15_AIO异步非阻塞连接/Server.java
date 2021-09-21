package com.itheima.demo15_AIO异步非阻塞连接;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 18:20
 */
public class Server {
    public static void main(String[] args) throws Exception{
        // 1.打开通道
        AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open();

        // 2.绑定端口号
        assc.bind(new InetSocketAddress(7777));

        // 3.接收请求,建立连接 --->异步
        System.out.println(1);
        assc.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                System.out.println(3);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println(4);
            }
        });

        System.out.println(2);

        // 为了保证程序不结束
        while (true){

        }
    }
}
