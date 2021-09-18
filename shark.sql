/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1 3307
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 127.0.0.1:3307
 Source Schema         : shark

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 16/09/2021 17:26:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `blog_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客表主键id',
  `blog_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
  `blog_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客内容',
  `blog_author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `blog_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0-草稿 1-发布',
  `is_deleted` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `create_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  `delete_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志，默认为0。0：未删除；1：已删除。',
  `blog_heat` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('20191209183126991', '且随意的博客', '## 区块链（区块+链）\n\n1. 背景\n   1. 原始加密算法\n   2. RSA加密\n   3. 哈希函数 任何长度文件都能转化为256位二进制数字\n2. 基本原理\n   1. 去中心化\n   2. 不可篡改\n\n3. 例子\n   1. 区块链账本\n      1. 泛洪式刷新数据\n      2. 分页\n      3. 本页校验码+上页校验码结合\n      4. 工作量证明概念：\n         1. 找工作量证明数的过程=挖矿\n         2. 比特币挖出一个数后告诉大家\n         3. 算力\n         4. 0.023212个比特币啥意思？？？\n      5. 总是追随符合规则的最长链，增加造假成本。造假者只能算出最长的链才能成功。\n      6. 挖矿 广播 记账 买币\n   2. 点对点对等网络体系\n      1. 东南亚六国建立区块链网络，不再使用美元，防止受限制。\n      2. 是否可以推广到一带一路项目中。\n\n\n\n', '且随意', '0', '0', NULL, '0', NULL);
INSERT INTO `blog` VALUES ('20200328152516601', '楚卫国', '为卿采莲兮涉水', '天下名将', '0', '0', '2020-03-28 15:25:16', '1', NULL);
INSERT INTO `blog` VALUES ('20200408104342099', '且随意的博客', '张逸秋真好看', '且随意', '0', '0', '2020-04-08 10:43:42', '1', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `roles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'beijing', 'admin', '$2a$04$1OiUa3yEchBXQBJI8JaMyuKZNlwzWvfeQjKAHnwAEQwnacjt6ukqu', 'ROLE_USER');
INSERT INTO `user` VALUES (2, 'SuperMan', 'shanghang', 'super', '$2a$04$1OiUa3yEchBXQBJI8JaMyuKZNlwzWvfeQjKAHnwAEQwnacjt6ukqu', 'ROLE_USER,ROLE_ADMIN');

SET FOREIGN_KEY_CHECKS = 1;
