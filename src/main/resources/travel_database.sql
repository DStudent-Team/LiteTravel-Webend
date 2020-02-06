/*
 Navicat Premium Data Transfer

 Source Server         : travel
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 122.51.98.193:3306
 Source Schema         : travel_database

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 15/01/2020 12:06:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for travel_agency
-- ----------------------------
DROP TABLE IF EXISTS `travel_agency`;
CREATE TABLE `travel_agency`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键自动递增',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '旅行社名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '旅行社介绍',
  `address` int(4) NOT NULL COMMENT '旅行社地址',
  `phone` int(20) NOT NULL COMMENT '旅行社电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for travel_forum_post
-- ----------------------------
DROP TABLE IF EXISTS `travel_forum_post`;
CREATE TABLE `travel_forum_post`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键自动递增',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主题名称',
  `creater_id` int(16) NOT NULL COMMENT '创建者id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发帖内容',
  `topic_id` int(16) NOT NULL COMMENT '类别id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for travel_forum_replay
-- ----------------------------
DROP TABLE IF EXISTS `travel_forum_replay`;
CREATE TABLE `travel_forum_replay`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键自动递增',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '回帖名称',
  `post_id` int(16) NOT NULL COMMENT '回帖id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发帖内容',
  `replay_id` int(16) NOT NULL COMMENT '回帖者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for travel_hotel
-- ----------------------------
DROP TABLE IF EXISTS `travel_hotel`;
CREATE TABLE `travel_hotel`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键自动递增',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '酒店名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '酒店介绍',
  `phone` int(20) NOT NULL COMMENT '酒店电话',
  `address` int(4) NOT NULL COMMENT '酒店地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for travel_line
-- ----------------------------
DROP TABLE IF EXISTS `travel_line`;
CREATE TABLE `travel_line`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键自动递增',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '线路名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '线路具体介绍',
  `pepleCount` int(4) NOT NULL COMMENT '报名人数',
  `full` int(4) NOT NULL COMMENT '该线路的容纳情况(0:表示已满 1:表示未满)',
  `price` int(4) NOT NULL COMMENT '该线路的价钱',
  `agency` int(4) NOT NULL COMMENT '负责的旅行社',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for travel_member
-- ----------------------------
DROP TABLE IF EXISTS `travel_member`;
CREATE TABLE `travel_member`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键自动递增',
  `username` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `phone` int(20) NOT NULL COMMENT '联系电话',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所在城市',
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电子邮件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for travel_member_reserve_hotel
-- ----------------------------
DROP TABLE IF EXISTS `travel_member_reserve_hotel`;
CREATE TABLE `travel_member_reserve_hotel`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键自动递增',
  `hotel_id` int(16) NOT NULL COMMENT '引用酒店表中的id',
  `member_id` int(16) NOT NULL COMMENT '引用会员表中的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for travel_member_reserve_line
-- ----------------------------
DROP TABLE IF EXISTS `travel_member_reserve_line`;
CREATE TABLE `travel_member_reserve_line`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键自动递增',
  `line_id` int(16) NOT NULL COMMENT '引用旅行线路表中的id',
  `member_id` int(16) NOT NULL COMMENT '引用会员表中的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for travel_sight
-- ----------------------------
DROP TABLE IF EXISTS `travel_sight`;
CREATE TABLE `travel_sight`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键主动递增',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '景点名称',
  `descript` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '景点描述',
  `price` int(4) NOT NULL COMMENT '景点价格',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '景点图片地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
