package com.itheima.demo3_操作请求体;

import com.itheima.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 9:56
 */
@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理请求乱码
        request.setCharacterEncoding("utf-8");

        // 获得用户名
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 获得爱好
        String[] hobbies = request.getParameterValues("hobby");
        String hobby = Arrays.toString(hobbies);// []

        System.out.println("用户输入的用户名:"+username);
        System.out.println("用户输入的密码:"+password);
        System.out.println("用户选择的爱好:"+hobby);
        System.out.println("------------------");

        // 获取所有提交的请求参数-->eg: {username=[zs],password=[123],hobby=[basketball,football]}
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            String[] valueArr = map.get(key);
            System.out.println(key+"..."+Arrays.toString(valueArr));
        }

        System.out.println("=============使用BeanUtils封装数据=====================");
        try {
            // 创建User对象(空参构造)
            User user = new User();

            // 使用BeanUtils.populate(对象,map);
            BeanUtils.populate(user,map);
            // 重新手动给hobby属性赋值---->覆盖之前赋的值
            user.setHobby(hobby.substring(1,hobby.length()-1));

            // 打印user对象
            System.out.println("user:"+user);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
