package com.itheima.feign;

import com.itheima.pojo.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 声明式调用 ：
 * @author ljh
 * @version 1.0
 * @date 2021/3/13 08:54
 * @description 标题
 * @package com.itheima.feign
 */
@FeignClient(name="item",path = "/item",fallback = ItemFeignImpl.class)//name指定的值为：被调用方的微服务的服务名称：也就是spring.application.name指定的值
//@RequestMapping("/item")
// path = "/item"  推荐使用，效果等同@RequestMapping("/item")
public interface ItemFeign {

    /**
     * 接口的方法的要求：
     * 1.接口的方法路径 必须和 被调用方法的controller中的路径一致
     * 2.接口的方法的参数类型 和 个数和被调用方的controller 中的参数类型和个数一致
     * 3.接口的方法返回值类型 和 被调用方的controller 中的方法的返回值一致
     * 4.接口中的方法如果有参数 一定要加响应的注解@PathVariable,@requestBody @requestParam 以及配置里面的name属性. 高版本的feign 单个参数 就可以不用加
     */
    @GetMapping("/{itemId}")
    public OrderInfo getItemInfo(@PathVariable(name="itemId")String itemId);
/*
    @PostMapping("/save")
    public OrderInfo getX(@RequestBody OrderInfo info);

    @GetMapping("/info")
    public OrderInfo getX(@RequestParam(name="x")String x,@RequestParam(name="y") String y);*/

}
