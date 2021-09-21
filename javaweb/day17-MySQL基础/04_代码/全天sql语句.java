-- 调整字体大小: ctrl+shift+鼠标滚轮  或者 ctrl+鼠标滚轮 
-- 注释: ctrl + /
-- ----------------------------操作数据库--------------------------------------
-- 语法:
-- 增--创建数据库: create database 数据库 [character set 字符集][collect 校对规则];   []表示可选
-- 查--查询数据库: show databases;查询所有的数据库     show create database 数据库名;查询指定数据库的定义结构
-- 改--修改数据库: alter database 数据库名 character set 字符集; 注意:1.不能修改数据库名;  2.是utf8,不是utf-8
-- 删--删除数据库: drop  database 数据库名;
-- 其他操作:  use 数据库名; 切换数据库     select database();查询目前选中的数据库

-- 练习:创建一个数据库,名字为day17_1,编码为utf8
create database day17_1;

-- 练习:创建一个数据库,名字为day17_2,编码为gbk
create database day17_2 character set gbk;

-- 练习:查询所有的校对规则
show collation;

-- 练习:查询所有的数据库
show databases;

-- 练习:查询day17_1数据库的定义结构
show create database day17_1;

-- 练习:查询day17_2数据库的定义结构
show create database day17_2;

-- 练习:修改day17_2数据库的编码为utf8
alter database day17_2 character set utf8;

-- 练习:删除day17_2这个数据库
drop database day17_2;

-- 练习: 选中day17_1数据库
use day17_1;

-- 练习: 查询目前选中的数据库
 select database();


-- --------------------------------------对表的操作----------------------------------------
-- 语法: 
-- 	create table 表名(
				字段名 字段类型 约束,
				字段名 字段类型 约束,
				....
				字段名 字段类型 约束
-- );
-- 字段类型: int,bigint,float,double,varchar(size),date,datetime
-- 字段约束: not null, unique,primary key auto_increment
-- 练习:创建一张学生表(含有id字段,姓名字段,性别字段. id为主键自动增长)
create table student(
	id int primary key auto_increment,
    name varchar(40),
    sex varchar(25)
);

-- 查看表:
-- 查看所有的表:show tables;
-- 查看表的定义结构:desc  表名；
-- 练习: 查询day17_1数据库中所有表
show tables;

-- 练习: 查询student表的定义结构
desc student;


-- 修改表:
-- 增加一列:         alter table 表名 add 字段名 字段类型  字段约束;
-- 修改字段类型约束: alter table 表名 modify 字段名 字段类型  字段约束;
-- 修改字段名:       alter table 表名 change 旧字段名 新字段名 字段类型  字段约束;
-- 删除字段:         alter table 表名 drop 字段名;
-- 修改表名          rename table 旧表名 to 新表名;
-- 练习: 给学生表增加一个grade字段
alter table student add grade varchar(40) not null;

-- 练习: 给学生表的sex字段改成字符串类型 
alter table student modify sex varchar(20) not null;

-- 练习: 给学生表的grade字段修改成class字段
alter table student change grade class varchar(40) ;

-- 练习: 把class字段删除
alter table student drop class;

-- 练习: 把学生表修改成老师表(了解)
rename table student to teacher;


-- 删除表:drop table 表名；
-- 练习:删除teacher表
drop table teacher;

-- -------------------------------------操作记录-----------------------------------------
-- 准备工作: 创建一张商品表(商品id,商品名称,商品价格,商品数量.) 
create table product(
	pid int primary key auto_increment,  -- 只有设置了auto_increment id列才可以赋值为null
	pname varchar(40) not null,
	price double,
	num int
);

-- 插入记录:
-- 方式一:指定字段插入---> insert into 表名(字段名1,字段名2,...) values(值1,值2,...);
-- 方式二:默认所有列插入-> insert into 表名 values(值1,值2,...);
-- 注意:
-- - 插入特定的列:没有赋值的列,系统自动赋为null(前提是当前列没有设置not null 约束)
-- - 字段名与值的类型、个数、顺序要一一对应。
-- - 值不要超出列定义的长度。
-- - 插入的日期和字符串，使用引号括起来。 
-- - 默认所有列插入,values里面必须给表中每一个字段赋值,一般主键给一个null
-- 练习: 指定pname,price列插入记录
insert into product(pname,price) values("Mac",8888.9);

-- 练习: 指定price列插入记录
insert into product(price) values(8888.9);-- 报错,因为pname字段设置了非空约束,不能赋值为null

-- 练习: 指定所有列插入记录
insert into product values(null,'Macbook',9999.9,5);

-- 批量插入数据
insert into product values(null,'苹果电脑',18000.0,10);
insert into product values(null,'华为5G手机',30000,20);
insert into product values(null,'小米手机',1800,30);
insert into product values(null,'iPhonex',8000,10);
insert into product values(null,'苹果电脑',8000,100);
insert into product values(null,'iPhone7',6000,200);
insert into product values(null,'iPhone6s',4000,1000);
insert into product values(null,'iPhone6',3500,100);
insert into product values(null,'iPhone5s',3000,100);
insert into product values(null,'方便面',4.5,1000);
insert into product values(null,'咖啡',11,200); 
insert into product values(null,'矿泉水',3,500);


-- 修改列的语法: update 表名 set 列名 = 值, 列名 =值,... [where 条件];
-- - 将所有商品的价格修改为5000元
update product set price = 5000;

-- - 将商品名是Mac的价格修改为18000元
update product set price = 18000 where pname='Mac';

-- - 将商品名是Mac的价格修改为17000,数量修改为5
update product set price = 17000,num=5 where pname='Mac';

-- - 将商品名是方便面的商品的价格在原有基础上增加2元
update product set price = price + 2  where pname="方便面";


-- 删除表:
-- 方式一: delete from 表 【where 条件】;--可以删除表中所有记录,也可以指定记录删除
-- 方式二: truncate table 表;----->删除表中所有记录
-- - 删除表中名称为’Mac’的记录
delete from product where pname='Mac';

-- - 删除价格小于5001的商品记录
delete from product where price < 5001;

-- - 删除表中的所有记录
delete from product;-- 一条一条记录的删除
truncate table product;-- 直接删除表,然后创建一张和之前结构一样的空表


-- ---------------------------------------基本查询------------------------------------------------
-- 查询表中所有列的数据: select * from 表名;
-- 查询表中指定列的数据: select 列名,列名,... from 表名;
-- 去重查询: select distinct 列名 from 表名;  注意: distinct前面不能有字段名
-- 取别名查询: select 列名 as 别名,列名 as 别名,... from 表名 as 别名;  注意: as可以省略
-- 取别名查询: select 列名  别名,列名 别名,... from 表名  别名;  注意: as可以省略
-- 条件查询: select ... from 表名 where 条件;
-- 条件: 
-- 比较运算符: >,>=,<,<=,=,<>(!=)
-- 逻辑运算符: and,or,not
-- 模糊查询:  like 规则;      %:表示匹配任意个字符, _表示匹配一个字符    eg: '%张%','张%','张__',...
-- 范围查询:  between ... and ...
-- 范围查询:  in(值1,值2,值3,...)
-- 列运算查询: select 列运算(+-*/) from 表名

-- 练习:查询product表中所有的数据
select * from product;
-- 练习:查询pid,pname,price列中的数据
select pid,pname,price from product;
-- 练习:去重查询商品价格
select distinct price from product;
select pname,distinct price from product;-- 报错,distinct前面不能有字段名
-- 练习:查询pid,pname,price列中的数据并对列取别名
select pid as 编号,pname as 商品名称,price as 商品价格 from product as p;
select pid  编号,pname  商品名称,price  商品价格 from product  p;
-- 练习:查询价格大于5000的商品信息
select * from product where price > 5000;
-- 练习:查询价格大于5000的商品并且数量大于10的商品信息
select * from product where price > 5000 and num > 10;
select * from product where not(price > 5000);
-- 练习: 查询商品名称含有'iPh'的商品信息
select * from product where pname like '%iPh%';
-- 练习:查询商品价格在3000到8000之间的商品信息,包含3000,8000
select * from product where price between 3000 and 8000;
select * from product where price >= 3000 and price <= 8000;
-- 练习:查询pid为1,3,5,7,9,19的商品信息
select * from product where pid = 1 or pid = 3 or pid = 5 or pid = 7 or pid = 9 or pid = 19;
select * from product where pid in(1,3,5,7,9,19);
-- 练习: 查询每种商品需要的总价
select pname 商品名称,price*num 总价 from product;

-- 基本查询练习
-- - 查询商品价格>3000的商品
select * from product where price > 3000;

-- - 查询id=1的商品
select * from product where pid = 1;

-- - 查询id<>1的商品
select * from product where pid <> 1;

-- - 查询价格在3000到6000之间的商品
select * from product where price between 3000 and 6000;

-- - 查询id在1，5，7，15范围内的商品
select * from product where pid in(1,5,7,15);

-- - 查询商品名以iPho开头的商品(iPhone系列) 
select * from product where pname like 'iPho%';

-- - 查询商品价格大于3000并且数量大于20的商品   (条件 and 条件 and...)
select * from product where price > 3000 and num > 20;

-- - 查询id=1或者价格小于3000的商品 
select * from product where pid = 1 or price < 3000;

-- ----------------------------------------排序查询---------------------------------------------
# 创建学生表(有sid,学生姓名,学生性别,学生年龄,分数列,其中sid为主键自动增长)
CREATE TABLE student(
	sid INT PRIMARY KEY auto_increment,
	sname VARCHAR(40),
	sex VARCHAR(10),
	age INT,
  score DOUBLE
);

INSERT INTO student VALUES(null,'zs','男',18,98.5);
INSERT INTO student VALUES(null,'ls','女',18,96.5);
INSERT INTO student VALUES(null,'ww','男',15,50.5);
INSERT INTO student VALUES(null,'zl','女',20,98.5);
INSERT INTO student VALUES(null,'tq','男',18,60.5);
INSERT INTO student VALUES(null,'wb','男',38,98.5);
INSERT INTO student VALUES(null,'小丽','男',18,100);
INSERT INTO student VALUES(null,'小红','女',28,28);
INSERT INTO student VALUES(null,'小强','男',21,95);

-- 排序查询: 对查询结果进行排序,不会修改表中的数据
-- 单字段语法: select ... from 表名 [where 条件] [order by 字段名 asc|desc];  asc:升序,不写默认就是asc; desc:降序;
-- 多字段语法: select ... from 表名 [where 条件] [order by 字段名 asc|desc,字段名 asc|desc,...]; 
-- 1. 练习: 以分数降序查询所有的学生
select * from student order by score desc;

-- 2. 练习: 以分数降序查询所有的学生, 如果分数一致,再以age降序
select * from student order by score desc,age desc;


-- ----------------------------------------聚合函数查询---------------------------------------------
-- 语法: select 聚合函数(列名) from 表名 [where 条件];
-- 练习:求出学生表里面的最高分数
select max(score) from student;

-- 练习:求出学生表里面的最低分数
select min(score) from student;

-- 练习:求出学生表里面的分数的总和
select sum(score) from student;-- 726

-- 练习:求出学生表里面的平均分
select avg(score) from student;-- 726/9 = 80.666...7

-- 练习:统计学生的总人数 
select count(*) from student; -- 9

-- 如果把小红的分数改为null
update student set score = null where sname = '小红';
-- 练习:统计学生的总人数 
select count(score) from student; -- 8
-- 结论: 聚合函数会忽略null值
-- 解决: 使用ifnull(参数1,参数2)函数,如果参数1的值为null,就取参数2的值作为结果,如果参数1的值不为null,那就取参数1的值作为结果
-- 练习:求出学生表里面的分数的总和
select sum(score) from student;-- 698
-- 练习:求出学生表里面的平均分
select avg(score) from student;-- 698/8 = 87.25 -----有问题的, 真实的应该是: 698/9=77.555....6
select avg(ifnull(score,0)) from student;-- 698/9=77.555....6


-- ----------------------------------------分组查询---------------------------------------------
-- 语法: SELECT ... FROM 表名  [where 条件] group by 列名 [having 条件];
-- 1. 练习:根据性别分组,统计男生的总人数和女生的总人数
select * from student group by sex; 
-- 如果仅仅只是分组查询,没有任何意义,因为只会返回每一组的第一条记录
-- 分组的目的是为了统计计算,所以分组一般会和聚合函数一起使用
select count(*) from student group by sex; -- 得到的结果无法识别是哪一组的结果
-- 分组查询一般都会查询出分组字段的值,否则无法识别结果是属于哪一组的
select sex,count(*) from student group by sex;


-- 2. 练习根据性别分组, 统计每一组学生的总人数> 5的(分组后筛选)
select sex,count(*) from student group by sex having count(*) > 5;




-- ----------------------------------------分页查询---------------------------------------------
-- select ... from 表名 limit a,b; 
-- a:从哪里开始查询, 从0开始计数,省略a不写,默认就是从0开始
-- b:查询的数量【固定的,自定义的】

-- 练习: 查询sid为1到4--->第1页
select * from student limit 0,4;

-- 练习: 查询sid为5到8--->第2页
select * from student limit 4,4;

-- 练习: 查询sid为9到12--->第3页
select * from student limit 8,4;
select * from student limit 12,4;-- 第4页
select * from student limit 16,4;-- 第5页
select * from student limit 20,4;-- 第6页
-- ...
-- 分页查询的规律: limit (页码-1)*每页显示的总条数,每页显示的总条数








