package com.itheima.service.impl;

import com.itheima.mapper.BookMapper;
import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Value("${server.port}")
    private String port;


    @Override
    public void updateByZk(int id, int saleNum) {
        String methodName = Thread.currentThread().getStackTrace()[0].getMethodName();
        log.info(port+"执行了...");
        Book book = bookMapper.selectById(id);
        if (book.getStock() > 0) {
            bookMapper.updateByZk(id, saleNum);
        }
    }

}
