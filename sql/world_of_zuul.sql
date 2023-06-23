/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : world_of_zuul

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 23/06/2023 21:14:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `currentRoom` int NULL DEFAULT 0,
  `capacity` int NULL DEFAULT 10,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES (1672196496054677506, 'xiaowang', '123456', 2, 10);

-- ----------------------------
-- Table structure for playeritem
-- ----------------------------
DROP TABLE IF EXISTS `playeritem`;
CREATE TABLE `playeritem`  (
  `player_id` bigint NOT NULL,
  `id` int NOT NULL,
  `count` int NULL DEFAULT NULL,
  PRIMARY KEY (`player_id`, `id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of playeritem
-- ----------------------------
INSERT INTO `playeritem` VALUES (1672196496054677506, 1, 1);

-- ----------------------------
-- Table structure for roomitem
-- ----------------------------
DROP TABLE IF EXISTS `roomitem`;
CREATE TABLE `roomitem`  (
  `player_id` bigint NOT NULL,
  `room_id` int NOT NULL,
  `id` int NOT NULL,
  `count` int NULL DEFAULT NULL,
  PRIMARY KEY (`player_id`, `room_id`, `id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roomitem
-- ----------------------------
INSERT INTO `roomitem` VALUES (1672196496054677506, 3, 2, NULL);
INSERT INTO `roomitem` VALUES (1672196496054677506, 5, 4, NULL);
INSERT INTO `roomitem` VALUES (1672196496054677506, 6, 8, NULL);
INSERT INTO `roomitem` VALUES (1672196496054677506, 7, 5, NULL);
INSERT INTO `roomitem` VALUES (1672196496054677506, 7, 6, NULL);
INSERT INTO `roomitem` VALUES (1672196496054677506, 8, 7, NULL);
INSERT INTO `roomitem` VALUES (1672196496054677506, 15, 9, NULL);

SET FOREIGN_KEY_CHECKS = 1;
