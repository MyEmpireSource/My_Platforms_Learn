/*
Navicat MySQL Data Transfer

Source Server         : MySQL5
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : spring4learn

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-03-13 16:32:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `username` varchar(16) NOT NULL,
  `balance` float unsigned zerofill NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('AA', '000000000930');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `isbn` varchar(16) NOT NULL,
  `book_name` varchar(32) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1001', 'JAVA', '100');
INSERT INTO `book` VALUES ('1002', 'Oracle', '70');

-- ----------------------------
-- Table structure for `book_stock`
-- ----------------------------
DROP TABLE IF EXISTS `book_stock`;
CREATE TABLE `book_stock` (
  `isbn` varchar(16) NOT NULL,
  `stock` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_stock
-- ----------------------------
INSERT INTO `book_stock` VALUES ('1001', '0000000005');
INSERT INTO `book_stock` VALUES ('1002', '0000000006');
