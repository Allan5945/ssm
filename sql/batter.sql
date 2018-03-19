/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.5.25 : Database - betterman
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`betterman` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `betterman`;

/*Table structure for table `record` */

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
  `columId` int(10) NOT NULL AUTO_INCREMENT COMMENT '对应项ID',
  `id` int(10) DEFAULT NULL COMMENT '对应用户ID',
  `sdata` varchar(50) DEFAULT NULL COMMENT '开始时间',
  `edata` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `zk` int(10) DEFAULT NULL COMMENT '时间折扣',
  `bz` varchar(200) DEFAULT NULL COMMENT '对应项的备注',
  `tipMes` varchar(200) DEFAULT NULL COMMENT '监督人是否看信息，对应的是每个监督人的Id，如果为空则代表全部都查看过',
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '此条数据是否生效，0-不生效，1-生效',
  PRIMARY KEY (`columId`),
  KEY `columId` (`columId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `record` */

insert  into `record`(`columId`,`id`,`sdata`,`edata`,`zk`,`bz`,`tipMes`,`state`) values 
(29,1,'2018-02-11 11:07','2018-05-01 12:00',0,NULL,NULL,113093),
(43,1,'2018-02-11 11:48','2018-05-01 12:00',0,'',NULL,113052),
(44,1,'2018-02-11 11:49','2018-02-11 11:49',0,'',NULL,0),
(45,1,'2018-02-11 11:51','2018-02-11 11:51',0,'',NULL,0),
(46,1,'2018-02-11 11:51','2018-02-11 11:51',0,'',NULL,0),
(47,1,'2018-02-11 11:53','2018-02-11 11:53',0,'',NULL,0);

/*Table structure for table `userses` */

DROP TABLE IF EXISTS `userses`;

CREATE TABLE `userses` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户对应唯一ID',
  `userName` varchar(15) NOT NULL COMMENT '用户名',
  `pwd` varchar(15) NOT NULL COMMENT '密码',
  `associated` varchar(200) DEFAULT NULL COMMENT '关联人',
  `unionid` varchar(200) DEFAULT NULL COMMENT '绑定微信小程序的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `userses` */

insert  into `userses`(`id`,`userName`,`pwd`,`associated`,`unionid`) values 
(1,'528386631','0','2','gcQNok6iyM8/s/Tm5rMxAg=='),
(2,'352563349','0','1',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
