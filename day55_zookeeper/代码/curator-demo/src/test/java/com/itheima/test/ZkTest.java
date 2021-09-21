package com.itheima.test;

import com.itheima.curator.CuratorApplication;
import com.itheima.curator.utils.CuratorUtil;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @author: yp
 */
@SpringBootTest(classes = CuratorApplication.class)
@RunWith(SpringRunner.class)
public class ZkTest {

    @Autowired
    private CuratorUtil curatorUtil;

    @Test
    //创建持久有序节点
    public void fun01() throws Exception {
        curatorUtil.createNode("/a", "a", CreateMode.PERSISTENT_SEQUENTIAL);
    }

    @Test
    //创建持久无序节点
    public void fun02() throws Exception {
        curatorUtil.createNode("/b", "b", CreateMode.PERSISTENT);
    }

    @Test
    //创建临时有序节点
    public void fun03() throws Exception {
        curatorUtil.createNode("/c", "c", CreateMode.EPHEMERAL_SEQUENTIAL);
    }

    @Test
    //创建临时无序节点
    public void fun04() throws Exception {
        curatorUtil.createNode("/d", "d", CreateMode.EPHEMERAL);
    }


    @Test
    //获得/b的节点数据
    public void fun05() throws Exception {
        String nodeData = curatorUtil.getNodeData("/b");
        System.out.println(nodeData);
    }

    @Test
    //更新/b的节点数据为bb
    public void fun06() throws Exception {
        curatorUtil.setNodeData("/b", "bb");
    }

    @Test
    //删除/b的节点
    public void fun07() throws Exception {
        curatorUtil.deleteNode("/b");
    }

}
