package com.itheima.mm.controller;

import com.alibaba.fastjson.JSONObject;
import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.WxMember;
import com.itheima.mm.service.WxMemberService;
import com.itheima.mm.utils.DateUtils;
import com.itheima.mm.utils.JsonUtils;
import com.itheima.mm.utils.WxUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: yp
 */
@Controller
public class WxMemberController {

    private WxMemberService memberService = new WxMemberService();

    /**
     * 设置当前用户的城市和学科
     *
     * @param request
     * @param response
     */
    @RequestMapping("/member/setCityCourse")
    public void setCityCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //1.获得请求参数(cityID,subjectID) 使用Map接收
            Map paramMap = JsonUtils.parseJSON2Object(request, Map.class);
            //2.获得请求头Authorization, 获得open_id(token)的值
            String authorization = request.getHeader("Authorization");
            String openId = authorization.substring(7);
            paramMap.put("openId", openId);
            //3.调用业务, 根据open_id更新
            memberService.setCityCourse(paramMap);
            //4.响应
            Result result = new Result(true, "设置学科和城市成功");
            JsonUtils.printResult(response, result);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "设置学科和城市失败");
            JsonUtils.printResult(response, result);
        }
    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/member/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            //1.获得请求参数(encryptedData微信用户的加密的数据,iv偏移量,code临时票据), 使用Map接收
            Map paramMap = JsonUtils.parseJSON2Object(request, Map.class);
            //2.根据code临时票据+appid+appsecret请求微信服务器进行验证获得session_key,opendid
            String code = (String) paramMap.get("code");
            JSONObject jsonObject = WxUtil.get(code);

            //3.判断当前的用户是否注册过(调用业务根据opendid去查)
            String openid = jsonObject.getString("openid");
            WxMember wxMember = memberService.findByOpenId(openid);
            //4.没有注册过, 根据session_key+iv解密encryptedData获得当前用户的微信数据,封装成Member,调用业务进行注册
            if (wxMember == null) {
                String iv = (String) paramMap.get("iv"); //偏移量
                String encryptedData = (String) paramMap.get("encryptedData"); //微信用户的加密的数据
                String session_key = jsonObject.getString("session_key"); //sessionKey
                JSONObject userInfo = WxUtil.getUserInfo(encryptedData, session_key, iv);//根据session_key+iv解密encryptedData获得当前用户的微信数据
                wxMember = new WxMember();
                wxMember.setNickName(userInfo.getString("nickName"));
                wxMember.setAvatarUrl(userInfo.getString("avatarUrl"));
                wxMember.setGender(userInfo.getString("gender"));
                wxMember.setCity(userInfo.getString("city"));
                wxMember.setProvince(userInfo.getString("province"));
                wxMember.setCountry(userInfo.getString("country"));
                wxMember.setLanguage(userInfo.getString("language"));
                wxMember.setOpenId(userInfo.getString("openId"));
                wxMember.setUnionId(userInfo.getString("unionId"));
                wxMember.setCreateTime(DateUtils.parseDate2String(new Date()));
                //调用微信用户服务，执行新增操作
                memberService.add(wxMember);
            }
            //5.响应【token(opendid),用户信息(Member)-->Map】
            Map resultMap = new HashMap();
            resultMap.put("token", openid);
            resultMap.put("userInfo", wxMember);
            Result result = new Result(true, "登录成功", resultMap);
            JsonUtils.printResult(response, result);

        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "登录失败");
            JsonUtils.printResult(response, result);
        }

    }

}
