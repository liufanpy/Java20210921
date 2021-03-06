package com.itheima.controller;

import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/updateByZk/{id}/{saleNum}")
    public void updateByZk(@PathVariable("id") Integer id, @PathVariable("saleNum") int saleNum) {
        bookService.updateByZk(id, saleNum);

    }

}
