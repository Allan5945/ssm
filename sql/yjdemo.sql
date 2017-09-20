/*
Navicat MySQL Data Transfer

Source Server         : yj
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : yjdemo

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-09-20 10:29:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `pas` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', 'wdsadmin', '123456');
INSERT INTO `user_table` VALUES ('2', 'kweadmin', '123456');
INSERT INTO `user_table` VALUES ('3', 'siisk', '16544');
INSERT INTO `user_table` VALUES ('4', 'ASASDD', '87770');
INSERT INTO `user_table` VALUES ('5', 'DADFF', '011000');
INSERT INTO `user_table` VALUES ('6', 'ADADFFF', '98711');
