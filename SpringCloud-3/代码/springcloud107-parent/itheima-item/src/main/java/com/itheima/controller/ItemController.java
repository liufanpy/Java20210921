package com.itheima.controller;

import com.itheima.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/11 10:56
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/item")
//@CrossOrigin//基于CORS的协议 服务端支持跨域
//刷新bean
@RefreshScope
public class ItemController {

    @Value("${jdbc.url}")
    private String url;

    /**
     * 获取到配置中心中的key对应的值
     * @return
     */
    @GetMapping("/info")
    public String getInfo(){
        return url;
    }



    @GetMapping("/{itemId}")
    public OrderInfo getItemInfo(@PathVariable(name="itemId")String itemId, @RequestHeader(name="name",required = false)String name){
        System.out.println("啦啦啦 我获取到了头的名称为name的值:"+name);
        int i=1/0;

        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("==============1==========================");
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setItemId(itemId);
        orderInfo.setPrice(89L);
        orderInfo.setItemName("华为mate40");
        return orderInfo;
    }

}
