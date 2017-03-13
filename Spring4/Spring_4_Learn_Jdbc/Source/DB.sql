/*
Navicat MySQL Data Transfer

Source Server         : MySQL5
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : spring4learn

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-03-13 16:33:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `departments`
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES ('1', '研发中心');
INSERT INTO `departments` VALUES ('2', '商务部');
INSERT INTO `departments` VALUES ('3', '财务部');

-- ----------------------------
-- Table structure for `employees`
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `dept_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('1', 'AA', 'aa@atguigu.com', '1');
INSERT INTO `employees` VALUES ('2', 'BB', 'bb@atguigu.com', '2');
INSERT INTO `employees` VALUES ('3', 'CC', 'cc@atguigu.com', '3');
INSERT INTO `employees` VALUES ('4', 'DD', 'dd@atguigu.com', '3');
INSERT INTO `employees` VALUES ('5', 'Jack', 'ee@atguigu.com', '2');
INSERT INTO `employees` VALUES ('6', 'FF', 'ff@atguigu.com', '2');
INSERT INTO `employees` VALUES ('7', 'XYZ', 'xyz@sina.com', '3');
