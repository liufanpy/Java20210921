package com.itheima.mybatis.binding;


import lombok.Data;

/**
 * 封装mapper映射文件的对象：
 */

@Data
public class Mapper {

    // sql语句
    private String queryString;

    // 返回值类型 （实体类的全限定名）
    private String resultType;

    // 参数类型 （全限定名）
    private String parameterType;

}
