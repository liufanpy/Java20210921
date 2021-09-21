package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {

    //注入dao
    @Autowired
    private CheckGroupDao dao ;

    /**
     * 查询所有的检查组
     * @return
     */
    @Override
    public List<CheckGroup> findAll() {
        return dao.findAll();
    }

    /**
     * 新增检查组
     *      1. 检查组包含两份数据，一份是自己的检查组的基本信息，一份是检查组使用了哪些检查项
     *      2. 这两份数据需要存到两张不同的表： t_checkgroup & t_checkgroup_checkitem
     *          2.1 先把基本的信息存入到检查组的表里面 ：t_checkgroup
     *          2.2 再把这个检查组用到了哪些检查项，把这些记录保存到中间表 ：  t_checkgroup_checkitem
     *      3. 一定要先往t_checkgroup这张表添加数据，这样子我们才能得到主键的返回，才能知道这个检查组的
     *          id值是多少。有了id值，才能去往中间表里面添加记录。
     *
     * @param checkGroup  检查组的基本信息
     * @param checkitemIds 检查组包含的检查项的id值
     * @return
     */
    @Override
    public int add(CheckGroup checkGroup, int[] checkitemIds) {

        //1. 往t_checkgroup 添加基本信息
        int row = dao.add(checkGroup);

        /*
            2. 往t_checkgroup_checkitem添加检查项信息
                2.1 由于从页面过来的时候，这个检查组可能选择了很多的检查项，
                    所以这里要遍历出来每一个检查项
                2.2 遍历一次，就往中间表里面添加一条记录。
                    checkitemIds = 【28,29,30】;
         */
        //只有主表（检查组的表）添加成功了之后，再去考虑添加从表（中间表）的数据
        int row2 = 0 ;
        if(row > 0 ){
            for (int checkitemId : checkitemIds) {
                row2 += dao.addItem(checkGroup.getId() , checkitemId );
            }
        }

        //当所有的操作都成功的时候，就返回1， 否则就返回 0 。
        return (row > 0 && row2 == checkitemIds.length) ?  1 :  0 ;
    }

    /**
     * 更新检查组
     * @param checkGroup  检查组的基本信息
     * @param checkitemIds 检查组包含的检查项的id值
     * @return
     */
    @Override
    public int update(CheckGroup checkGroup, int[] checkitemIds) {

        //1. 检查组的基本信息是位于： t_checkgroup表
        int row1 = dao.update(checkGroup);

        /*
            2. 检查组包含的检查项信息是位于： t_checkgroup_checkitem表
                2.1 要想更新检查组包含哪些检查项，这个看似简单的工作，其实背后还是有点复杂的。
                2.2 检查组包含的检查项，可以有，也可以没有，也可以多，也可以少，甚至可以不变！
                2.3 对于后台来说，怎么知道要改哪个检查项呢？ 要去掉还是增加？还是不变？
                2.4 中间表里面只有两个列，一个检查组的id值， 一个是检查项的id值。
            3. 其实对于检查组来说，它只需要在数据库（中间表）里面表示出来这个检查组有多少个检查项即可
                我们怎么折腾都可以，只要结果是对的就行。
                3.1 把这个检查组包含的所有检查项的记录都删除掉。

                3.2 再重新把这个检查组包含的检查项记录给添加进来。
         */

        //2. 使用检查组的id去中间表删除掉这个检查组的所有记录
        dao.deleteItemsById(checkGroup.getId());

        //3. 再把检查项添加进去。 要考虑检查组原来没有任何的检查项，现在也没有任何的检查项的情况
        int row3 = 0 ;
        if(checkitemIds != null && checkitemIds.length >0 ){
            //遍历所有的检查项id, 然后添加到表里面
            for (int checkitemId : checkitemIds) {
                row3 += dao.addItem(checkGroup.getId() ,checkitemId );
            }
        }

        return (row1 >0 && row3 == checkitemIds.length) ? 1 : 0;
    }

    /**
     * 分页实现
     *  1. service的返回值一般都是从dao返回的。
     *  2. 但是这里要返回PageResult，dao是无法返回PageResult类型的
     *  3. 所以我们要自己手动封装PageResult
     * @param bean
     * @return
     */
    @Override
    public PageResult<CheckGroup> findPage(QueryPageBean bean) {

        //0. 告诉分页插件，想要查询第几页，每页查询多少条
        PageHelper.startPage(bean.getCurrentPage(), bean.getPageSize() );


        //1. 调用dao 返回数据
        Page<CheckGroup> page = dao.findPage(bean);

        //2. 定义数据
        long total = page.getTotal() ; //总的记录数
        List<CheckGroup> rows = page.getResult(); // 当前这一页的集合数据

        //3. 返回
        return new PageResult<CheckGroup>(total , rows );
    }

    @Override
    public List<Integer> findItemsById(int id) {
        return dao.findItemsById(id);
    }
}
