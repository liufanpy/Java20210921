package com.itheima.demo4_conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

    /**
     * 用于判定当前的操作系统是否是Linux
     * @param context
     * @param metadata
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //得到系统的名字
        String name = context.getEnvironment().getProperty("os.name");

        return name.contains("Linux");
    }
}
