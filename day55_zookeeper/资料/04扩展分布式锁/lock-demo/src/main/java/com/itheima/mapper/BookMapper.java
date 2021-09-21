package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface BookMapper extends BaseMapper<Book> {

    @Update("update tb_book set stock=stock-#{saleNum} where id = #{id}")
    void updateByZk(@Param("id") int id, @Param("saleNum") int saleNum);

}
