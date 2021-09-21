package com.itheima03_Lambda表达式省略格式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
格式说明
    小括号内参数的类型可以省略；
    如果小括号内有且仅有一个参数，则小括号和参数类型可以一起省略；
    如果小括号内有且仅有一个参数，大括号内有且仅有一个语句，则可以同时省略一对大括号，语句后的分号，return关键字；
需求：在一个接口中定义一个对新闻消息的处理方法，在测试类中定义一个方法，接收一个消息集合与新闻接口的实现类对象。
通过Lambda的省略格式完成上述需求。
*/
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("消息1");
        list.add("消息2");
        list.add("消息3");
        //自定义类
        // NewsInterImpl nii = new NewsInterImpl();
        // showMessage(list, nii);
        //匿名内部类
        // showMessage(list, new NewInter() {
        //     @Override
        //     public String message(String message) {
        //         return message + "已被处理";
        //     }
        // });
        //Lambda表达式
        // showMessage(list, (String message) -> {
        //     return message + "已被处理";
        // });
        //Lambda表达式省略格式
        showMessage(list, message ->
                message + "已被处理"
        );
    }

    public static void showMessage(List<String> list, NewInter ni) {
        for (int i = 0; i < list.size(); i++) {
            String message = list.get(i);
            System.out.println(ni.message(message));
        }
    }
}