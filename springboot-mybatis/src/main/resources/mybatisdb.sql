/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : mybatisdb

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 06/05/2020 22:28:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`
(
    `addr_id` int(11)                                                 NOT NULL AUTO_INCREMENT,
    `street`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `city`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `state`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `zip`     varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `country` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    PRIMARY KEY (`addr_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address`
VALUES (1, 'Paul', 'Chicago', 'IL', '60515', 'USA');
INSERT INTO `address`
VALUES (2, 'Naperville', 'Chicago', 'IL', '60515', 'USA');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `course_id`   int(11)                                                 NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `start_date`  datetime(0)                                             NULL DEFAULT NULL,
    `end_date`    datetime(0)                                             NULL DEFAULT NULL,
    `tutor_id`    int(11)                                                 NULL DEFAULT NULL,
    PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course`
VALUES (1, 'JavaSe', 'Java SE', '2011-03-02 11:09:33', '2012-03-02 11:09:37', 1);
INSERT INTO `course`
VALUES (2, 'JavaEE', 'Java EE', '2013-03-02 11:10:13', '2014-03-02 11:10:20', 2);
INSERT INTO `course`
VALUES (3, 'MyBatis', 'MyBatis', '2014-03-02 11:10:57', '2015-03-02 11:11:01', 2);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `stud_id` int(11)                                                     NOT NULL AUTO_INCREMENT,
    `name`    varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci  NOT NULL,
    `email`   varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci  NOT NULL,
    `phone`   varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
    `addr_id` int(11)                                                     NULL DEFAULT NULL,
    PRIMARY KEY (`stud_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = latin1
  COLLATE = latin1_swedish_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES (1, 'Student1', 'student1@gmail.com', '1983-06-25', 1);
INSERT INTO `student`
VALUES (2, 'Student2', 'student2@gmail.com', '1983-06-25', 2);

-- ----------------------------
-- Table structure for tutor
-- ----------------------------
DROP TABLE IF EXISTS `tutor`;
CREATE TABLE `tutor`
(
    `tutor_id` int(11)                                                 NOT NULL DEFAULT 0,
    `name`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `email`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL,
    `phone`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `addr_id`  int(11)                                                 NULL     DEFAULT NULL,
    PRIMARY KEY (`tutor_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tutor
-- ----------------------------
INSERT INTO `tutor`
VALUES (1, 'Jhon', 'jhon@163.com', '1231', 1);
INSERT INTO `tutor`
VALUES (2, 'Ying', 'ying@163.com', '323232', 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11)                                                 NOT NULL AUTO_INCREMENT,
    `name`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `email`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, '赵云', 'zhaoyun@163.com', NULL);
INSERT INTO `user`
VALUES (2, '张飞', 'zhangfei@163.com', NULL);
INSERT INTO `user`
VALUES (3, '诸葛', '诸葛@163.com', NULL);
INSERT INTO `user`
VALUES (4, 'Durant', 'durant@163.com', NULL);
INSERT INTO `user`
VALUES (5, '杜兰特', 'durant@163.com', NULL);
INSERT INTO `user`
VALUES (9, '霍华德', 'Howord@163.com', NULL);

SET FOREIGN_KEY_CHECKS = 1;
