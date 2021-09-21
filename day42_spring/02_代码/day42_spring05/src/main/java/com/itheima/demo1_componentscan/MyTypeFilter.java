package com.itheima.demo1_componentscan;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/*
    自定义的忽略|包含的过滤器
 */
public class MyTypeFilter  implements TypeFilter {

    /**
     * 用于控制到底什么规则即满足忽略 或者 包含。
     * @param metadataReader  里面包含了我们正要验证的类的信息
     * @param metadataReaderFactory 工厂
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //需求： 哪个类身上包含了User这样的字符串，我们就排除它。

        // 得到现在正在扫描的这个类的元数据对象
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //得到这个类的全路径名
        String className = classMetadata.getClassName();


        //判断这个类的名字是否包含User，如果包含，返回true， 否则返回false.
        //如果我们在核心配置类里面使用的是排除的规则，那么true即表示要排除这个类，false表示不排除这个类
        //如果我们在核心配置类里面使用的是包含的规则，那么true即表示要扫描这个类，false表示不扫描这个类。
        return className.contains("User");
    }
}
