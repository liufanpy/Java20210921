package com.itheima.service.impl;

import com.itheima.mapper.BookMapper;
import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Value("${server.port}")
    private String port;

    //@Autowired
    //private ReentrantLock reentrantLock;

    //注入分布式锁对象
    @Autowired
    private InterProcessMutex interProcessMutex;

    @Override
    public void updateByZk(int id, int saleNum) {
        try {
            //reentrantLock.lock();//加锁
            interProcessMutex.acquire(); //加锁
            log.info(port+"执行了...");
            Book book = bookMapper.selectById(id);
            if (book.getStock() > 0) {
                bookMapper.updateByZk(id, saleNum);
            }
            //reentrantLock.unlock();//释放锁
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                interProcessMutex.release(); //不管是否有异常 都应该释放锁
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
