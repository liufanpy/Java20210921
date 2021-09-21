package com.itheima.es.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.Map;

public class Goods {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField(value = "title")
    private String title;

    @TableField(value = "price")
    private double price;

    @TableField(value = "stock")
    private int stock;

    @TableField(value = "saleNum")
    private int saleNum;

    @TableField(value = "createTime")
    private Date createTime;

    @TableField(value = "categoryName")
    private String categoryName;

    @TableField(value = "brandName")
    private String brandName;


    private Map spec;  //在ES里面 {}  当做一个对象去处理

    @JSONField(serialize = false)//在转换JSON时，忽略该字段
    @TableField(value = "spec")
    private String specStr;//接收数据库的信息 "{}"


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Map getSpec() {
        return spec;
    }

    public void setSpec(Map spec) {
        this.spec = spec;
    }

    public String getSpecStr() {
        return specStr;
    }

    public void setSpecStr(String specStr) {
        this.specStr = specStr;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", saleNum=" + saleNum +
                ", createTime=" + createTime +
                ", categoryName='" + categoryName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", spec=" + spec +
                ", specStr='" + specStr + '\'' +
                '}';
    }
}