package com.itheima.demo22_Base64编码和解码;

import java.util.Base64;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 17:41
 */
public class Test1_基本型 {
    public static void main(String[] args) {

        // 1.获取编码器
        Base64.Encoder encoder = Base64.getEncoder();

        String str = "name=中国?password=123456";

        // 2.对str进行编码
        String s = encoder.encodeToString(str.getBytes());
        System.out.println("编码后:" + s);


        // 3.获取解码器
        Base64.Decoder decoder = Base64.getDecoder();

        // 4.对s进行解码
        byte[] bys = decoder.decode(s);
        System.out.println("解码后:" + new String(bys));
    }
}
