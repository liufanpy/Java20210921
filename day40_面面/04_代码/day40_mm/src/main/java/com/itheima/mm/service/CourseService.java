package com.itheima.mm.service;

import com.itheima.mm.dao.CourseDao;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.User;
import com.itheima.mm.utils.DateUtils;
import com.itheima.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 学科的service
 */
public class CourseService {

    /**
     * 更新学科
     * @param course
     * @return
     * @throws IOException
     */
    public int update(Course course) throws IOException {

        //1. 得到sqlsession
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();

        //2. 得到代理对象
        CourseDao cd = session.getMapper(CourseDao.class);

        //3. 调用方法
        int row = cd.update(course);

        //4. 提交事务并且关闭session
        SqlSessionFactoryUtils.commitAndClose(session);

        //5. 返回结果
        return row ;
    }

    /**
     * 分页方法
     * @param bean   查询参数： {currentPage: 1, pageSize: 10, queryParams: {name:'' , status:''}}
     * @return  pageResult , 原因是前端页面使用的是elementui ，所以返回的数据内容要求契合elementui
     * @throws IOException
     */
    public PageResult findByPage(QueryPageBean bean ) throws IOException {

        //1. 获取sqlsession
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();

        //2. 得到代理
        CourseDao dao = session.getMapper(CourseDao.class);

        //3. 调用方法，准备数据。
        long total = dao.findCount(bean) ;  //学科表的总记录数，
        List rows = dao.findByPage(bean); // 当前页的集合数据。 1页， 10条

        //4. 创建PageResult，因为没有任何一张表查询之后，能够直接返回PageResult对象，所以需要我们手动创建
        PageResult pr = new PageResult(total , rows);

        //返回PageResult
        return pr;
    }

    /**
     * 添加学科
     * @param course
     * @return 影响的行数
     */
    public int add(Course course ) throws IOException {


        //1. 得到sqlsession
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();

        //2. 得到代理对象
        CourseDao dao = session.getMapper(CourseDao.class);

        //3. 调用方法
        int row = dao.add(course);

        //4. 提交事务并且关闭session
        SqlSessionFactoryUtils.commitAndClose(session);

        //5. 返回影响行数
        return  row ;
    }
}
