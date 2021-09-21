package com.itheima.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * 分页显示页面所需数据
 */
public class PageBean<T> implements Serializable {
    private int curPageNo;                                  //当前页码
    private int pageSize;                                   //每页显示的条数
    private List<T> list = new ArrayList<>();         //每页显示的集合数据
    private int count;                                      //总条数
    private int totalPage;                                  //总页数

    public int getCurPageNo() {
        return curPageNo;
    }

    public void setCurPageNo(int curPageNo) {
        this.curPageNo = curPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "curPageNo=" + curPageNo +
                ", pageSize=" + pageSize +
                ", list=" + list +
                ", count=" + count +
                ", totalPage=" + totalPage +
                '}';
    }
}
