/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.5.49 : Database - betterman
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

/*Table structure for table `userses` */

DROP TABLE IF EXISTS `userses`;

CREATE TABLE `userses` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户对应唯一ID',
  `userName` varchar(15) NOT NULL,
  `pwd` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `userses` */

insert  into `userses`(`id`,`userName`,`pwd`) values 
(1,'杨进','123456'),
(2,'dd','546564564');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
