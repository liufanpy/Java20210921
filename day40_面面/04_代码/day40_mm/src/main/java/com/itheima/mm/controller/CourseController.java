package com.itheima.mm.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.CourseService;
import com.itheima.mm.utils.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/*
    学科的控制器
 */

@Controller
public class CourseController {

    /**
     * 更新学科
     * @param req
     * @param resp
     */
    @RequestMapping("/update")
    public void update(HttpServletRequest req , HttpServletResponse resp){

        try {
            //1. 获取参数
            Course course = JSON.parseObject(req.getInputStream() , Course.class);

            //2. 调用service
            CourseService cs = new CourseService();
            int row = cs.update(course);

            //3. 响应
            Result result = null;
            if(row >0 ){
                result = new Result(true , "更新成功");
            }else{
                result = new Result(false , "更新失败");
            }
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 学科列表，分页查询
     * @param req
     * @param resp
     */
    @RequestMapping("/findByPage")
    public void findByPage(HttpServletRequest req , HttpServletResponse resp){
        try {
            //1. 获取参数
            QueryPageBean bean = JSON.parseObject(req.getInputStream() , QueryPageBean.class);

            //2. 调用service
            CourseService cs = new CourseService();
            PageResult pageResult = cs.findByPage(bean);

            //3. 响应
            Result result = new Result(true , "查询成功" , pageResult);
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();

            try {
                Result result = new Result(false , "查询失败" );
                resp.getWriter().write(JSON.toJSONString(result));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * 添加学科
     * @param req
     * @param resp
     */
    @RequestMapping("/add")
    public void add(HttpServletRequest req , HttpServletResponse resp){

        try {
            //1. 获取请求参数
            Course course = JSON.parseObject(req.getInputStream() , Course.class);

            //1.1 从页面接收的数据，并不是完整的数据，缺少了：  创建日期，用户的id值， 排序的序号
            //设置时间
            course.setCreateDate(DateUtils.parseDate2String(new Date()));
            //设置排序的序号
            course.setOrderNo(1);
            //设置用户的id
            User user = (User) req.getSession().getAttribute("user");
            course.setUserId(user.getId());



            //2. 交代service
            CourseService cs = new CourseService();
            int row = cs.add(course);

            //3. 响应
            Result result = null;
            if(row > 0){ //添加成功
                result = new Result(true , "添加成功");
            }else{ //添加失败
                result = new Result(false , "添加失败");
            }
            resp.getWriter().write(JSON.toJSONString(result));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
