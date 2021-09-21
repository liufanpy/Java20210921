package com.itheima.curator.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Logger;


@Slf4j
public class CuratorUtil {

    // 一个zookeeper集群只需要一个 client。劲量保证单例
    private static CuratorFramework client;
    // zk 服务端集群地址
    //private String connectString = "192.168.133.129:2181,192.168.133.129:2182,192.168.133.129:2183";
    private String connectString = "127.0.0.1:2181";

    // session 超时时间
    private int timeOut = 60000;

    // zkclient 重试间隔时间
    private int baseSleepTimeMs = 5000;

    //zkclient 重试次数
    private int retryCount = 5;

    public CuratorUtil() {
        this(null);
    }

    public CuratorUtil(String path) {
        init(path);
    }


    /**
     * 初始化
     * @param namespace
     */
    public void init(String namespace) {
        if (null == client) {
            synchronized (CuratorUtil.this) {
                if (null == client) {
                    client = CuratorFrameworkFactory
                            .builder()
                            .connectString(connectString)
                            .sessionTimeoutMs(timeOut)
                            .retryPolicy(new ExponentialBackoffRetry(baseSleepTimeMs, retryCount))
                            .namespace(namespace)
                            .build();
                    client.start();
                    log.info("client is created at ================== {}", LocalDateTime.now());
                }
            }
        }
    }

    /**
     * 关闭连接
     */
    public void closeConnection() {
        if (null != client) {
            client.close();
        }
    }

    /**
     * 创建节点
     * @param path
     * @param createMode
     * @return
     * @throws Exception
     */
    public String createNode(String path,CreateMode createMode) throws Exception {
        if (null == client) {
            throw new RuntimeException("there is not connect to zkServer...");
        }
        String node = client
                .create()
                .creatingParentsIfNeeded()
                .withMode(createMode)
                .forPath(path);

        log.info("create node : {}", node);
        return node;
    }

    /**
     * 创建节点
     * @param path
     * @param value
     * @param createMode
     * @return
     * @throws Exception
     */
    public String createNode(String path, String value,CreateMode createMode) throws Exception {
        if (null == client) {
            throw new RuntimeException("there is not connect to zkServer...");
        }
        String node = client
                .create()
                .creatingParentsIfNeeded()
                .withMode(createMode)
                .forPath(path, value.getBytes());

        log.info("create node : {}", node);
        return node;
    }


    /**
     * 删除节点
     * @param path
     * @throws Exception
     */
    public void deleteNode(String path) throws Exception {
        if (null == client) {
            throw new RuntimeException("there is not connect to zkServer...");
        }
        client
                .delete()
                .deletingChildrenIfNeeded()
                .forPath(path);
        log.info("{} is deleted ", path);
    }


    /**
     * 获得节点
     * @param path
     * @return
     * @throws Exception
     */
    public String getNodeData(String path) throws Exception {
        if (null == client) {
            throw new RuntimeException("there is not connect to zkServer...");
        }
        Stat stat = new Stat();
        byte[] bytes = client.getData().storingStatIn(stat).forPath(path);
        log.info("{} data is : {}", path, new String(bytes));
        log.info("current stat version is {}, createTime is {}", stat.getVersion(), stat.getCtime());
        return new String(bytes);
    }


    /**
     * 更新节点
     * @param path
     * @param value
     * @throws Exception
     */
    public void setNodeData(String path,String value) throws Exception {
        if (null == client) {
            throw new RuntimeException("there is not connect to zkServer...");
        }
        Stat stat = client.checkExists().forPath(path);
        if(null == stat){
            log.info(String.format("{} Znode is not exists",path));
            throw new RuntimeException(String.format("{} Znode is not exists",path));
        }
        String nodeData = getNodeData(path);
        client.setData().withVersion(stat.getVersion()).forPath(path, value.getBytes());
        log.info("{} Znode data is set. old vaule is {}, new data is {}",path,nodeData,value);
    }


    /**
     * 创建 给定节点的监听事件  监听一个节点的更新和创建事件(不包括删除)
     * @param path
     * @throws Exception
     */
    public void addWatcherWithNodeCache(String path) throws Exception {
        if (null == client) {
            throw new RuntimeException("there is not connect to zkServer...");
        }
        // dataIsCompressed if true, data in the path is compressed
        NodeCache nodeCache = new NodeCache(client, path,false);
        NodeCacheListener listener = () -> {
            ChildData currentData = nodeCache.getCurrentData();
            log.info("{} Znode data is chagnge,new data is ---  {}", currentData.getPath(), new String(currentData.getData()));
        };
        nodeCache.getListenable().addListener(listener);
        nodeCache.start();
    }




    /**
     * 监听给定节点下的子节点的创建、删除、更新
     * @param path
     * @throws Exception
     */
    public void addWatcherWithChildCache(String path) throws Exception {
        if (null == client) {
            throw new RuntimeException("there is not connect to zkServer...");
        }
        //cacheData if true, node contents are cached in addition to the stat
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client,path,false);
        PathChildrenCacheListener listener = (client, event) -> {
            log.info("event path is --{} ,event type is {}" , event.getData().getPath(), event.getType());
        };
        pathChildrenCache.getListenable().addListener(listener);
        // StartMode : NORMAL  BUILD_INITIAL_CACHE  POST_INITIALIZED_EVENT
        pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);
    }


    /**
     * 听 给定节点的创建、更新（不包括删除） 以及 该节点下的子节点的创建、删除、更新动作。
     * @param path
     * @throws Exception
     */
    public void addWatcherWithTreeCache(String path) throws Exception {
        if (null == client) {
            throw new RuntimeException("there is not connect to zkServer...");
        }
        TreeCache treeCache = new TreeCache(client, path);

        TreeCacheListener listener = (client, event) -> {
            log.info("节点路径 --{} ,节点事件类型: {} , 节点值为: {}" , Objects.nonNull(event.getData()) ? event.getData().getPath() : "无数据", event.getType(),Objects.nonNull(event.getData()) ? new String(treeCache.getCurrentData(event.getData().getPath()).getData()) : "无数据");
        };
        treeCache.getListenable().addListener(listener);
        treeCache.start();
    }



}