-- --------------------------------为什么要有多表----------------------------------------------------------
CREATE TABLE emp (
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(30),
	age INT,
	dep_name VARCHAR(30),
	dep_location VARCHAR(30)
);

-- 添加数据
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('张三', 20, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('李四', 21, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('王五', 20, '研发部', '广州');

INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('老王', 20, '销售部', '深圳');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('大王', 22, '销售部', '深圳');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('小王', 18, '销售部', '深圳');


-- 拆表:
-- 创建部门表
CREATE TABLE department (
	id INT PRIMARY KEY AUTO_INCREMENT,
	dep_name VARCHAR(20),
	dep_location VARCHAR(20)
);

-- 创建员工表
CREATE TABLE employee (
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT,
	dep_id INT
);

-- 添加2个部门
INSERT INTO department (dep_name, dep_location) VALUES ('研发部', '广州');
INSERT INTO department (dep_name, dep_location) VALUES('销售部', '深圳');

-- 添加员工,dep_id表示员工所在的部门
INSERT INTO employee (NAME, age, dep_id) VALUES 
('张三', 20, 1), 
('李四', 21, 1), 
('王五', 20, 1), 
('老王', 20, 2),
('大王', 22, 2),
('小王', 18, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('赵六', 20, 6);


-- -------------------------------------------------------添加外键-----------------------------------
-- 语法: constraint 外键名 foreign key(外键字段名) references 主表名(主键);
-- 为已有表添加外键: alter table 表名 add constraint 外键名 foreign key(外键字段名) references 主表名(主键);
alter table employee add constraint emp_dep_fk1 foreign key(dep_id) references department(id);
-- 设置外键之后,添加非法数据,会失败
INSERT INTO employee (NAME, age, dep_id) VALUES ('田七', 20, 6);-- 报错

-- 创建表的时候添加外键
create table 表名(
	字段 字段类型 字段约束,
	字段 字段类型 字段约束,
	...
	constraint 外键名 foreign key(外键字段名) references 主表名(主键)
);
-- 创建员工表
CREATE TABLE employee (
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT,
	dep_id INT,
	constraint emp_dep_fk1 foreign key(dep_id) references department(id)
);

-- -------------------------------------------------------删除外键-----------------------------------
-- 语法:alter table 表名 drop foreign key 外键名;
alter table employee drop foreign key emp_dep_fk1;


-- -------------------------------------------------------外键级联更新和级联删除-----------------------------------
-- 级联更新: 主表中主键的值发生了改变,从表中的外键就会跟着改变---> on update cascade
-- 级联删除: 主表中主键的值被删除了,从表中外键的值也会跟着删除---> on delete cascade
-- 没有设置外键级联更新和级联删除
-- 问题1: 修改销售部的id为5----会失败
update department set id = 5 where id = 2;
-- 问题2: 删除id为1的研发部----会失败
delete from department where id = 1;

-- 设置外键级联更新和级联删除
alter table employee add constraint emp_dep_fk1 foreign key(dep_id) references department(id) on update cascade on delete cascade;
-- 问题1: 修改销售部的id为5----会成功
update department set id = 5 where id = 2;
-- 问题2: 删除id为1的研发部----会成功
delete from department where id = 1;


-- -------------------------------------------------------多表建表练习-----------------------------------
create table class(
 id int primary key auto_increment,
 name varchar(40)  
);

create table student(
 id int primary key auto_increment,
 name varchar(40),
 c_id int,
 constraint stu_cls_fk1 foreign key(c_id) references class(id)
);

create table course(
 id int primary key auto_increment,
 name varchar(40)  
);

create table stu_cou(
	sno int,
    cno int,
    constraint stu_cou_fk1 foreign key(cno) references course(id),
    constraint stu_cou_fk2 foreign key(sno) references student(id)
);

