package com.tanhua.manage.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.tanhua.manage.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/system/users")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 后台登陆时 图片验证码 生成
     */
    @GetMapping("/verification")
    public void showValidateCodePic(String uuid,HttpServletRequest req, HttpServletResponse res){
        res.setDateHeader("Expires",0);
        res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        res.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        res.setHeader("Pragma", "no-cache");
        res.setContentType("image/jpeg");
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(299, 97);
        String code = lineCaptcha.getCode();
        log.debug("uuid={},code={}",uuid,code);
        adminService.saveCode(uuid,code);
        try {
            lineCaptcha.write(res.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}