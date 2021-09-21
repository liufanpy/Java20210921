package com.itheima.demo8_BS服务器程序;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 12:19
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 思路:
        //1.创建ServerSocket对象,指定服务器的端口号8888
        ServerSocket ss = new ServerSocket(8888);

        // 循环接收请求--->请求html页面,还会请求该页面上的图片
        while (true) {
            //2.调用accept()方法接收请求,建立连接,返回Socket对象
            Socket socket = ss.accept();

            // 浏览器工作原理是遇到图片会开启一个线程进行单独的访问,因此在服务器端加入线程技术。
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //3.通过Socket获得字节输入流对象,关联连接通道
                        InputStream is = socket.getInputStream();

                        //4.使用字节输入流对象读取连接通道中的数据
                        //byte[] bys = new byte[8192];
                        //int len = is.read(bys);
                        //System.out.println(new String(bys,0,len));
                        // 把is字节输入流转换为字符输入流
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String line = br.readLine();
                        System.out.println("line:" + line);

                        //5.筛选数据,得到要请求的页面的路径
                        String path = line.split(" ")[1].substring(1);
                        System.out.println("path:" + path);//   day12/web/index.html

                        //6.创建字节输入流对象,关联页面路径
                        FileInputStream fis = new FileInputStream(path);

                        //7.通过Socket对象获得字节输出流对象,关联连接通道
                        OutputStream os = socket.getOutputStream();

                        //8.定义一个byte数组,用来存储读取到的字节数据
                        byte[] bys = new byte[8192];

                        //9.定义一个int变量,用来存储读取到的字节个数
                        int len;

                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        os.write("\r\n".getBytes());

                        //10.循环读取字节数据
                        while ((len = fis.read(bys)) != -1) {
                            //11.在循环中,写出字节数据
                            os.write(bys, 0, len);
                        }
                        //12.释放资源
                        os.close();
                        fis.close();
                        //ss.close();
                    } catch (Exception e) {

                    }
                }
            }).start();

        }
    }
}
