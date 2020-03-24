/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : world

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-23 16:31:38
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts`
(
    `ID`         int(11)   NOT NULL AUTO_INCREMENT,
    `TITLE`      varchar(100)       DEFAULT NULL,
    `CONTENT`    varchar(200)       DEFAULT NULL,
    `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `UPDATED_ON` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts`
VALUES ('1', 'Introducing SpringBoot', 'SpringBoot is awesome', '2017-05-10 00:00:00', '2020-03-23 09:00:35');
INSERT INTO `posts`
VALUES ('2', 'Securing Web applications', 'This post will show how to use SpringSecurity', '2017-05-20 00:00:00',
        '2020-03-23 09:00:35');
INSERT INTO `posts`
VALUES ('3', 'Introducing Spring Social', 'Developing social web applications using Spring Social',
        '2017-05-24 00:00:00', '2020-03-23 09:00:35');
INSERT INTO `posts`
VALUES ('4', '????Spring Boot', 'Spring Boot ????', '2020-03-23 16:14:49', '2020-03-23 16:14:50');
INSERT INTO `posts`
VALUES ('5', '好好学习Spring Boot', 'Spring Boot 非常易用', '2020-03-23 16:27:39', '2020-03-23 16:27:39');
INSERT INTO `posts`
VALUES ('6', 'Spring Boot 难吗', 'Spring Boot 慢慢来', '2020-03-23 16:28:40', '2020-03-23 16:28:40');
