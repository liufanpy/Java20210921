package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
    检查组的控制器
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {

    @Autowired
    private CheckGroupService cs ;

    /**
     * 查询所有的检查组
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<CheckGroup> list = cs.findAll();
        return new Result (true , MessageConstant.QUERY_CHECKGROUP_SUCCESS , list);
    }

    /**
     * 更新检查组
     * @param checkGroup 检查组的基本信息
     * @param checkitemIds 检查组包含的检查项的id
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody CheckGroup checkGroup , int [] checkitemIds){

        //1. 调用service
        int row = cs.update(checkGroup, checkitemIds);

        //2. 判断
        Result result = null;
        if(row > 0 ){
            result = new Result(true , MessageConstant.EDIT_CHECKGROUP_SUCCESS);
        }else{
            result = new Result(false , MessageConstant.EDIT_CHECKGROUP_FAIL);
        }
        return result;
    }

    /**
     * 根据检查组的id，查询这个检查组都包含了哪些检查项
     * @param id 检查组的id
     * @return
     */
    @RequestMapping("/findItemsById")
    public Result findItemsById(int id){

        //1. 调用Service
        List<Integer> list = cs.findItemsById(id);

        //2. 返回
        return new Result(true , MessageConstant.QUERY_CHECKITEM_SUCCESS , list);

    }


    /**
     * 分页处理
     * @param bean
     * @return
     */
    @RequestMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean bean){
        //1. 调用service
        PageResult<CheckGroup> pageResult = cs.findPage(bean);

        //2. 封装数据返回
        return new Result(true , MessageConstant.QUERY_CHECKGROUP_SUCCESS , pageResult);
    }

    /**
     * 添加检查组
     * @param checkGroup
     * @param checkitemIds
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup , int [] checkitemIds){
        System.out.println(checkGroup);
        System.out.println(Arrays.toString(checkitemIds));

        //1. 调用Service干活
        int row = cs.add(checkGroup, checkitemIds);

        //2. 判定
        Result result = null;
        if(row >0 ){
            result = new Result(true , MessageConstant.ADD_CHECKGROUP_SUCCESS);
        }else{
            result = new Result(false , MessageConstant.ADD_CHECKGROUP_FAIL);
        }

        return result;
    }
}
