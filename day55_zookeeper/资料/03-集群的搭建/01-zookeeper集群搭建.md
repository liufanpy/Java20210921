## **搭建Zookeeper集群**

### **1.1 搭建要求**

真实的集群是需要部署在不同的服务器上的，但是在我们测试时同时启动很多个虚拟机内存会吃不消，所以我们通常会搭建**伪集群**，也就是把所有的服务都搭建在一台虚拟机上，用==端口进行区分==。

我们这里要求搭建一个三个节点的Zookeeper集群（伪集群）。

### **1.2 准备工作**

重新部署一台虚拟机作为我们搭建集群的测试服务器。

（1）安装JDK  【此步骤省略】。

（2）Zookeeper压缩包上传到服务器
（3）将Zookeeper解压 ，建立/usr/local/servers/zookeeper-cluster目录，将解压后的Zookeeper复制到以下三个目录

/usr/local/servers/zookeeper-cluster/zookeeper-1

/usr/local/servers/zookeeper-cluster/zookeeper-2

/usr/local/servers/zookeeper-cluster/zookeeper-3

```shell
[root@localhost ~]# mkdir /usr/local/servers/zookeeper-cluster
[root@localhost ~]# cp -r  zookeeper-3.4.13 /usr/local/servers/zookeeper-cluster/zookeeper-1
[root@localhost ~]# cp -r  zookeeper-3.4.13 /usr/local/servers/zookeeper-cluster/zookeeper-2
[root@localhost ~]# cp -r  zookeeper-3.4.13 /usr/local/servers/zookeeper-cluster/zookeeper-3
```

（4）创建data目录 ，并且将 conf下zoo_sample.cfg 文件改名为 zoo.cfg

```shell
mkdir /usr/local/servers/zookeeper-cluster/zookeeper-1/data
mkdir /usr/local/servers/zookeeper-cluster/zookeeper-2/data
mkdir /usr/local/servers/zookeeper-cluster/zookeeper-3/data

mv  /usr/local/servers/zookeeper-cluster/zookeeper-1/conf/zoo_sample.cfg  /usr/local/servers/zookeeper-cluster/zookeeper-1/conf/zoo.cfg
mv  /usr/local/servers/zookeeper-cluster/zookeeper-2/conf/zoo_sample.cfg  /usr/local/servers/zookeeper-cluster/zookeeper-2/conf/zoo.cfg
mv  /usr/local/servers/zookeeper-cluster/zookeeper-3/conf/zoo_sample.cfg  /usr/local/servers/zookeeper-cluster/zookeeper-3/conf/zoo.cfg
```






（5） 配置每一个Zookeeper 的dataDir 和 clientPort 分别为2181  2182  2183

修改/usr/local/servers/zookeeper-cluster/zookeeper-1/conf/zoo.cfg

```shell
vim /usr/local/servers/zookeeper-cluster/zookeeper-1/conf/zoo.cfg

clientPort=2181
dataDir=/usr/local/servers/zookeeper-cluster/zookeeper-1/data
```

修改/usr/local/servers/zookeeper-cluster/zookeeper-2/conf/zoo.cfg

```shell
vim /usr/local/servers/zookeeper-cluster/zookeeper-2/conf/zoo.cfg

clientPort=2182
dataDir=/usr/local/servers/zookeeper-cluster/zookeeper-2/data
```

修改/usr/local/servers/zookeeper-cluster/zookeeper-3/conf/zoo.cfg

```shell
vim /usr/local/servers/zookeeper-cluster/zookeeper-3/conf/zoo.cfg

clientPort=2183
dataDir=/usr/local/servers/zookeeper-cluster/zookeeper-3/data
```




### **1.3 配置集群**

（1）在每个zookeeper的 data 目录下创建一个 myid 文件，内容分别是1、2、3 。这个文件就是记录每个服务器的ID

```shell
echo 1 >/usr/local/servers/zookeeper-cluster/zookeeper-1/data/myid
echo 2 >/usr/local/servers/zookeeper-cluster/zookeeper-2/data/myid
echo 3 >/usr/local/servers/zookeeper-cluster/zookeeper-3/data/myid
```





（2）在每一个zookeeper 的 zoo.cfg配置客户端访问端口（clientPort）和集群服务器IP列表。

集群服务器IP列表如下

```shell
vim /usr/local/servers/zookeeper-cluster/zookeeper-1/conf/zoo.cfg
vim /usr/local/servers/zookeeper-cluster/zookeeper-2/conf/zoo.cfg
vim /usr/local/servers/zookeeper-cluster/zookeeper-3/conf/zoo.cfg

server.1=192.168.211.150:2881:3881
server.2=192.168.211.150:2882:3882
server.3=192.168.211.150:2883:3883
```

解释：server.服务器ID=服务器IP地址：服务器之间通信端口：服务器之间投票选举端口



 

### **1.4 启动集群**

启动集群就是分别启动每个实例。

```shell
/usr/local/servers/zookeeper-cluster/zookeeper-1/bin/zkServer.sh start
/usr/local/servers/zookeeper-cluster/zookeeper-2/bin/zkServer.sh start
/usr/local/servers/zookeeper-cluster/zookeeper-3/bin/zkServer.sh start
```



![img](img/wps11.jpg) 

启动后我们查询一下每个实例的运行状态

```shell
/usr/local/servers/zookeeper-cluster/zookeeper-1/bin/zkServer.sh status
/usr/local/servers/zookeeper-cluster/zookeeper-2/bin/zkServer.sh status
/usr/local/servers/zookeeper-cluster/zookeeper-3/bin/zkServer.sh status
```



先查询第一个服务

![img](img\wps12.jpg) 

Mode为follower表示是**跟随者**（从）

再查询第二个服务Mod 为leader表示是**领导者**（主）

![img](img/\wps13.jpg) 

查询第三个为跟随者（从）

![img](img/\wps14.jpg) 

### 1.5集群启动脚本

+ zk_start.sh

```
sh /usr/local/servers/zookeeper-cluster/zookeeper-1/bin/zkServer.sh start
sh /usr/local/servers/zookeeper-cluster/zookeeper-2/bin/zkServer.sh start
sh /usr/local/servers/zookeeper-cluster/zookeeper-3/bin/zkServer.sh start
```

+ zk_stop.sh

```
sh /usr/local/servers/zookeeper-cluster/zookeeper-1/bin/zkServer.sh stop
sh /usr/local/servers/zookeeper-cluster/zookeeper-2/bin/zkServer.sh stop
sh /usr/local/servers/zookeeper-cluster/zookeeper-3/bin/zkServer.sh stop
```

+ zk_status.sh

```
sh /usr/local/servers/zookeeper-cluster/zookeeper-1/bin/zkServer.sh status
sh /usr/local/servers/zookeeper-cluster/zookeeper-2/bin/zkServer.sh status
sh /usr/local/servers/zookeeper-cluster/zookeeper-3/bin/zkServer.sh status
```

