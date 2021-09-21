package com.tanhua.commons;

import com.tanhua.commons.properties.FaceProperties;
import com.tanhua.commons.properties.HuanXinProperties;
import com.tanhua.commons.properties.OssProperties;
import com.tanhua.commons.properties.SmsProperties;
import com.tanhua.commons.templates.FaceTemplate;
import com.tanhua.commons.templates.HuanXinTemplate;
import com.tanhua.commons.templates.OssTemplate;
import com.tanhua.commons.templates.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 自动装配类
 */
@Configuration
@EnableConfigurationProperties({
        SmsProperties.class,
        OssProperties.class,
        FaceProperties.class,
        HuanXinProperties.class
})
public class CommonsAutoConfiguration {



    /**
     * 当工程启动后，创建SmsTemplate对象 放到spring容器中
     * 使用：
     * @Autowired
     * private SmsTemplate smsTemplate;
     * @param smsProperties
     * @return
     */
    @Bean
    public SmsTemplate smsTemplate(SmsProperties smsProperties){
        SmsTemplate smsTemplate = new SmsTemplate(smsProperties);
        smsTemplate.init();
        return smsTemplate;
    }

    /**
     * 注册ossTempalte
     */
    @Bean
    public OssTemplate ossTemplate(OssProperties ossProperties){
        return new OssTemplate(ossProperties);
    }

    /**
     * 注册FaceTemplate
     */
    @Bean
    public FaceTemplate faceTemplate(FaceProperties faceProperties){
        return new FaceTemplate(faceProperties);
    }

    /**
     * 注册环信通信
     */
    @Bean
    public HuanXinTemplate huanXinTemplate(HuanXinProperties huanXinProperties){
        return new HuanXinTemplate(huanXinProperties);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}