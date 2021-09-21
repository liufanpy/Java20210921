package com.itheima.mm.dao;

import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseDao {

    @Update("update t_course set name = #{name} , is_show = #{isShow}  where id = #{id}")
    int update(Course course);

    /**
     * 添加学科
     * @param course 学科对象
     * @return 影响的行数
     */
    int add(Course course);


    /**
     * 查询总记录数，但是这个总记录数不要直接认为就是查询学科表的所有记录总数，
     * 这个记录总数也是要受到查询条件(参数)的影响 。 这个和以前的直接无脑查询一张表的总记录数，不太一样！
     * @param bean
     * @return
     */
    long findCount(QueryPageBean bean);


    /**
     * 分页查询，查询这一页的集合数据。
     * @param bean
     * @return
     */
    List<Course> findByPage(QueryPageBean bean);
}
