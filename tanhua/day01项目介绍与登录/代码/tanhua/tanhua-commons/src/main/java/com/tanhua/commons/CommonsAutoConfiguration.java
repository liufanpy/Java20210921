package com.tanhua.commons;

import com.tanhua.commons.properties.SmsProperties;
import com.tanhua.commons.templates.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配类
 */
@Configuration
@EnableConfigurationProperties({SmsProperties.class})
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
}