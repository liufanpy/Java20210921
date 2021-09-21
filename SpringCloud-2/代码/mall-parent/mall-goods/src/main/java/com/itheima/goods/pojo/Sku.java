package com.itheima.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sku implements Serializable {
	private String id;//商品id
	private String name;//SKU名称
	private Integer price;//价格（分）
	private Integer num;//库存数量
	private String brandName;//品牌名称
	private String status;//商品状态 1-正常，2-下架，3-删除
}
