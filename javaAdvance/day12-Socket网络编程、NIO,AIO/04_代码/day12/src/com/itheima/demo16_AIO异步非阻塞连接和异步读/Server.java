package com.itheima.demo16_AIO异步非阻塞连接和异步读;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
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
            public void completed(AsynchronousSocketChannel asc, Object attachment) {
                System.out.println(3);

                // 创建ByteBuffer字节缓冲数组
                ByteBuffer b = ByteBuffer.allocate(1024);

                // 异步读
                asc.read(b, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer len, Object attachment) {
                        System.out.println(5);
                        System.out.println("接收到的数据:"+ new String(b.array(),0,len));
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println(6);
                    }
                });
                System.out.println(7);


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
