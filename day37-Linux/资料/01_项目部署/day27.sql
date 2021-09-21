CREATE DATABASE `day27`;

USE `day27`;

DROP TABLE IF EXISTS `linkman`;

CREATE TABLE `linkman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8;


insert  into `linkman`(`id`,`name`,`sex`,`age`,`address`,`qq`,`email`) values (1,'张三','男',11,'广东','766335435','766335435@qq.com'),(2,'李四','男',12,'广东','243424242','243424242@qq.com'),(3,'王五','女',13,'广东','474574574','474574574@qq.com'),(4,'赵六','女',18,'广东','77777777','77777777@qq.com');
