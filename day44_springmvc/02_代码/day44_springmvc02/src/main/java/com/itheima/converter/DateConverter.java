package com.itheima.converter;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    1. 这是自定义的类型转换器， 实现Converter接口
    2. Converter里面的两个泛型，即表示： 源数据的类型 和 目标数据的类型。
 */
public class DateConverter implements Converter<String , Date> {

    /**
     * 用于转化数据
     * @param s  页面传递过来的源数据，字符串
     * @return 要转化出来的日期对象数据。
     */
    public Date convert(String s) {  //String s = "2020-10-10"

        try {
            //1. 创建SimpleDateFormat
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

            //2. 转化
            return sf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //转化不了就返回null
        return null;
    }
}
