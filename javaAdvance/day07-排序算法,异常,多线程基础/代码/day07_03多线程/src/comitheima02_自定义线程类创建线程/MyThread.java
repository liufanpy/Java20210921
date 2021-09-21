package comitheima02_自定义线程类创建线程;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }
            System.out.println(getName() + "i=" + i);
        }
    }
}
