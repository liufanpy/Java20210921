package com.itheima.demo8_文件下载;

//import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 14:53
 */
@WebServlet("/ServletDemo12")
public class ServletDemo12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始下载文件...");
        //1.处理请求和响应乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //2.获得请求参数(文件名)
        String fileName = request.getParameter("fileName");
        System.out.println("fileName:"+fileName);

        //3.通过ServletContext对象获得该文件对应的字节输入流
        InputStream is = getServletContext().getResourceAsStream("download/" + fileName);

        //4.设置Content-Type响应头,告诉浏览器要下载的文件的MIME类型
        String mimeType = getServletContext().getMimeType(fileName);
        response.setHeader("Content-Type",mimeType);

        // 判断发送请求的浏览器,然后根据浏览器的类型对文件名进行编码
        String browserType = request.getHeader("User-Agent");
        if (browserType.contains("Firefox")){
            // 进行Base64编码
//            fileName = base64EncodeFileName(fileName);
            System.out.println(fileName);
        }else{
            // 进行url编码(utf8)
            fileName = URLEncoder.encode(fileName,"utf-8");
            System.out.println(fileName);

        }

        //5.设置Content-Disposition响应头,告诉浏览器去下载
        response.setHeader("Content-Disposition","attachment;filename="+fileName);// 编码后的文件名


        //6.通过响应对象获得字节输出流对象
        ServletOutputStream os = response.getOutputStream();

        //7.定义一个byte字节数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];
        //8.定义一个int变量,用来存储读取到的字节个数
        int len;
        //9.循环读取
        while ((len=is.read(bys)) != -1) {
            //10.在循环中,写数据
            os.write(bys,0,len);
        }
        //11.释放资源
        os.close();
        is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /*public static String base64EncodeFileName(String fileName) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            return "=?UTF-8?B?"
                    + new String(base64Encoder.encode(fileName
                    .getBytes("UTF-8"))) + "?=";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }*/
}
