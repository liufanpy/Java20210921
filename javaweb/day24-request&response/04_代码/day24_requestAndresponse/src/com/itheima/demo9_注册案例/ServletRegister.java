package com.itheima.demo9_注册案例;

import com.itheima.utils.C3P0Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 15:50
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.处理请求和响应乱码
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");

            //2.获得浏览器提交的数据(请求参数)
            Map<String, String[]> map = request.getParameterMap();

            //3.封装请求参数--->User对象
            User user = new User();
            BeanUtils.populate(user, map);
            // 单独设置状态属性
            user.setStatus("0");

            System.out.println("user:" + user);

            //4.创建QueryRunner对象
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            //5.调用update方法把数据插入到数据库,返回受影响的行数
            String sql = "insert into user values(null,?,?,?,?,?,?,?)";
            Object[] args = {
                    user.getUsername(),
                    user.getPassword(),
                    user.getAddress(),
                    user.getNickname(),
                    user.getGender(),
                    user.getEmail(),
                    //user.getStatus()
            };
            int rows = qr.update(sql, args);

            //6.判断受影响的行数:
            if (rows > 0) {
                //6.1 如果大于0,重定向到成功页面(success.html)
                response.sendRedirect("/day24/success.html");
            } else {
                //6.2 如果不大于0,重定向到失败页面(failed.html)
                response.sendRedirect("/day24/failed.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 失败了
            response.sendRedirect("/day24/failed.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
