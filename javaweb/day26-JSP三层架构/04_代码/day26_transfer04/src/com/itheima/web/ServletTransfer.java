package com.itheima.web;

import com.itheima.service.ServiceTransfer;
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

    // 创建Service对象
    private ServiceTransfer service = new ServiceTransfer();

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

            // 3.调用service层
            boolean flag = service.transfer(fromUsername,toUsername,money);

            // 4.根据结果,响应页面
            if (flag == true){
                // 转账成功
                response.getWriter().println("转账成功!");
            }else{
                // 转账失败
                response.getWriter().println("转账失败!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            // 转账失败
            response.getWriter().println("转账失败!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
