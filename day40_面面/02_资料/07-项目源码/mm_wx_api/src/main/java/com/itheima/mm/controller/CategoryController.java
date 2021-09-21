package com.itheima.mm.controller;

import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.WxMember;
import com.itheima.mm.service.CategoryService;
import com.itheima.mm.service.WxMemberService;
import com.itheima.mm.utils.JsonUtils;

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
public class CategoryController {


    private WxMemberService memberService = new WxMemberService();

    private CategoryService categoryService = new CategoryService();
    /**
     * 题库分类列表
     * @param request
     * @param response
     */
    @RequestMapping("/category/list")
    public void categoryList(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            //1.获得请求参数(categoryKind,categoryType) 封装到Map
            Map paramMap =  JsonUtils.parseJSON2Object(request, Map.class);
            //2.获得请求头, 获得opend_id
            String authorization = request.getHeader("Authorization");
            String openId = authorization.substring(7);
            //3.调用根据opend_id获得Member对象 获得city_id和course_id
            WxMember member = memberService.findByOpenId(openId);
            paramMap.put("city_id",member.getCityId());
            paramMap.put("course_id",member.getCourseId());
            paramMap.put("member_id",member.getId());

            //4.调用业务, 进行查询 List<Map> list
            List<Map> mapList  = categoryService.categoryList(paramMap);
            //5.封装Result 响应
            Result result = new Result(true, "题库分类列表查询成功", mapList);
            JsonUtils.printResult(response,result);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "题库分类列表查询失败");
            JsonUtils.printResult(response,result);
        }

    }

}
