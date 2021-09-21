package com.itheima.demo14_Selector的常用方法;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 17:18
 */
public class Client2 {
    public static void main(String[] args) throws Exception{
        // 1.打开客户端通道
        SocketChannel sc = SocketChannel.open();

        // 2.调用connect()连接方法
        sc.connect(new InetSocketAddress("127.0.0.1",9999));

        // 3.写数据
        byte[] bytes = "服务器你好,今晚约吗?".getBytes();
        //ByteBuffer b = ByteBuffer.wrap(bytes);
        ByteBuffer b = ByteBuffer.allocate(1024);
        b.put(bytes);
        b.flip();// position:0,limit:position

        sc.write(b);

        // 4.释放资源
        sc.close();

    }
}
