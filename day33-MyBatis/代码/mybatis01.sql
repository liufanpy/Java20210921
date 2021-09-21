CREATE DATABASE mybatis_day01;
USE mybatis_day01;
CREATE TABLE t_user(
		uid INT PRIMARY KEY AUTO_INCREMENT,
		username VARCHAR(40),
	 	sex VARCHAR(10),
		birthday DATE,
		address VARCHAR(40)
);

INSERT INTO `t_user` VALUES (NULL, 'zs', '男', '2018-08-08', '北京');
INSERT INTO `t_user` VALUES (NULL, 'ls', '女', '2018-08-30', '武汉');
INSERT INTO `t_user` VALUES (NULL, 'ww', '男', '2018-08-08', '北京');

INSERT INTO `t_user` VALUES (NULL, ?, ?, ?, ?);

CONCAT(#{username},'%')


UPDATE t_user SET username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where uid=#{uid}

SELECT LAST_INSERT_ID();

SELECT UUID()


-- 创建多个对象时  将多个对象分别作为属性封装到一个新的java类中
-- 为数据添加一列   1:超级管理员  2.管理员  3.普通用户
ALTER TABLE t_user ADD roleId INT;
--  根据用户名和角色id进行查询
-- username  sex roleId
-- QueryVo User Role


-- 实际工作中：数据库表中字段不会出现大写字母 另外,一个字段由多个单词组成使用_进行拼接
-- windows环境下，数据库使用表名字段名不区分大小写  但是Linux环境下，操作数据库 表名字段名会区分大小写
-- uId  select * from t_user uid=?
-- u_id --> uId


















