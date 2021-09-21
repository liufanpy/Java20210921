package com.itheima.controller;

import com.itheima.bean.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService service;

    //查询所有的
    @RequestMapping("/list")
    public String list(Model model){
        List<Items> list = service.findAll();

        //装到model里面
        model.addAttribute("items" , list);

        //返回页面
        return "items";
    }

    /**
     * 添加 ，添加完成之后，跳转到list方法去，查询出来所有的内容，然后再到items页面去显示。
     * @param items
     * @return
     */
    @RequestMapping("/save")
    public String save(Items items){
        service.save(items);
        return "redirect:/items/list";
    }
}
