package com.itheima.demo9_复习;

import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * @Author：pengzhilin
 * @Date: 2020/8/28 12:02
 */
public class Test {
    /*
        面向对象阶段:
            类的创建:
                    public class 类名{
                        构造代码块
                        静态代码块
                        成员变量
                        构造方法
                        成员方法
                    }

            对象的创建和使用:
                对象的创建:  通过new调用构造方法
                对象的使用:
                    访问成员变量: 对象名.成员变量名
                    访问成员方法: 对象名.成员方法名(实参);
                        无返回值的方法: 对象名.成员方法名(实参);

                        有返回值的方法:
                            直接调用: 对象名.成员方法名(实参);
                            赋值调用: 数据类型 变量名 = 对象名.成员方法名(实参);
                            输出调用: System.out.println(对象名.成员方法名(实参));


            封装: 使用private修饰成员变量,提供set\get方法
            继承:
                继承的格式:
                    public class Zi extends Fu{}
                继承后成员的访问特点:
                    子类继承父类后,就拥有了父类的成员变量和成员方法

            多态:
                1.形成多态:
                    继承\实现
                    父类的引用指向子类的对象 \ 接口的引用指向实现类的对象
                    方法的重写

                2.多态后的成员访问特点:
                     除了非静态方法是编译看父类,运行看子类,其余都是看父类

                3.多态的好处:   形参多态,返回值多态,变量多态
                    父类的引用可以接收该父类对象或者其所有子类对象
                    接口的引用可以接收该接口的所有实现类对象

                4.多态的弊端解决:
                    向下转型
                    instanceof关键字
             super:
                访问父类的成员变量:super.父类成员变量名
                访问父类的成员方法: super.父类成员方法名(实参);
                访问父类的构造方法:
                        super();
                        super(实参);
             this:
                访问本类的成员变量:this.本类成员变量名
                访问本类的成员方法: this.本类成员方法名(实参);
                访问本类的构造方法:
                        this();
                        this(实参);

            模板设计模式:
                1.定义一个抽象类
                2.在抽象类中,能够确定的功能,就定义成通用模板(有方法体的方法)
                3.在抽象类中,不能够确定的功能,就定义成填充模板(没有方法体的方法)

            final: 表示不可变
                修饰类:被修饰的类不能被继承
                修饰方法:被修饰的方法不能被重写
                修饰变量:被修饰的变量只能赋值一次(常量)

            static:
                修饰成员变量:
                    格式: static 数据类型 变量名
                    特点: 可以被该类的所有对象共享一份数据
                    使用: 类名.变量名

                修饰成员方法:
                    格式: 修饰符 static 返回值类型 方法名(形参列表){}
                    使用: 类名.方法名(实参);

           代码块:
                构造代码块
                    格式: {}
                    位置: 类中,方法外
                    执行: 每次调用构造方法之前都会执行一次
                静态代码块
                    格式: static{}
                    位置: 类中,方法外
                    执行: 随着类的加载而执行,并且只执行一次
                局部代码块
                    格式: {}
                    位置: 方法中
                    执行: 按照方法的执行顺序,执行到局部代码块的时候就执行

            匿名内部类:
                本质:是一个类的匿名子类的对象
                本质:是一个接口的匿名实现类的对象
                格式:
                    new 类名\接口名(){
                        重写抽象方法
                    };

        常用API阶段:
            String类
            StringBuilder类
            ArrayList类
            Object
            Date
            DateFormat
            Calendar
            包装类
            BigDecimal
            BigInteger
             Math
            System
            Arrays

        集合阶段
            确定使用哪个集合:
                Collection单列集合:以单个单个的形式进行存储数据,是所有单列集合的顶层父接口
                    List:元素重复,元素有索引,元素存取有序
                        ArrayList:增删慢,查询快
                        LinkedList:增删快,查询慢
                    Set:元素唯一,元素无索引
                        HashSet:元素存取无序
                        LinkedHashSet:元素存取有序
                        TreeSet:可以对元素进行排序

                Map双列集合:以键值对的形式进行存储数据
                    特点:键唯一,值可重复,如果键重复了,值就会覆盖
                    HashMap:键值对元素存取无序
                    LinkedHashMap:键值对存取有序
                    TreeMap:可以对键进行排序,从而实现键值对排序

           使用集合:--->api
                1.构造方法----->使用集合的空参构造方法
                2.功能方法:
                    Collection集合的方法
                    List集合的方法
                    Map集合的方法
                    Collections工具类的方法

           HashSet如何保证元素唯一\HashMap如何保证键唯一:
                1.调用元素的hashCode方法,计算该元素的哈希值
                2.判断该哈希值对应的位置上是否有元素
                3.如果该位置上没有元素,那么就直接存储
                4.如果该位置上有元素,那么就产生了哈希冲突
                5.如果产生了哈希冲突,就得调用该元素的equals方法,与该位置上的所有元素进行一一比较:
                  如果比较完后,没有一个元素与该元素相同,那么就直接存储
                  如果比较完后,有任意一个元素与该元素相同,那么就不存储

        基本算法阶段
            排序算法: 冒泡,选择
            查找算法: 二分查找

        异常:
            处理异常:
                1.throws声明处理异常,如果程序运行的时候真的发生了异常,程序还是会终止
                2.try...catch捕获处理异常,无论程序运行的时候是否发生异常,程序都可以继续往下执行

        线程阶段
            如何创建线程并启动线程
                1.继承Thread类的方式
                2.实现Runnable即可的方式
                3.Runnable的匿名内部类的方式

            线程安全问题
                1.可见性问题:一个线程对共享变量的修改,其他线程不可见
                2.有序性问题:编译器对代码进行重排,造成结果数据有问题
                3.原子性问题:多个线程对共享变量的修改,产生了覆盖的效果 \  多个线程操作同一段代码,发生了抢占事件,造成数据不合法

            处理线程安全问题
                volatile: 处理可见性,有序性
                原子类: 处理共享变量的原子性问题
                锁: 处理原子性问题
                    synchronized同步锁
                        同步代码块
                            格式:
                                synchronized(锁对象){}
                            锁对象:
                                1.锁对象可以是任意类的对象
                                2.如果多条线程要实现同步,那么锁对象就需要一致

                        同步方法
                            格式: 使用synchronized修饰方法
                            锁对象:
                                非静态同步方法: 锁对象是this
                                静态同步方法:该方法所在类的字节码对象(类名.class)
                    Lock锁
                        加锁: lock()
                        释放锁: unlock()

             线程池:
                1.创建线程池    Executors.newFixedThreadPool()
                2.提交任务到线程池  submit(Runnable r)  \ submit(Callable c);
                3.销毁线程(一般不用)

            并发包\死锁------>了解
                    CopyOnWriteArrayList
                    CopyOnWriteArraySet
                    ConcurrentHashMap
                    CyclicBarrier
                    Semaphore
                    CountDownLatch
                    Exchanger

            线程状态: 6种线程状态,线程状态之间的切换
                新建
                可运行
                锁阻塞
                无限等待
                计时等待
                被终止


            等待唤醒机制
                实现等待唤醒机制的程序
                    1.使用锁对象调用wait()方法让线程进入无限等待
                    2.使用锁对象调用notify()或者notifyAll()方法唤醒无限等待线程
                    3.调用wait(),notify()或者notifyAll()方法的锁对象要一致

                分析等待唤醒机制的程序
                    1.线程的调度是抢占式
                    2.线程进入无限等待状态后,就会释放锁,和cpu,也不会再去争夺
                    3.在锁中线程进入计时等待,不会释放cpu和锁对象
                    4.线程从无限等待状态唤醒后,并且获得锁对象,会从进入无限等待的位置继续往下执行

        IO流阶段
            File类:
                获取功能
                创建和删除功能
                判断功能

           递归: 在方法的内部调用方法自己
                 出口,规律

           字节流:
                字节输入流:以字节为基本单位,进行读数据
                    FileInputStream,BufferedInputStream,ObjectInputStream

                字节输出流:以字节为基本单位,进行写数据
                    FileOutputStream,BufferedOutputStream,ObjectOutputStream,PrintStream

                api:
                    InputStream的api: read()   \   read(byte[] bys)  \   close()
                    OutputStream的api: write(int len)  \  write(byte[] bys,int off,int length)  \ close()

                    ObjectInputStream: readObject();
                    ObjectOutputStream: writeObject();
                    PrintStream: println()   print();
           字符流:
                字符输入流:以字符为基本单位,进行读数据
                    FileReader,BufferedReader,InputStreamReader

                字符输出流:义字符为基本单位,进行写数据
                    FileWriter,BufferedWriter,OutputStreamWriter

                api:
                    Reader的api: read()  \  read(char[] chs)
                    Writer的api: write(int c) \  write(char[] chs,int off,int len)  \ flush() close()


            属性集: Properties 类
                1.构造方法:  public Properties();
                2.成员方法:
                    load(InputStream is) 加载配置文件中的键值对数据
                    load(Reader is) 加载配置文件中的键值对数据

                    setProperty(String key,String value) 添加键值对
                    getProperty(String key) 根据键获取值
                    stringPropertyNames() 获取所有的键

                    store(OutputStream out,String comments) 把Properties对象中的键值对写回文件中
                    store(Writer out,String comments) 把Properties对象中的键值对写回文件中

            网络编程:
                Socket:
                    public Socket(String ip,int port) 创建Socket对象,指定要连接的服务器的ip地址和端口号
                    InputStream getInputStream(); 获取输入流,关联了连接通道
                    OutputStream getOutputStream(); 获取输出流,关联了连接通道
                    shutdownOutput() 禁用输出流
                    void close();  关闭Socket(通过Socket获得流也会关闭)
                ServerSocket:
                    public ServerSocket(int port) 创建ServerSocket对象,指定端口号
                    Socket accept(); 接收请求,建立连接

           NIO:  ByteBuffer    Channel  Selector
                ByteBuffer: 字节缓冲数组
                        position: 当前可以存数据或者取数据的位置
                        limit: 当前不可以存数据或者取数据的第一个位置
                        flip(): 把limit设置成当前的position,而position设置成0,取消标记
                        clear():  把limit设置成当前的capacity,而position设置成0,取消标记
                        put() 往字节缓冲数组中添加元素

               Channel: 通道,可以用来读和写数据
                    FileChannel
                    SocketChannel
                    ServerSocketChannel
                    DatagramChannel

                   api: open(), read读数据,write写数据

              Selector: 选择器
                使用选择器的步骤:
                 1.获取选择器  Selector.open();
                 2.通道要设置为非阻塞
                 3.把通道注册到选择器上  channel.register(选择器,监听的事件)
                 4.使用Selector选择器的方法:
                        select(): 等待客户端连接
                               阻塞问题:
                                    1.如果没有客户端连接,该方法就会处于阻塞状态
                                    2.如果有客户端连接,但没有处理该客户端的连接,那么该方法就不会进入阻塞状态
                                    3.如果有客户端连接,并且处理了该客户端的连接,那么该方法就还会进入阻塞状态

                        selectedKeys(): 获取已连接上的通道
                        keys(): 获取已注册的通道
           AIO:
                AsynchronousFileChannel
                AsynchronousSocketChannel
                AsynchronousServerSocketChannel
                AsynchronousDatagramChannel

                异步: 没有返回值,但有回调方法
                同步: 一定返回值

                accept() 同步的
                accept() 异步的
                read()   同步的
                read()   异步的
                write()  同步的
                write()  异步的
                ...

        JDK8新特性:
             Lambda表达式
                前提: 接口一定要是函数式接口(有且仅有一个抽象方法)
                使用:
                    1.确定是否可以使用Lambda表达式
                    2.如果可以使用,那么就先写()->{}
                    3.根据Lambda表达式的规则填充小括号和大括号中的内容
                省略规则:
                    1.小括号中的参数类型可以省略
                    2.如果小括号中只有一个参数,那么小括号也可以省略
                    3.如果大括号中只有一条语句,那么大括号,分号,return可以一起省略

             Stream流:
                1.获取流
                    使用Collection的stream()方法
                    使用Stream的of()方法
                2.常用方法
                    filter()
                    map()
                    skip()
                    limit()
                    concat()
                    count()
                    forEach()
                    ...
            方法引用:
                使用场景: 如果Lambda表达式大括号中的代码和某个方法的方法体一致,那么就可以使用方法引用直接把该方法引用过来替换Lambda表达式
                使用场景: 如果Lambda表达式大括号中就是调用某个方法,那么就可以使用方法引用直接把该方法引用过来替换Lambda表达式

                格式:
                    构造方法: 类名::new
                    静态方法: 类名::方法名
                    成员方法(有参数): 对象名::方法名
                    成员方法(无参数): 类名::方法名

        加强阶段
            Junit单元测试: @Test,@Before,@After,@BeforeClass,@AfterClass

            反射:
                1.获取class对象
                2.获取构造方法对象,并使用
                3.获取成员方法对象,并使用
                4.获取成员变量对象,并使用

           注解:  使用注解
                无属性的注解: @注解名
                有属性的注解: @注解名(属性名=属性值,...)

           动态代理: 使用动态代理生成一个代理对象,增强需要代理的方法

           xml: 书写xml,使用dom4j结合xpath路径解析xml

           正则表达式: 看懂正则表达式

           设计模式:
                单列设计模式
                多例设计模式
                工厂设计模式

           枚举: 定义枚举,使用枚举
     */
    public static void main(String[] args) {

    }
}
