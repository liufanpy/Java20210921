package com.itheima.bean;

import lombok.Data;

import java.util.List;

/**
 * 就是一个pojo的包装类型 封装请求参数类
 * 其实就是为了方便封装参数，当参数有多个并且包含pojo时就使用pojo的包装类型。
 */
@Data
public class QueryVo {
    private List<Integer> ids;
    private User user;
    private Role role;
}
