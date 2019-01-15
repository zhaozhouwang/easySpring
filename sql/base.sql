/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : one

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 06/01/2019 09:27:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for LAB_USER
-- ----------------------------
DROP TABLE IF EXISTS `LAB_USER`;
CREATE TABLE `LAB_USER` (
  `ID` varchar(50) NOT NULL COMMENT 'PK',
  `REAL_NAME` varchar(20) DEFAULT NULL COMMENT '姓名',
  `AGE` int(3) DEFAULT NULL COMMENT '年龄',
  `USERNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `MOBILE` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `BIRTHDAY` date DEFAULT NULL COMMENT '生日',
  `PASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `SALT` varchar(50) DEFAULT NULL COMMENT '盐',
  `ROLE` varchar(20) DEFAULT NULL COMMENT '用户角色',
  `E_MAIL` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `CREATE_BY` varchar(50) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` date DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(50) DEFAULT NULL COMMENT '更新人id',
  `UPDATE_TIME` date DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` int(1) NOT NULL COMMENT '删除标记.0:未删除 1:已删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of LAB_USER
-- ----------------------------
BEGIN;
INSERT INTO `LAB_USER` VALUES ('31b8181967f64d3099647bdade96772f', 'qwe', 12, 'abc', NULL, '2018-11-11', 'www', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `LAB_USER` VALUES ('admin', 'admin', 1, 'admin', '17511111111', '2019-11-11', 'admin', 'admin', 'admin', 'admin@admin.com', NULL, '2011-11-11', NULL, '2011-11-11', 0);
INSERT INTO `LAB_USER` VALUES ('c0f257ba49144217af8c895c55a6dd7e', 'One', 18, 'Mr.One', NULL, NULL, 'wzz123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `LAB_USER` VALUES ('fbeebd5f51f54168bb7d856f0d91cd3f', 'string', 0, 'string', '1234321', '2019-01-05', 'string', NULL, 'string', '123@123.com', NULL, NULL, NULL, NULL, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : one

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/01/2019 09:52:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lab_role
-- ----------------------------
DROP TABLE IF EXISTS `lab_role`;
CREATE TABLE `lab_role`  (
                           `ROLE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'PK',
                           `ROLE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色称呼',
                           `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
                           PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lab_role
-- ----------------------------
INSERT INTO `lab_role` VALUES ('admin', 'admin', '超级管理员');

SET FOREIGN_KEY_CHECKS = 1;