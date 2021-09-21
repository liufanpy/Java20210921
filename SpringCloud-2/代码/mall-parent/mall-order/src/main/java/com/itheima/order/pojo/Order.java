package com.itheima.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable{
	private String id;//订单id
	private Integer totalMoney;//金额合计
	private String username;//用户名称
	private String receiverContact;//收货人
	private String name;//SKU名称(商品名称)
	private Integer price;//价格（分）
	private Integer num;//库存数量
	private String brandName;//品牌名称
}
