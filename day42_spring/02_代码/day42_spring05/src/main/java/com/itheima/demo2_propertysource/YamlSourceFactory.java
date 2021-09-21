package com.itheima.demo2_propertysource;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/*
    解析yaml文件的工厂
 */
public class YamlSourceFactory implements PropertySourceFactory {

    /**
     * 创建配置文件
     * @param s
     * @param encodedResource  解析的资源
     * @return
     * @throws IOException
     */
    public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource) throws IOException {
        //1. 创建yaml解析的工厂
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        //2. 设置要解析的资源内容
        factoryBean.setResources(encodedResource.getResource());
        //3. 把资源文件解析成Properties对象
        Properties properties = factoryBean.getObject();
        //4. 把properties封装成PropertySource对象并返回
        return new PropertiesPropertySource("application", properties);
    }
}
