/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : javademo

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 11/08/2019 16:50:29 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL,
  `password` varchar(50) NOT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `is_del` tinyint(3) NOT NULL DEFAULT '0',
  `age` tinyint(4) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('2', '二师兄', '123', '八戒', '1', null, null, null, null), ('3', '小师弟', '432', '悟净', '0', null, null, null, null), ('4', '大大da师兄111', '123456', '大大师兄', '0', null, null, null, null), ('5', '大大da师兄111', '123456', '大大师兄', '0', null, null, null, null), ('6', '大师兄', '123456', '孙悟空', '0', null, null, null, null), ('7', '大师兄', '123456', '孙悟空', '0', null, null, null, null), ('8', 'string3', 'string2', '大师兄孙悟空', '0', null, null, null, null), ('9', '我是大师兄', 'string', '大师兄孙悟空', '0', null, null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
