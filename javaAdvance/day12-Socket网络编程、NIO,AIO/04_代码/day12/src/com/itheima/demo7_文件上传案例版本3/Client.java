package com.itheima.demo7_文件上传案例版本3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 11:22
 */
public class Client {
    public static void main(String[] args) throws Exception{
        //客户端:
        //1.创建Socket对象,指定要连接的服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1",7777);

        //2.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day12\\aaa\\hb.jpg");

        //3.通过Socket获得字节输出流对象,关联连接通道
        OutputStream os = socket.getOutputStream();

        //4.定义一个byte数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];

        //5.定义一个int变量,用来存储读取到的字节个数
        int len;

        //6.循环读取数据
        while ((len = fis.read(bys)) != -1) {
            //7.在循环中,写出数据到连接通道
            os.write(bys,0,len);// 写到连接通道中的数据一定是hb.jpg的字节数据
        }

        // 告诉服务器,不会再往连接通道中写数据了
        socket.shutdownOutput();

        //8.通过Socket对象获得字节输入流对象,关联连接通道
        InputStream is = socket.getInputStream();

        System.out.println("客户端已经上传完毕,等待接收服务器回写的数据...");
        //9.读服务器回写的数据
        int lens = is.read(bys);// 卡
        System.out.println("服务器回写的数据:"+new String(bys,0,lens));

        //10.释放资源
        os.close();
        fis.close();


    }
}
