package comitheima03_实现Runnable创建接口线程;

public class MyRunnable  implements Runnable {
    int i=10;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }
            System.out.println(Thread.currentThread().getName() + "i=" + i);
        }
    }
}
