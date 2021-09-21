package com.itheima.demo4_扩展循环聊天;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 10:47
 */
public class Client {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象,指定要连接的服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1",6666);

        // 循环聊天
        while (true) {
            //2.使用Socket对象调用getOutputStream()方法获得字节输出流对象
            OutputStream os = socket.getOutputStream();

            // 客户端输入要发送的字符串数据
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入给服务器发送的字符串数据:");
            String msg = sc.nextLine();

            //3.写出数据到连接通道中-->写了一个字节数组
            os.write(msg.getBytes());

            //4.使用Socket对象调用getInputStream()方法获得字节输入流对象
            InputStream is = socket.getInputStream();

            //5.从连接通道中读数据(服务器写过来的)
            byte[] bys = new byte[1024];
            int len = is.read(bys);
            System.out.println("客户端接收到的数据:"+new String(bys,0,len));

            //6.释放资源
            //socket.close();
        }
    }
}
