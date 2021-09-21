package com.itheima.demo6_文件上传案例版本2;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 11:22
 */
public class Server {
    public static void main(String[] args) throws Exception{
        //服务器:
        //1.创建ServerSocket对象,指定服务器的端口号 7777
        ServerSocket ss = new ServerSocket(7777);

        //2.调用accept方法等待接收客户端请求,建立连接,得到Socket对象
        Socket socket = ss.accept();

        //3.通过Socket对象获得字节输入流对象,关联连接通道
        InputStream is = socket.getInputStream();

        //4.创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day12\\bbb\\hbCopy4.jpg");

        //5.定义一个byte数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];

        //6.定义一个int变量,用来存储读取到的字节个数
        int len;

        //7.循环读取连接通道中的数据
        System.out.println("服务器依然还在等待连接通道的数据来读取...");
        while ((len = is.read(bys)) != -1) {// 卡
            //8.在循环中,写出数据到连接通道
            fos.write(bys, 0,len);
        }
        System.out.println("服务器读完了连接通道中的数据...");

        // 原因: 服务器一直在读连接通道中的数据,不知道客户端不会再往通道中写数据了
        // 解决办法: 客户端告诉服务器,不再往通道中写数据了,那么服务器才会结束读取通道中的数据
        // Socket类的方法: socket.shutdownOutput();

        //9.通过Socket对象获得字节输出流对象,关联连接通道
        OutputStream os = socket.getOutputStream();

        //10.回写数据给客户端--->写一个一个字节数组
        os.write("文件上传成功!".getBytes());

        //11.释放资源
        fos.close();
        is.close();
        ss.close();// 一般不关闭
    }
}
