package com.itheima.goods.controller;

import com.itheima.goods.pojo.Sku;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @author: yp
 */
@RestController
@RequestMapping("/sku")
public class SkuController {

    @RequestMapping("/{id}")
    public Sku findById(@PathVariable("id") String id){
        System.out.println("SkuController...findById()");
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
