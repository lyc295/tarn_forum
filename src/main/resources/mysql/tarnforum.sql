/*
 Navicat Premium Data Transfer

 Source Server         : 111.229.137.213
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 111.229.137.213:3306
 Source Schema         : tarnforum

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 02/06/2020 11:02:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for posts_collect
-- ----------------------------
DROP TABLE IF EXISTS `posts_collect`;
CREATE TABLE `posts_collect`  (
  `COLLECT_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USER_ID` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `POST_ID` int(0) NULL DEFAULT NULL COMMENT '帖子ID',
  `COLLECT_FLAG` tinyint(1) NULL DEFAULT 0 COMMENT '收藏FLAG',
  `COLLECT_TIME` datetime(0) NULL DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`COLLECT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of posts_collect
-- ----------------------------
INSERT INTO `posts_collect` VALUES (22, 8, 24, 1, NULL);

-- ----------------------------
-- Table structure for posts_comment
-- ----------------------------
DROP TABLE IF EXISTS `posts_comment`;
CREATE TABLE `posts_comment`  (
  `COMMENT_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USER_ID` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `POST_ID` int(0) NULL DEFAULT NULL COMMENT '帖子ID',
  `COLLECT_CONTENT` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `COLLECT_TIME` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `COMMENT_FATHER_ID` int(0) NULL DEFAULT NULL COMMENT '主键ID的父ID',
  `COLLECT_FLAG` tinyint(1) NULL DEFAULT 0 COMMENT '评论FLAG  0:存在   1:删除',
  `REPLY_USER_ID` int(0) NULL DEFAULT NULL COMMENT '被回复用户ID',
  PRIMARY KEY (`COMMENT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of posts_comment
-- ----------------------------
INSERT INTO `posts_comment` VALUES (50, 7, 20, 'lyc来评论了', '2020-05-30 04:14:28', NULL, 0, NULL);
INSERT INTO `posts_comment` VALUES (51, 6, 20, '@lyc：李永超，你好！', '2020-05-30 04:15:00', 50, 0, 7);
INSERT INTO `posts_comment` VALUES (52, 6, 19, '欢迎大家来此评论！！！！！！！', '2020-05-30 04:25:52', NULL, 0, NULL);
INSERT INTO `posts_comment` VALUES (53, 8, 24, '123132', '2020-05-30 11:13:20', NULL, 0, NULL);
INSERT INTO `posts_comment` VALUES (54, 8, 25, 'dsfferfer', '2020-05-30 11:14:45', NULL, 0, NULL);
INSERT INTO `posts_comment` VALUES (55, 6, 25, '@tset：vndsijfvds', '2020-05-30 11:15:01', 54, 1, 8);
INSERT INTO `posts_comment` VALUES (56, 6, 25, '@李永超：dfwefwef', '2020-05-30 11:15:10', 54, 0, 6);
INSERT INTO `posts_comment` VALUES (57, 6, 19, '@李永超：我单位', '2020-06-01 18:33:05', 52, 0, 6);
INSERT INTO `posts_comment` VALUES (58, 6, 19, '@李永超：得沸沸分位数', '2020-06-01 18:33:12', 52, 0, 6);
INSERT INTO `posts_comment` VALUES (59, 6, 25, '发v大V大V大VDVD发v的发v', '2020-06-01 18:34:49', NULL, 0, NULL);

-- ----------------------------
-- Table structure for posts_liked
-- ----------------------------
DROP TABLE IF EXISTS `posts_liked`;
CREATE TABLE `posts_liked`  (
  `LIKED_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USER_ID` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `LIKED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '点赞时间',
  `POST_ID` int(0) NULL DEFAULT NULL COMMENT '帖子ID',
  `LIKED_STATUS` tinyint(1) NULL DEFAULT 0 COMMENT '点赞状态 0:点赞   1:取消点赞',
  PRIMARY KEY (`LIKED_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1838 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of posts_liked
-- ----------------------------
INSERT INTO `posts_liked` VALUES (1834, 6, '2020-05-30 10:13:30', 20, 1);
INSERT INTO `posts_liked` VALUES (1835, 6, '2020-05-30 10:10:23', 19, 1);
INSERT INTO `posts_liked` VALUES (1836, 8, '2020-05-30 11:14:35', 25, 1);
INSERT INTO `posts_liked` VALUES (1837, 6, '2020-06-01 18:33:57', 25, 0);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `USER_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USER_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名（唯一）',
  `USER_PWD` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `USER_EMAIL` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `USER_HEADPICURL` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `USER_ALLMARKS` int(0) NULL DEFAULT 0 COMMENT '用户论坛的总积分',
  `USER_FLAG` tinyint(1) NULL DEFAULT 0 COMMENT '用户状态 0:存在 1:删除',
  `USER_CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '用户注册时间',
  `USER_MODIFYTIME` datetime(0) NULL DEFAULT NULL COMMENT '用户修改时间',
  `USER_AUTOGRAPH` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户个性签名',
  PRIMARY KEY (`USER_ID`) USING BTREE,
  UNIQUE INDEX `UNQ_USER_INFO_USER_NAME`(`USER_NAME`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (6, '李永超', 'ziyue123', '1174510490@qq.com', 'http://111.229.137.213:9000/img/2.jpg', 0, 0, '2020-05-30 02:09:34', NULL, NULL);
INSERT INTO `user_info` VALUES (7, 'lyc', 'lyc', 'lyc', 'http://111.229.137.213:9000/img/6.jpg', 0, 0, '2020-05-30 04:14:04', NULL, NULL);
INSERT INTO `user_info` VALUES (8, 'tset', 'tset', '147@qq.com', 'http://111.229.137.213:9000/img/7.jpg', 0, 0, '2020-05-30 10:49:33', NULL, NULL);
INSERT INTO `user_info` VALUES (9, '欢欢', '15026656968', '812762820@qq.com', 'http://111.229.137.213:9000/img/6.jpg', 0, 0, '2020-05-30 12:23:52', NULL, NULL);

-- ----------------------------
-- Table structure for user_posts
-- ----------------------------
DROP TABLE IF EXISTS `user_posts`;
CREATE TABLE `user_posts`  (
  `POST_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '帖子的ID',
  `POST_TITLE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '帖子的标题',
  `POST_BIBOID` int(0) NULL DEFAULT NULL COMMENT '帖子所属父版块ID',
  `POST_USERID` int(0) NULL DEFAULT NULL COMMENT '发帖者ID',
  `POST_CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '发帖时间',
  `POST_UPDATETIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `POST_CONTENT` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '帖子内容',
  `POST_REWARD` int(0) NULL DEFAULT NULL COMMENT '帖子的总共悬赏分（吸引浏览）',
  `POST_SCORE` int(0) NULL DEFAULT NULL COMMENT '帖子悬赏分所剩下的分数',
  `POST_ISPAY` tinyint(1) NULL DEFAULT 0 COMMENT '是否结贴 0 未结账 1结账',
  `POST_TYPE` tinyint(1) NULL DEFAULT 0 COMMENT '帖子标签',
  `POST_FLAG` tinyint(1) NULL DEFAULT 0 COMMENT '帖子状态 0 正常   1 删除',
  `POST_READ` int(0) NULL DEFAULT 0 COMMENT '帖子阅读量',
  PRIMARY KEY (`POST_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_posts
-- ----------------------------
INSERT INTO `user_posts` VALUES (19, '项目启动第一篇文章', 1, 6, NULL, NULL, '我是一只小青蛙，呱呱呱呱呱。。。。。。。。。。。。。。。', 0, NULL, 1, 0, 0, 0);
INSERT INTO `user_posts` VALUES (20, '测试第二篇文章', 1, 6, '2020-05-30 04:13:43', NULL, '测试实施', 0, NULL, 1, 0, 0, 0);
INSERT INTO `user_posts` VALUES (21, '毕业答辩测试', 1, 6, '2020-05-30 10:20:17', NULL, '毕业答辩测试', 0, NULL, 1, 0, 0, 1);
INSERT INTO `user_posts` VALUES (22, '塔里木大学', 1, 7, '2020-05-30 10:20:47', NULL, '塔里木大学', 0, NULL, 1, 0, 0, 0);
INSERT INTO `user_posts` VALUES (23, '校园论坛', 1, 7, '2020-05-30 10:21:09', NULL, '校园论坛', 0, NULL, 1, 0, 0, 1);
INSERT INTO `user_posts` VALUES (24, '游戏模板', 2, 7, '2020-05-30 10:21:37', NULL, '游戏模板', 0, NULL, 1, 0, 0, 1);
INSERT INTO `user_posts` VALUES (25, 'fhrtgbr', 1, 8, '2020-05-30 11:14:08', NULL, 'dfsdfdsfdfe', 10, NULL, 0, 0, 0, 1);
INSERT INTO `user_posts` VALUES (26, '', NULL, 9, '2020-05-30 12:25:26', NULL, '哈喽', 0, NULL, 1, 0, 0, 0);
INSERT INTO `user_posts` VALUES (27, '', NULL, 9, '2020-05-30 12:26:19', NULL, '恭喜恭喜', 0, NULL, 1, 0, 0, 0);

-- ----------------------------
-- Table structure for user_signin
-- ----------------------------
DROP TABLE IF EXISTS `user_signin`;
CREATE TABLE `user_signin`  (
  `SIGNIN_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USER_ID` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `SIGNIN_TIME` datetime(0) NULL DEFAULT NULL COMMENT '签到时间',
  `CONTINUITY_SIGNIN_DAY` int(0) NULL DEFAULT NULL COMMENT '连续签到天数',
  PRIMARY KEY (`SIGNIN_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_signin
-- ----------------------------
INSERT INTO `user_signin` VALUES (8, 6, '2020-06-01 18:32:40', 3);
INSERT INTO `user_signin` VALUES (9, 7, '2020-05-30 04:26:37', 1);
INSERT INTO `user_signin` VALUES (10, 8, '2020-05-30 11:13:52', 1);

SET FOREIGN_KEY_CHECKS = 1;
