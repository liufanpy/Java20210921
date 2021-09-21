package com.itheima.servlet03;

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
import java.util.List;

/*
    1. 这是总的servlet，用来抓取所有尾巴带有.do的请求
    2. 抓到这些请求之后，对请求的地址进行截取、比对，然后去调用子模块(servlet)的方法
    3. 在service里面截取地址，和包下的类中的方法上的注解value比对。
 */
@WebServlet("*.do")
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了BaseServlet的service方法~！");

        try {
            //1. 获取请求地址，并把映射路径给截取出来
            //req.getRequestURL(); //    http://localhost:8080/day39_mvc01_war_exploded/user/register.do
            String uri = req.getRequestURI(); //   /day39_mvc01_war_exploded/user/register.do
            int start = req.getContextPath().length() ; //项目映射名的长度
            int end = uri.lastIndexOf('.') ; //最后一个.的位置
            String path = uri.substring(start , end ); //    /user/register
            System.out.println("path=" + path);

            //2. 扫描指定包 com.itheima.servlet03包， 得到包下的所有类的字节码
            List<Class<?>> classList = ClassScannerUtils.getClasssFromPackage("com.itheima.servlet03");


            //3. 遍历包下的所有类
            for (Class<?> clazz : classList) {

                //4. 获取这个类身上的所有方法
                Method[] methods = clazz.getMethods();

                //5. 遍历每一个方法
                for (Method method : methods) {

                    //6. 获取这个方法身上的注解 @RequestMapping 对象
                    // 要注意，并不是所有类中的所有方法都被打上了 @RequestMapping的注解
                    RequestMapping annotation = method.getAnnotation(RequestMapping.class);

                    //7. 判定有没有注解 如果不是null，就表示这个方法身上有@RequestMapping的注解
                    if(annotation != null){

                        //8. 获取@RequestMapping里面的value属性值
                        String value = annotation.value();

                        //9. 判定截获的地址和value是否一样，一样就执行方法
                        if(value.equals(path)){
                            method.invoke(clazz.newInstance() , req, resp);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
