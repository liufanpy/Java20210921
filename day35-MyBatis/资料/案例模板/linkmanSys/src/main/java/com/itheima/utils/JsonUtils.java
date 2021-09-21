package com.itheima.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JsonUtils {


    /**
     * 响应结果
     * @param response
     * @param obj
     * @throws IOException
     */
    public static void printResult(HttpServletResponse response, Object obj) throws IOException {
        //设置服务器响应的内容类型
        response.setContentType("application/json;charset=utf-8");
        //response.getWriter.print(JSON.toJSONString(obj));
        JSON.writeJSONString(response.getWriter(),obj);
    }

    /**
     * 把json转成对象
     * @param request
     * @param tClass
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T parseJSON2Object(HttpServletRequest request, Class<T> tClass) throws IOException{
        // 使用axios正常的post请求传参数  后台使用request.getParameter()方法无法正常获取！
        // 把表单数据之间转对象   从请求信息的流中读取传递参数 封装到对应的javabean中
        return JSON.parseObject(request.getInputStream(),tClass);
    }


}
