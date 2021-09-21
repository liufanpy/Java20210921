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
public class WatchTest {

    @Autowired
    private CuratorUtil curatorUtil;
    @Test
    //准备 /a  和/a/b 节点
    public void fun00() throws Exception {
        curatorUtil.createNode("/a", "a", CreateMode.PERSISTENT);
        curatorUtil.createNode("/a/b", "b", CreateMode.PERSISTENT);
    }

    @Test
    //改变节点, 测试监听
    public void fun01() throws Exception {
        //curatorUtil.setNodeData("/a","aaa");
        curatorUtil.setNodeData("/a/b","bbb");
    }

    @Test
    //只是监听/a的变化
    public void fun02() throws Exception {
        curatorUtil.addWatcherWithNodeCache("/a");
        while (true){
            Thread.sleep(3000);
        }
    }

    @Test
    //只是监听/a子节点变化
    public void fun03() throws Exception {
        curatorUtil.addWatcherWithChildCache("/a");
        while (true){
            Thread.sleep(3000);
        }
    }

    @Test
    //监听/a节点以及子节点变化
    public void fun04() throws Exception {
        curatorUtil.addWatcherWithTreeCache("/a");
        while (true){
            Thread.sleep(3000);
        }
    }


}
