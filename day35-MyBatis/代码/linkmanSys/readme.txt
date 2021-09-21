1.将普通的javaweb项目改造成maven项目
    注意：将原来javaweb项目中的jar交由maven进行管理
    注意：Maven项目自动生成web.xml版本比较低  不支持el表达式的解析，需要替换成高版本的web.xml
2.使用MyBatis改造联系人案例
    jdbc --> DBUtils --> MyBatis
    需要修改：dao
3.使用MyBatis改造的顺序
    1.添加配置文件 mybatis-config.xml 、jdbc.properties、log4j.properties
    2.添加SqlSessionFactoryUtils工具类
    3.改造dao层 将原来操作数据库的dao类改成到dao接口
    4.针对具体的操作 使用注解完成
    5.改造service层  完成对dao接口的调用实现操作数据库
4.tomcat发布项目无法正常启动的情况
    1.tomcat端口号占用
        查看端口号占用情况：netstat -ano | findstr "8080"
        解除端口占用：taskkill -PID 16648 -F
    2.多个Servlet、Filter共用一个请求路径
        eg：名为 [com.itheima.web.LinkManServlet]和 [com.itheima.web.LinkManServletOri] 的servlet不能映射为一个url模式(url-pattern) [/linkMan]
    3.Servlet完全路径匹配时，不以/开头
        eg：Caused by: java.lang.IllegalArgumentException: servlet映射中的<url pattern>[linkMan]无效
