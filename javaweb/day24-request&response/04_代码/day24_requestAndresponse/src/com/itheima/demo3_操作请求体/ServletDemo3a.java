package com.itheima.demo3_操作请求体;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/ServletDemo3a")
public class ServletDemo3a extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("username"));
        String[] hobbies = request.getParameterValues("hobby");
        String hobby = Arrays.toString(hobbies);

        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            String[] valueArr = map.get(key);
            System.out.println(key+"..."+Arrays.toString(valueArr));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
