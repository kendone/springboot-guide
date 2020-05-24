/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : world

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-23 16:31:44
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `name`     varchar(100) NOT NULL,
    `email`    varchar(100) DEFAULT NULL,
    `password` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES ('1', '赵云', 'zhaoyun@163.com', null);
INSERT INTO `user`
VALUES ('2', '张飞', 'zhangfei@163.com', null);
INSERT INTO `user`
VALUES ('3', '诸葛', '诸葛@163.com', null);
INSERT INTO `user`
VALUES ('4', 'Durant', 'durant@163.com', null);
INSERT INTO `user`
VALUES ('5', '杜兰特', 'durant@163.com', null);
INSERT INTO `user`
VALUES ('9', '霍华德', 'Howord@163.com', null);
