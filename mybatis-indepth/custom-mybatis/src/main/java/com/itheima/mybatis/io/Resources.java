package com.itheima.mybatis.io;

import java.io.InputStream;

/**
 * 加载核心配置文件等资源的工具类；
 */
public class Resources {


    /**
     * 根据文件路径，返回输入流
     * （加载resources目录下的文件）
     *
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
