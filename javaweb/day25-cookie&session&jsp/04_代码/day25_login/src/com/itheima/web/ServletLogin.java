package com.itheima.web;

import com.itheima.bean.User;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 16:15
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.处理乱码
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");

            // *********************校验验证码*******************************
            // 1.获得用户输入的验证码
            String checkCode = request.getParameter("checkCode");

            // 2.获得事先生成的验证码
            String code = (String) request.getSession().getAttribute("checkCode");

            // 3.校验
            if (!checkCode.equalsIgnoreCase(code)) {
                System.out.println("验证码失败...");
                // 不相等,响应失败页面
                response.sendRedirect(request.getContextPath() + "/failed.html");
                // 提前结束程序
                return;
            }


            // *********************校验用户名和密码*******************************
            // 2.获得请求参数(用户输入的用户名和密码)
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // 3.创建QueryRunner对象
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            // 4.调用query方法查询数据库,把结果封装成User对象
            String sql = "select * from user where username = ? and password = ?";
            User user = qr.query(sql, new BeanHandler<User>(User.class), username, password);

            // 5.判断是否登录成功(判断user对象是否为null)
            if (user == null) {
                System.out.println("用户名或者密码错误...");
                // 5.1 如果为null,表示登录失败,重定向到失败页面
                response.sendRedirect(request.getContextPath() + "/failed.html");

            } else {
                // ***************实现记住用户名的功能(登录成功才去记住用户名)*************************
                //1.获得记住用户名复选框的值
                String remember = request.getParameter("remember");

                //2.判断复选框是否勾选(值是否为ok或者null)
                if (remember != null && "ok".equals(remember)) {
                    //3.如果值不为null,为ok,那么就勾选了记住用户名复选框
                    //3.1 创建Cookie对象,保存用户名
                    Cookie cookie = new Cookie("username", username);
                    //3.2 设置Cookie对象的有效时长
                    cookie.setMaxAge(60*60*24*7);
                    //3.3 设置Cookie对象的有效路径
                    cookie.setPath(request.getContextPath());
                    //3.4 响应Cookie对象给浏览器
                    response.addCookie(cookie);
                }else {
                    //4. 如果复选框没有勾选,
                    //3.1 创建Cookie对象,保存空值,键还是和之前的Cookie的键一样
                    Cookie cookie = new Cookie("username", "");
                    //3.2 设置Cookie对象的有效时长为0
                    cookie.setMaxAge(0);
                    //3.3 设置Cookie对象的有效路径,还是和之前的Cookie的有效路径一样
                    cookie.setPath(request.getContextPath());
                    //3.4 响应Cookie对象给浏览器
                    response.addCookie(cookie);
                }


                // 5.2 如果不为null,表示登录成功,重定向到成功页面
                response.sendRedirect(request.getContextPath() + "/success.html");
            }
        } catch (SQLException e) {
            // 异常(失败)
            response.sendRedirect(request.getContextPath() + "/failed.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
