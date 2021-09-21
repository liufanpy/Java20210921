package com.itheima.feign;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.itheima.pojo.OrderInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ItemFeignImpl implements ItemFeign {
    //该方法就是默认的兜底的方法 一旦feign调用出现异常 错误，自动的调用并返回
    @Override
    public OrderInfo getItemInfo(@PathVariable(name="itemId")String itemId){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setItemName("黑马107期制造的默认手机");
        orderInfo.setPrice(1999L);
        orderInfo.setItemId("SMR:00001");
        return orderInfo;
    }
}