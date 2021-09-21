package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * pojo包装类型  封装参数
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryVo implements Serializable {

    private List<Integer> ids;

    //封装查询条件
    private User user;
}
