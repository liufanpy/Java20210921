package com.itheima.mm.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;
import com.itheima.mm.constants.Constants;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.service.CommonService;
import com.itheima.mm.utils.JedisUtils;
import com.itheima.mm.utils.JsonUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: yp
 */
@Controller
public class CommonController {

    private CommonService commonService = new CommonService();


    /**
     * 获得学科列表
     *
     * @param request
     * @param response
     */
    @RequestMapping("/common/courseList")
    public void getCourseList(HttpServletRequest request, HttpServletResponse response) throws IOException {
    /*    Jedis jedis = null;
        try {
            //1.先从Redis里面获得
            jedis = JedisUtils.getJedis();
            String courseData = jedis.get(Constants.MM_COURSER_KEY);
            if(courseData != null){
                System.out.println("Redis里面有, 直接从Redis里面获得...");
                //2.有, 就直接返回
                Result result = new Result(true, "学科列表获得成功", JSON.parse(courseData));
                JsonUtils.printResult(response,result);
            }else {
                System.out.println("Redis里面没有的,从MySQL获得,再存到Redis...");
                //3.没有, 从MySQl获得, 再存到Redis
                List<Course> list =  commonService.getCourseList();
                jedis.set(Constants.MM_COURSER_KEY,JSON.toJSONString(list));
                Result result = new Result(true, "学科列表获得成功", list);
                JsonUtils.printResult(response,result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "学科列表获得失败");
            JsonUtils.printResult(response,result);

        }finally {
            JedisUtils.close(jedis);
        }*/


      try {
            //1.调用业务 获得学科的数据List<Course> list
            List<Course> list =  commonService.getCourseList();
            //2.封装成Result 响应
            Result result = new Result(true, "学科列表获得成功", list);
            JsonUtils.printResult(response,result);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "学科列表获得失败");
            JsonUtils.printResult(response,result);
        }

    }

    /**
     * 获得城市
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/common/citys")
    public void getCitys(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            //113.88308,22.55329
            //1.获得请求参数(fs,location) 封装成Map对象
            Map hashMap = JsonUtils.parseJSON2Object(request, Map.class);
            //2.调用业务 获得城市的数据Map
            Map resultMap = commonService.getCitys(hashMap);
            //3.封装成Result 响应
            Result result = new Result(true, "城市获得成功", resultMap);
            JsonUtils.printResult(response, result);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "城市获得失败");
            JsonUtils.printResult(response, result);
        }

    }

}
