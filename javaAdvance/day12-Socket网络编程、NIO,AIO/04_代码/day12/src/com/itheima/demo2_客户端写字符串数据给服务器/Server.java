package com.itheima.demo2_客户端写字符串数据给服务器;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 10:47
 */
public class Server {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象,指定服务器的端口号 6666
        ServerSocket ss = new ServerSocket(6666);

        //2.调用accept()方法,等待接收客户端请求,建立连接,返回Socket对象
        Socket socket = ss.accept();

        //3.使用Socket对象调用getInputStream()方法获得字节输入流对象
        InputStream is = socket.getInputStream();

        //4.从连接通道中读数据(客户端写过来的)
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println("服务器接收到的数据:"+new String(bys,0,len));

        //5.释放资源
        ss.close();
    }
}
