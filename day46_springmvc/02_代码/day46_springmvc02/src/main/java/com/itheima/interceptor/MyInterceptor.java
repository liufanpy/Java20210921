package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
    自定义拦截器
        1. 定义一个类，实现接口HandlerInterceptor

        2. 重写三个方法 preHandle |  postHandle | afterCompletion

        3. 要登记|注册这个拦截器
 */

public class MyInterceptor implements HandlerInterceptor {

    // 在目标方法(Controller01的show方法)执行之前，调用  返回true: 表示放行，返回false: 表示拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了MyInterceptor的preHandle...");


        /*
            1. 即便我们拦截到了请求， return false了之后，请求必然交不到后面的controller去了。
            2. 但是我们的这个拦截器还是要对这次请求作出响应的，否则浏览器的页面将会是一片空白！（用户体验不佳）
            3. 对请求作出响应，其实就是跳转页面或者跳转到某一个controller去。（一般是跳转页面）
         */
        //请求转发
        //request.getRequestDispatcher("error.jsp").forward(request , response);

        //重定向  localhost:8080/项目映射名/error.jsp
        /*
            由于这个拦截器，我们可以配置成拦截/show/** , 那么此时会出现一种情况
            就是多级目录的情况也被拦截了，但是这里使用相对路径跳转是非常危险的一件事。我们需要写多少个 ../ 不得而知！

            使用绝对路径
         */
        response.sendRedirect(request.getContextPath()+"/error.jsp");

        return false;
    }

    // 在目标方法(Controller01的show方法)执行之后，调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了MyInterceptor的postHandle...");
    }

    // 在页面渲染完毕之后调用。
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行了MyInterceptor的afterCompletion...");

    }
}
