package com.itheima.demo8_记录上一次访问时间案例;

import com.itheima.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 11:33
 */
@WebServlet("/ServletDemo16")
public class ServletDemo16 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.处理乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取浏览器携带的所有Cookie---->数组cookies
        Cookie[] cookies = request.getCookies();

        //2.判断是否是第一次访问(其实就是判断携带的Cookie里面有没有目标Cookie)
        Cookie lastTimeCookie = CookieUtils.getCookie("lastTime", cookies);

        // 判断
        if (lastTimeCookie == null) {
            //3.如果是第一次访问:
            //3.1 创建当前日期对象
            Date nowDate = new Date();

            //3.2 把日期对象转换为对应的毫秒值( long getTime())
            long time = nowDate.getTime();

            //3.3 创建Cookie对象,存储当前访问的系统时间--->Cookie名字: lastTime
            Cookie cookie = new Cookie("lastTime", time + "");

            //3.4 设置有效时长
//            cookie.setMaxAge(60*60*24*7);

            //3.5 设置有效路径(项目部署路径)
//            cookie.setPath(request.getContextPath());

            //3.6 响应给浏览器
            response.addCookie(cookie);

            //3.7 响应欢迎数据到页面(欢迎第一次访问本网站)
            response.getWriter().print("欢迎第一次访问本网站!");

        } else {
            //4.如果不是第一次访问:
            //4.1 获取存储上一次访问时间的目标Cookie对象
            //4.2 获取目标Cookie对象中的时间
            String lastTime = lastTimeCookie.getValue();

            //4.3 把毫秒值时间转换为Date日期
            Date lastDate = new Date(Long.parseLong(lastTime));
            String sLastTime = lastDate.toLocaleString();

            //4.4 把当前系统时间存储到目标Cookie中(更新时间)
            //4.4.1 创建当前日期对象
            Date nowDate = new Date();

            //4.4.2 把日期对象转换为对应的毫秒值( long getTime())
            long time = nowDate.getTime();

            //4.4.3 创建Cookie对象,存储当前访问的系统时间--->Cookie名字: lastTime
            Cookie cookie = new Cookie("lastTime", time + "");

            //4.4.4 设置有效时长
            cookie.setMaxAge(60*60*24*7);

            //4.4.5 设置有效路径(项目部署路径)
            cookie.setPath(request.getContextPath());

            //4.4.6 响应给浏览器
            response.addCookie(cookie);

            //4.5 把时间响应到页面上(您上一次访问的时间是:  xxx...)
            response.getWriter().print("您上一次访问的时间是:"+sLastTime);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
