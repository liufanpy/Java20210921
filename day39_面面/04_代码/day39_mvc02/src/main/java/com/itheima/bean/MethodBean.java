package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodBean {
    private Method method; //真正要执行的方法
    private Object object ;  // 调用上面的方法用什么对象来调用
}
