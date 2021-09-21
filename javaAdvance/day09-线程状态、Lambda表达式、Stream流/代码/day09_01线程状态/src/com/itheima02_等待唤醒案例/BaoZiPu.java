package com.itheima02_等待唤醒案例;

public class BaoZiPu extends Thread {
    public BaoZi bz;

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            synchronized (bz) {
                // 有包子时，包子状态为true，包子铺线程进入等待(将执行权交给吃货吃包子)。
                // if (bz.isFlag()==true)
                if (bz.isFlag()) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 没包子时，包子状态为false，包子铺线程生产包子，包子状态为true，唤醒吃货线程。
                try {
                    System.out.println("做包子中...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (index % 2 == 0) {
                    bz.setPier("水晶皮");
                    bz.setXianer("五仁");
                } else {
                    bz.setPier("糯米");
                    bz.setXianer("红豆");
                }
                index++;
                bz.setFlag(true);
                bz.notify();
            }

        }
    }
}
