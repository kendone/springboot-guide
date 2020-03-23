/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : world

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-23 16:31:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `EMAIL` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `CONTENT` text CHARACTER SET utf8,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATED_ON` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `POST_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `comments_ibfk_1` (`POST_ID`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`POST_ID`) REFERENCES `users` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', 'John', 'john@gmail.com', 'This is cool', '2017-05-10 00:00:00', '2020-03-23 09:00:51', '1');
INSERT INTO `comments` VALUES ('2', 'Rambo', 'rambo@gmail.com', 'Thanks for awesome tips', '2017-05-20 00:00:00', '2020-03-23 09:00:51', '1');
INSERT INTO `comments` VALUES ('3', 'Paul', 'paul@gmail.com', 'Nice post buddy.', '2017-05-24 00:00:00', '2020-03-23 09:00:51', '2');
