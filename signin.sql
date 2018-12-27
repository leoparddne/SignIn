/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : signin

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 27/12/2018 21:21:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '识别码',
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  CONSTRAINT `code_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of code
-- ----------------------------
INSERT INTO `code` VALUES (8, '6077', 1);
INSERT INTO `code` VALUES (9, '4442', 1);
INSERT INTO `code` VALUES (10, '6678', 1);
INSERT INTO `code` VALUES (11, '5810', 1);

-- ----------------------------
-- Table structure for signin
-- ----------------------------
DROP TABLE IF EXISTS `signin`;
CREATE TABLE `signin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(255) NOT NULL,
  `code` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  INDEX `codeid`(`code`) USING BTREE,
  CONSTRAINT `signin_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of signin
-- ----------------------------
INSERT INTO `signin` VALUES (1, 2, '4442', '2018-12-26 22:16:53');
INSERT INTO `signin` VALUES (2, 2, '4442', '2018-12-26 22:17:29');
INSERT INTO `signin` VALUES (3, 2, '4442', '2018-12-26 22:25:10');
INSERT INTO `signin` VALUES (4, 2, '4442', '2018-12-26 22:29:48');
INSERT INTO `signin` VALUES (5, 2, '6678', '2018-12-27 01:10:39');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(2) NOT NULL COMMENT '0:禁用 10:教师 20:学生',
  `state` int(1) NOT NULL COMMENT '是否失效 0:有效 1:失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'a', 'a', 10, 1);
INSERT INTO `user` VALUES (2, 'b', 'b', 20, 1);

SET FOREIGN_KEY_CHECKS = 1;
