package com.itheima.mp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("tb_user") //写上数据库里面的表名. 和表进行映射,到时候我们只需要操作对象就好了,不需要写sql语句了【如果表名和类名一致, 可以不写@TableName() 一般建议写】
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @TableId(type = IdType.AUTO) //AUTO自动增长,我们插入时候不需要设置id; INPUT自己输入ID
    private Long id;

    @TableField(value = "username")  //如果属性和数据库的列不一致, 就一定要指定@TableField
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String email;


    //@TableField(exist = false)
    //private  String flag;


}