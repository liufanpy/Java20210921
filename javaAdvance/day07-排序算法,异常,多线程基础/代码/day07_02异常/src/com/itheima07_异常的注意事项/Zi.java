package com.itheima07_异常的注意事项;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zi extends Fu {
    //方法声明编译时异常
    @Override
    public void method() throws ParseException {
        String time = "2020-12-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(time);
    }

    //方法未声明编译时异常
    @Override
    public void method2() {
        String time = "2020-12-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sdf.parse(time);
        } catch (ParseException p) {

        }
    }
}
