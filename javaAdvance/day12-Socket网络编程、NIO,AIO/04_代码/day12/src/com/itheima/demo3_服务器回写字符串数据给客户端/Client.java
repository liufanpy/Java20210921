package com.itheima.demo3_服务器回写字符串数据给客户端;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 10:47
 */
public class Client {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象,指定要连接的服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1",6666);

        //2.使用Socket对象调用getOutputStream()方法获得字节输出流对象
        OutputStream os = socket.getOutputStream();

        //3.写出数据到连接通道中-->写了一个字节数组
        os.write("服务器你好,今晚约吗?".getBytes());

        //4.使用Socket对象调用getInputStream()方法获得字节输入流对象
        InputStream is = socket.getInputStream();

        //5.从连接通道中读数据(服务器写过来的)
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println("客户端接收到的数据:"+new String(bys,0,len));

        //6.释放资源
        socket.close();
    }
}
