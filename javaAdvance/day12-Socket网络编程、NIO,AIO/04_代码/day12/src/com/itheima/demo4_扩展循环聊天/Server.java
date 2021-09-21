package com.itheima.demo4_扩展循环聊天;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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

        // 循环聊天
        while (true) {

            //3.使用Socket对象调用getInputStream()方法获得字节输入流对象
            InputStream is = socket.getInputStream();

            //4.从连接通道中读数据(客户端写过来的)
            byte[] bys = new byte[1024];
            int len = is.read(bys);
            System.out.println("服务器接收到的数据:"+new String(bys,0,len));

            //5.使用Socket对象调用getOutPutStream()方法获得字节输出流对象
            OutputStream os = socket.getOutputStream();

            // 服务器输入要发送的字符串数据
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入给客户端发送的字符串数据:");
            String msg = sc.nextLine();

            //6.写出数据到连接通道中-->写了一个字节数组
            os.write(msg.getBytes());

            //7.释放资源
            //ss.close();
        }
    }
}
