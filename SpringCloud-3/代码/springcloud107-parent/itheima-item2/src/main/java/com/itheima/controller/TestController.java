package com.itheima.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/14 10:42
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello Sentinel";
    }

    //read
    @GetMapping("/hello1")
    public String hello1(){
        return "Hello Sentinel1";
    }

    //writer
    @GetMapping("/hello2")
    public String hello2(){
        return "Hello Sentinel2";
    }

    @GetMapping("/hello3")
    public String hello3(){
        return "Hello Sentinel3";
    }
    @GetMapping("/hello4")
    public String hello4(){
        return "Hello Sentinel4";
    }

    @GetMapping("/hello5")
    public String hello5(){
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello Sentinel5";
    }
    @GetMapping("/hello6")
    public String hello6(){
        int i=1/0;
        return "Hello Sentinel6";
    }

    @GetMapping("/hello7")
    public String hello7(){
        int i=1/0;
        return "Hello Sentinel7";
    }

    @GetMapping("/hello8")
    /**
     * userId 指定的是当前的用户的ID
     * skuId 指定的你抢购的商品的ID
     */
    @SentinelResource(value="hello8",blockHandler = "handlerException",fallback = "fallbacks")
    public String hello8(@RequestParam(required = false)String userId, @RequestParam(required = false)String skuId){
        int i=1/0;
       return "Hello Sentinel8";
    }


    //掌握
    //降级的方法 ： 标识一旦触发了条件 可以调用该方法 返回给前端而不是使用默认的
    //触发了 流控规则 自动就会抛出BlockException ,此时该方法 用于处理该异常的。
    public String handlerException(String userId, String skuId, BlockException e){
        return "一旦报错 就返回该默认的数据";
    }

    //返回的数据类型 和 方法参数类型和个数和原方法一致
    public String fallbacks(String userId, String skuId){
        return "一旦业务出现了异常，就返回默认的兜底的数据";
    }


}
