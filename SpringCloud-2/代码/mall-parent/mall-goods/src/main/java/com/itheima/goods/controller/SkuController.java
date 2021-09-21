package com.itheima.goods.controller;

import com.itheima.goods.pojo.Sku;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @author: yp
 */
@RestController
@RequestMapping("/sku")
@RefreshScope
public class SkuController {

    @Value("${server.port}")
    private String port;

    @Value("${info}")
    private String info;

    @RequestMapping("/{id}")
    public Sku findById(@PathVariable("id") String id){
        System.out.println("SkuController...findById()"+port);
        System.out.println("info="+info);
        //1.模拟调用service,Dao
        Sku sku = new Sku(id, "华为手机", 2000, 2, "华为", "1");
        return sku;
    }

    @PostMapping
    public void add(@RequestBody  Sku sku){

    }

    @RequestMapping("/findAll")
    public List<Sku> findAll(){
        return null;
    }




}
