package com.itheima02_等待唤醒案例;

public class BaoZi {
    private boolean flag;//true 代表有包子   false 代表是没有包子
    private String pier;
    private String xianer;

    public BaoZi() {
    }

    public BaoZi(String pier, String xianer) {
        this.pier = pier;
        this.xianer = xianer;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getPier() {
        return pier;
    }

    public void setPier(String pier) {
        this.pier = pier;
    }

    public String getXianer() {
        return xianer;
    }

    public void setXianer(String xianer) {
        this.xianer = xianer;
    }

    @Override
    public String toString() {
        return "BaoZi{" +
                "pier='" + pier + '\'' +
                ", xianer='" + xianer + '\'' +
                '}';
    }
}
