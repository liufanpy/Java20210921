package com.itheima.utils;

import javax.servlet.http.Cookie;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 10:07
 */
public class CookieUtils {

    /**
     * 查找指定的cookie
     * @param cookieName
     * @param cookies
     * @return cookie对象
     */
    public static Cookie getCookie(String cookieName,Cookie[] cookies){
        // 如果没有携带cookie
        if (cookies == null){
            return null;
        }

        // 如果有携带cookie,找到了
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (cookieName.equals(name)){
                // 找到了
                return cookie;
            }
        }

        // 如果有携带cookie,没找到
        return null;
    }

}
