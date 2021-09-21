/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50734
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2021-06-18 16:02:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zs', '123456', '张三', '18', 'test1@itcast.cn');
INSERT INTO `tb_user` VALUES ('2', 'ls', '123456', '李四', '20', 'test2@itcast.cn');
INSERT INTO `tb_user` VALUES ('3', 'ww', '123456', '王五', '28', 'test3@itcast.cn');
INSERT INTO `tb_user` VALUES ('4', 'zl', '123456', '赵六', '21', 'test4@itcast.cn');
INSERT INTO `tb_user` VALUES ('5', 'tq', '123456', '田七', '24', 'test5@itcast.cn');
