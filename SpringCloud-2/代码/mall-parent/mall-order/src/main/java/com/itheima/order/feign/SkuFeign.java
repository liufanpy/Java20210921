package com.itheima.order.feign;

import com.itheima.order.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description:
 * @author: yp
 */
@FeignClient(value = "mall-goods",path = "/sku") //属性值: 生产者微服务注册到注册中心的服务名字
public interface SkuFeign {

    @RequestMapping("/{id}")
    Sku findById(@PathVariable("id") String id);


    @RequestMapping("/findAll")
    List<Sku> findAll();

    //xxxx


}
