package com.itheima.enableother.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description:
 * @author: yp
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(value = UserConfig.class)
public @interface EnableUser {
}
