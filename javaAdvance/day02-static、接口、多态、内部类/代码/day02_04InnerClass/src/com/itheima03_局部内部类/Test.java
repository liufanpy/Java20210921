package com.itheima03_局部内部类;

public class Test {
    public static void main(String[] args) {
        class Inner {
            public void show() {
                System.out.println("这是局部内部类的show方法");
            }
        }

        Inner in = new Inner();
        in.show();

    }
}
