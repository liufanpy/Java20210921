package com.itheima.demo3_import;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/*
    导入选择器，
 */
public class MyImportSelector  implements ImportSelector {

    /**
     * 导入具体的类
     * @param importingClassMetadata
     * @return 返回一个数组，数组里面包含谁，就表示导入谁
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //数组里面包含三个类的全路径。表示要导入这个三个类
        return new String[]{Student.class.getName() , Teacher.class.getName() , Worker.class.getName()};
    }
}
