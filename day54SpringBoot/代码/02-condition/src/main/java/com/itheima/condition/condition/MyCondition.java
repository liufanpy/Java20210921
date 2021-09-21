package com.itheima.condition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Description:
 * @author: yp
 */
public class MyCondition implements Condition {
    /**
     * 返回值: 返回true 代表满足条件; false:代表不满足条件
     * @param context Condition上下文对象  获得Spring容器,类加载器
     * @param metadata 注解原数据对象,  获得注解的属性
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //在MyCondition里面获得@ConditionalOnClass(name = {"redis.clients.jedis.Jedis"})的name的属性值
        try {
            //1.获得ConditionalOnClass注解的全部属性
            Map<String, Object> map = metadata.getAnnotationAttributes(ConditionalOnClass.class.getName());
            //2.获得name的属性值
            String[] values = (String[]) map.get("name");
            for (String value : values) {
                //System.out.println("value="+value);
                Class.forName(value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
