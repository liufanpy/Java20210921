package com.itheima.job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob {

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 一个方法可以看成是一个任务
     */
    public void print(){
        System.out.println("打印一句话~~"+ sf.format(new Date()));
    }
}
