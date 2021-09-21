package com.itheima.controller;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.itheima.feign.ItemFeign;
import com.itheima.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/11 10:51
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery;


    @Autowired
    private ItemFeign itemFeign;

    /**
     * 根据用户名获取订单的数据（包含商品）
     *
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public OrderInfo getOrderInfo(@PathVariable(name = "username") String username) throws Exception {
        //1.需要先根据用户名去订单表获取到获取订单的数据（订单的ID 用户名）
        String orderId = "orderId:001";
        String itemId = "SN:0001";
        System.out.println("模拟获取到了订单的数据拉：====="+username+":订单的ID："+orderId);
        //2.需要【使用restTemplate 远程调用 商品微服务 获取到对应的商品的数据】
            //2.1 在商品微服务中写一个controller 接收请求 获取到商品数据 返回给 订单微服务
            //2.2 使用restTempalte 远程调用
                //2.2.1 创建restTemplate对象 交给spring容器管理
                //2.2.2 使用API 发送 GET 请求 拿到到是JSON数据 --》转成POJO
            //参数1:指定请求的路径
            //参数2：指定响应的数据类型字节码对象（他内部会自动的将JSON转成POJO）

        //OrderInfo orderInfo = restTemplate.getForObject("http://localhost:18081/item/" + itemId, OrderInfo.class);


        //=========================================nacos================
        //1 需要动态的从注册中心获取item微服务的ip地址和端口（1.1 注入一个类 使用提供的API ）
        //参数指定的是服务名
       /* List<ServiceInstance> item = nacosServiceDiscovery.getInstances("item");
        ServiceInstance serviceInstance = item.get(0);
        OrderInfo orderInfo = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/item/" + itemId, OrderInfo.class);
        */

        // ======================================ribbon 结合nacos
        //OrderInfo orderInfo = restTemplate.getForObject("http://item/item/" + itemId, OrderInfo.class);

        OrderInfo orderInfo = itemFeign.getItemInfo(itemId);


        //========使用feign======
        //3.合并封装 POJO
        orderInfo.setOrderId(orderId);
        orderInfo.setUsername(username);
        orderInfo.setItemId(itemId);
        //4.返回POJO
        return orderInfo;
    }

    //controller
}
