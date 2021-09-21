    package com.itheima.exception;

    import org.springframework.web.servlet.HandlerExceptionResolver;
    import org.springframework.web.servlet.ModelAndView;

    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    /*
        自定义的异常处理器
            1. 实现接口HandlerExceptionResolver
            2. 实现方法resolveException ： 处理异常的
     */

    public class MyExceptionHandler implements HandlerExceptionResolver {

        /**
         *
         * @param request
         * @param response
         * @param handler
         * @param ex   异常对象，到底现在出现的是什么异常？
         * @return ModelAndView , 为了让我们包装视图和数据，给用户看
         */
        public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                             Object handler, Exception ex) {

            //1. 创建ModelAndView对象
            ModelAndView mv = new ModelAndView();

            //2. 包装视图
            mv.setViewName("error");

            //3. 包装数据
            String  msg =  "出现类运行时异常啦~~";


            if(ex instanceof  NullPointerException){
                msg = "出现空异常啦~~";
            }else if(ex instanceof  ClassCastException){
                msg = "出现类型转换异常啦~~";
            }


            mv.addObject("msg", msg);

            return mv;
        }
    }
