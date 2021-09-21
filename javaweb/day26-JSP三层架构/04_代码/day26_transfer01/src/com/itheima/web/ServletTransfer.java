package com.itheima.web;

import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/7 11:54
 */
@WebServlet("/ServletTransfer")
public class ServletTransfer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.处理乱码
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");

            //2.获得请求参数(付款方,收款方,转账金额)
            String fromUsername = request.getParameter("from");
            String toUsername = request.getParameter("to");
            String moneyStr = request.getParameter("money");
            double money = Double.parseDouble(moneyStr);

            //3.业务逻辑判断(余额是否够转账,收款方的名字是否合法,.....)
            //3.创建QueryRunner对象
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            //4.执行sql语句
            String sql1 = "update account set money = money - ? where name = ?";
            int rows1 = qr.update(sql1, money, fromUsername);

            String sql2 = "update account set money = money + ? where name = ?";
            int rows2 = qr.update(sql2, money, toUsername);

            //5.判断结果,然后响应结果到页面(转账成功,转账失败)
            if (rows1 > 0 && rows2 > 0){
                // 转账成功
                response.getWriter().println("转账成功!");
            }else{
                // 转账失败
                response.getWriter().println("转账失败!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // 转账失败
            response.getWriter().println("转账失败!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
