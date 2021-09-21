package com.itheima.enableother.config;

import com.itheima.enableother.bean.Role;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @author: yp
 */
public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata  注解元数据
     * @return  返回值: 就是让Spring加载bean的类的全限定名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.itheima.enableother.bean.User","com.itheima.enableother.bean.Role"};
    }
}
