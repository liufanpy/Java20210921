package com.itheima.controller;

import com.itheima.pojo.OrderInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/11 10:56
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping("/{itemId}")
    public OrderInfo getItemInfo(@PathVariable(name="itemId")String itemId){
        System.out.println("==============2==========================");
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setItemId(itemId);
        orderInfo.setPrice(89L);
        orderInfo.setItemName("华为mate40");
        return orderInfo;
    }


}
