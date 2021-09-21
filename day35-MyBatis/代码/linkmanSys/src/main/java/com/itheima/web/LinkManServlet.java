package com.itheima.web;

import com.github.pagehelper.PageInfo;
import com.itheima.bean.LinkMan;
import com.itheima.bean.PageBean;
import com.itheima.bean.Result;
import com.itheima.service.LinkManService;
import com.itheima.utils.JsonUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/linkMan")
public class LinkManServlet extends HttpServlet {
    /*
        查询所有联系人    http://localhost:8080/day30/linkMan?method=findAll
        增加联系人    http://localhost:8080/day30/linkMan?method=add
        删除联系人    http://localhost:8080/day30/linkMan?method=delete
        分页显示联系人http://localhost:8080/day30/linkMan?method=findPage
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码问题
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //request.getMethod();  获取请求方式  get|post
        String method = request.getParameter("method");
        /*
            使用反射优化：通过反射进行方法调用
            1.获取类的Class对象
            2.通过Class对象获取当前类实例对象
            3.通过Class对象获取方法的Method对象
            4.通过反射Method.invoke 实现方法调用
         */
        try {
            Class<LinkManServlet> c = LinkManServlet.class;
            LinkManServlet instance = c.newInstance();
            Method m = c.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //打破封装
            m.setAccessible(true);
            //反射调用方法
            m.invoke(instance,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    LinkManService linkManService = new LinkManService();
    /**
     * 查询所有联系人
     */
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            //1.获取请求参数
            //2.调用业务处理
            List<LinkMan> list = linkManService.findAll();
            System.out.println("list = " + list);
            //3.响应
            Result result = new Result(true,"查询所有联系人成功",list);
            JsonUtils.printResult(response,result);
        }catch (Exception e){
            e.printStackTrace();
            Result result = new Result(false,"服务器异常！",null);
            JsonUtils.printResult(response,result);
        }
    }

    /**
     * 增加联系人
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //1.获取请求参数
           LinkMan linkMan = JsonUtils.parseJSON2Object(request,LinkMan.class);
            System.out.println("linkMan = " + linkMan);
            //2.调用业务处理
            boolean flag = linkManService.add(linkMan);
            //3.响应
            if(flag){
                Result result = new Result(true,"添加联系人成功！",null);
                JsonUtils.printResult(response,result);
            }else{
                Result result = new Result(false,"添加联系人失败！",null);
                JsonUtils.printResult(response,result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false,"服务器异常！",null);
            JsonUtils.printResult(response,result);
        }
    }

    /**
     * 删除联系人
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //1.获取请求参数
            Integer id = Integer.parseInt(request.getParameter("id"));
            //2.调用业务处理
            linkManService.delete(id);
            //3.响应
            Result result = new Result(true,"删除成功",null);
            JsonUtils.printResult(response,result);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false,"删除失败，服务器异常！",null);
            JsonUtils.printResult(response,result);
        }
    }

    /**
     * 分页展示联系人
     */
    private void findPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //1.获取请求参数
            String curPageNoStr = request.getParameter("curPageNo");
            int curPageNo = curPageNoStr == null || "".equals(curPageNoStr) ? 1 : Integer.parseInt(curPageNoStr);
            int pageSize = 5;
            //2.调用业务处理
            //获取每页要显示的数据
            PageInfo<LinkMan> pageInfo = linkManService.findPage(curPageNo,pageSize);
            //3.响应
            request.setAttribute("page",pageInfo);
            request.getRequestDispatcher("list_page.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("服务器异常！");
        }
    }

    /**
     * 修改联系人
     */
    private void update(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求参数
        //2.调用业务处理
        //3.响应
    }
}
