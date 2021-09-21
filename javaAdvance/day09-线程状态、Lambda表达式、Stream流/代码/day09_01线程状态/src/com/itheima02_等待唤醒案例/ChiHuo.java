package com.itheima02_等待唤醒案例;

public class ChiHuo extends Thread {
    public BaoZi bz;

    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                // 没包子时，包子状态为false，吃货线程进入等待(将执行权交给包子铺做包子)。
                // if (bz.isFlag()==false)
                if (!bz.isFlag()) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 有包子时，包子状态为true，吃货线程吃完包子，包子状态为false，唤醒包子铺线程
                System.out.println("吃货开始吃包子:" + bz.toString());
                bz.setFlag(false);
                bz.notify();
            }
        }
    }
}
