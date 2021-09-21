package com.itheima.order.controller;

import com.itheima.order.feign.SkuFeign;
import com.itheima.order.pojo.Order;
import com.itheima.order.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @author: yp
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private SkuFeign skuFeign;

    @RequestMapping("/{id}")
    public Order findById(@PathVariable("id") String id){
        //1.远程调用mall-goods服务, 获得商品的数据
        Sku sku = skuFeign.findById("1");
        //2.封装到order返回
        Order order = new Order(id,2000,"zs",
                "小叶子",sku.getName(),sku.getPrice(),sku.getNum(),sku.getBrandName());
        return order;
    }

}
