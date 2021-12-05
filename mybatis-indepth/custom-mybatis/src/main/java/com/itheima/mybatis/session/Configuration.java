package com.itheima.mybatis.session;

import com.itheima.mybatis.binding.Mapper;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 *  封装配置信息：
 *      1. 核心配置文件 sqlMapConfig.xml
 *      2. xxxMapper.xml
 */

@Data
public class Configuration {

    // 数据源连接信息
    private String driver;
    private String url;
    private String username;
    private String password;

    // mapper集合
    private Map<String,Mapper> mappers = new HashMap<>();


    // 注意细节： mapper可能会有多个，因此采用put追加的方式，避免后面把前面覆盖了；
    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }
}
