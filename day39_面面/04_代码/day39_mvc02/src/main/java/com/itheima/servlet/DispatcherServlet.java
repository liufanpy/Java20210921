package com.itheima.servlet;

import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;
import com.itheima.bean.MethodBean;
import com.itheima.utils.ClassScannerUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    DispatcherServlet:
        1. 它是一个servlet，要抓住所有尾巴带.do的请求
        2. 重写两个方法 init方法和service
            2.1. init方法负责完成初始化，包括：扫描包，解析方法，得到映射，封装映射和方法以及对象的关系
            2.2. service方法负责完成具体方法调用

        3. 注册DispatcherServlet，使用xml方式来注册
            3.1. 抓.do的后缀
            3.2. 配置初始化参数，初始化参数就用来指定扫描的包名
            3.3. 让这个servlet的init方法调用时机更加的提前。 <load-on-startup>1</load-on-startup>

        init :
            1. 要读取配置DispatcherServlet里面给的初始化参数，这样就知道要扫描哪个包了。
            2. 扫描指定的包，得到所有的类
            3. 遍历类

        service：
            1. 当请求来的时候，获取请求的地址
            2. 截取映射地址
            3. 拿着映射地址去map集合里面找匹配的methodBean
            4. 找到之后就调用对应的方法， 要是找不到，也可以给一句提示！

 */
public class DispatcherServlet extends HttpServlet {

    //定义map集合
    Map<String , MethodBean> map = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {

        try {
            //1. 读取初始化参数
            String packageName = config.getInitParameter("packageName");

            //2. 扫描这个包
            List<Class<?>> classList = ClassScannerUtils.getClasssFromPackage(packageName);

            //3. 遍历集合中的每一个类
            for (Class<?> clazz : classList) {

                //4. 判定这个类身上有没有 @Controller注解
                boolean flag = clazz.isAnnotationPresent(Controller.class);
                if(flag){ //表示有这个注解

                    //5. 得到这个类里面所有方法
                    Method[] methods = clazz.getMethods();

                    //6. 遍历每一个方法
                    for (Method method : methods) {
                        //7. 判断方法上是否有注解 @RequestMapping , 要注意有的方法身上没有这个注解，那么返回的是null
                        RequestMapping annotation = method.getAnnotation(RequestMapping.class);

                        if(annotation != null){//身上有这个注解
                            //获取注解身上的value值。
                            String mapping = annotation.value();

                            //8. 使用map集合来装映射管理  key : mapping  ，value : method &  clazz.newInstance();
                            MethodBean bean = new MethodBean(method , clazz.newInstance());
                            map.put(mapping , bean); // key : /user/register , value :  register方法和UserController对象

                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1. 获取请求地址
            String uri = req.getRequestURI();  //    /day39_mvc01_war_exploded/user/register.do
            String path  = uri.substring(req.getContextPath().length() , uri.lastIndexOf('.'));  //   /user/register

            //2. 拿着地址去map集合里面找匹配的集合
            MethodBean bean = map.get(path);

            //3. 要记得判定map返回的结果，因为这个映射地址在map集合里面并不一定有方法与之对应
            if(bean != null){
                //如果进入这个if分支，即表示找到匹配的记录，找到之后，就让方法执行即可
                Method method = bean.getMethod();
                Object object = bean.getObject();

                method.invoke(object ,req , resp );
            }else{
                System.out.println(path + " ,没有找到匹配的方法可以执行！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
