/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50519
 Source Host           : localhost:3306
 Source Schema         : zz

 Target Server Type    : MySQL
 Target Server Version : 50519
 File Encoding         : 65001

 Date: 03/04/2024 12:24:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户的主键id',
  `zxj_id` bigint(20) NULL DEFAULT NULL COMMENT '助学金的主键id',
  `apply_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '补充图片',
  `apply_tiaojian` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请理由',
  `tea_work_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '辅导员工号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES (1, 11, 1206890499, '2024-03-29 14:06:58', '通过', '1711721182224_我的.png', '理由。。。', '111111');
INSERT INTO `apply` VALUES (2, 11, 1206890500, '2024-03-30 04:06:44', '待审核', NULL, 'admin2', '111111');

-- ----------------------------
-- Table structure for guanliyuan
-- ----------------------------
DROP TABLE IF EXISTS `guanliyuan`;
CREATE TABLE `guanliyuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of guanliyuan
-- ----------------------------
INSERT INTO `guanliyuan` VALUES (1, 'admin', 'f7b6978421ba7b76794407d69171f870', '5f5292b16cfe19eefda15c9abf500eca');

-- ----------------------------
-- Table structure for jiang_cheng
-- ----------------------------
DROP TABLE IF EXISTS `jiang_cheng`;
CREATE TABLE `jiang_cheng`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学号',
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '班级名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '类型（奖励/处分）',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '处理时间',
  `handler_work_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '处理人工号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of jiang_cheng
-- ----------------------------
INSERT INTO `jiang_cheng` VALUES (2, '20081234', '张珊', '计算机与信息学院', '奖励', '优秀班干部', '2024-04-03 11:36:10', '111111');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '班级名称',
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `stu_number` int(11) NULL DEFAULT NULL COMMENT '学号',
  `score_de` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '德',
  `score_zhi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '智',
  `score_ti` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '体',
  `score_neng` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '能',
  `score_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '总分',
  `score_avg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '平均分',
  `xueqi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (2, '计算机与信息学院', '张珊', 20081234, '75.9', '78.5', '80.3', '80.5', '315.2', '78.8', '大一下');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '性别',
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学号（学生学号固定长度8位）',
  `counselor_work_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '辅导员工号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张珊', '18', '女', '20081234', '111111');
INSERT INTO `student` VALUES (22, '学生1', '18', '男', '20081111', '111111');
INSERT INTO `student` VALUES (23, '学生2', '18', '男', '20082222', '111111');
INSERT INTO `student` VALUES (24, '学生3', '18', '男', '20083333', '111111');
INSERT INTO `student` VALUES (25, '学生4', '18', '男', '20084444', '111111');
INSERT INTO `student` VALUES (26, '学生5', '18', '男', '20085555', '111111');
INSERT INTO `student` VALUES (27, '学生6', '18', '男', '20086666', '111111');
INSERT INTO `student` VALUES (28, '学生7', '18', '男', '20087777', '111111');
INSERT INTO `student` VALUES (29, '学生8', '18', '男', '20088888', '111111');
INSERT INTO `student` VALUES (30, '学生9', '18', '男', '20089999', '111111');
INSERT INTO `student` VALUES (31, '学生10', '18', '男', '20081010', '222222');
INSERT INTO `student` VALUES (32, '学生11', '18', '男', '20081011', '222222');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `work_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '工号固定6位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (9, '老师1', '男', '35', '111111');
INSERT INTO `teacher` VALUES (10, '老师2', '女', '34', '222222');
INSERT INTO `teacher` VALUES (11, '老师3', '女', '23', '000001');
INSERT INTO `teacher` VALUES (12, '老师4', '男', '18', '123456');
INSERT INTO `teacher` VALUES (13, '老师5', '男', '18', '123457');
INSERT INTO `teacher` VALUES (14, '老师6', '男', '18', '123458');
INSERT INTO `teacher` VALUES (15, '老师7', '男', '18', '123459');
INSERT INTO `teacher` VALUES (16, '老师8', '男', '18', '123467');
INSERT INTO `teacher` VALUES (17, '老师9', '男', '18', '123468');
INSERT INTO `teacher` VALUES (18, '老师10', '男', '18', '123469');
INSERT INTO `teacher` VALUES (19, '老师11', '男', '18', '123411');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '盐加密',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学号或教职工号',
  `create_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10, 'admin1', '86c595e485b95371cac525dea741ccd2', '4684fccf01c7000de6fbc85de6d5a64c', '111111', '2024-03-21 09:53:51');
INSERT INTO `user` VALUES (11, 'admin2', 'e49f425265d0966fb621527bd7b1aaed', 'd1d63380482a042625fde31c3995e97c', '20081234', '2024-03-21 10:46:11');
INSERT INTO `user` VALUES (12, 'admin3', '49455b149b4669c4b38f0b96a68cb1b8', '9df78636fbfaf2e88d4b220de66b0e60', '20081111', '2024-03-28 02:20:07');
INSERT INTO `user` VALUES (13, 'teacher2', '8129d266868d1e80fa20650b296ed7e0', 'af29b1dd8e1cad39550db260ffb7c996', '222222', '2024-03-29 04:53:47');
INSERT INTO `user` VALUES (14, 'student10', 'daa2f50ebfe9bf54323fa6dc42c4cd1b', 'bfcab2669a5a5195fc13b1de60cce8cf', '20081010', '2024-03-30 12:17:41');

-- ----------------------------
-- Table structure for yanzhengma
-- ----------------------------
DROP TABLE IF EXISTS `yanzhengma`;
CREATE TABLE `yanzhengma`  (
  `uuid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '验证码',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of yanzhengma
-- ----------------------------
INSERT INTO `yanzhengma` VALUES ('0005d3b8-20c5-40cc-9bc1-e7a3252e1a2c', '7k299');
INSERT INTO `yanzhengma` VALUES ('010ba89f-74f0-4cf6-a14e-0611fe1cb382', 'y0uwz');
INSERT INTO `yanzhengma` VALUES ('029c3ca6-f9ab-41ae-86f0-c580943cfa97', '7815e');
INSERT INTO `yanzhengma` VALUES ('037b8620-07e4-4a05-b2b3-c5bf9846a8c4', '8wq14');
INSERT INTO `yanzhengma` VALUES ('056d31a8-b06e-4191-8a1a-1150a4efad38', 'cso51');
INSERT INTO `yanzhengma` VALUES ('06ea0ede-0725-443d-96b1-9e49a6511d43', 'znquu');
INSERT INTO `yanzhengma` VALUES ('0902ea8b-d37f-4938-a81a-a44a77ef6553', 'bsndc');
INSERT INTO `yanzhengma` VALUES ('0945edf6-6570-46e6-8b93-7d0ca46c4d77', '211a8');
INSERT INTO `yanzhengma` VALUES ('0afc46bf-da35-4076-9855-a65b47c9b39c', 'tt89x');
INSERT INTO `yanzhengma` VALUES ('0afdada5-ffe3-4891-abf8-2700dd77a6b6', 'ithx6');
INSERT INTO `yanzhengma` VALUES ('0b5319c1-0fe3-4bfa-9f2a-b86c7b96d33c', 't4iip');
INSERT INTO `yanzhengma` VALUES ('0b8d192a-9d9e-4796-b088-87d6ac93a4ae', 'ko3pb');
INSERT INTO `yanzhengma` VALUES ('0eb9ee0f-886b-4805-b52a-3b09c8b21614', 'o0joy');
INSERT INTO `yanzhengma` VALUES ('12f5bfe3-4092-45e9-a977-aa6f5507c1b1', 'w54az');
INSERT INTO `yanzhengma` VALUES ('13528887-0903-455e-a697-a357a9d314ef', 'ayucs');
INSERT INTO `yanzhengma` VALUES ('150d5188-1b77-4c31-871f-19752fcbe561', 'u9q45');
INSERT INTO `yanzhengma` VALUES ('15fb0f47-0bf0-4a9c-969b-1581f7dea8c5', 'gqusn');
INSERT INTO `yanzhengma` VALUES ('162e4fd4-401a-49ca-beb8-0c45826198bd', 'cvdr6');
INSERT INTO `yanzhengma` VALUES ('171efcbe-78f0-4124-af08-1112add07220', 'zez6y');
INSERT INTO `yanzhengma` VALUES ('17446016-fbb2-4e94-b541-06090bdd1afe', 'ewdwx');
INSERT INTO `yanzhengma` VALUES ('17d59106-5532-44be-8e90-424a80b20764', 'a1a2a');
INSERT INTO `yanzhengma` VALUES ('17da0816-b8fc-4e32-b4f9-56add8e20095', 't3jf2');
INSERT INTO `yanzhengma` VALUES ('183ebb7b-1e03-4936-a2ea-698d6aeceb99', '28uzp');
INSERT INTO `yanzhengma` VALUES ('1871f2c7-bf2b-4451-a659-428b66091805', 'l17e3');
INSERT INTO `yanzhengma` VALUES ('18d3e082-bdc6-44eb-8b2c-095a64280e4c', 'qms6c');
INSERT INTO `yanzhengma` VALUES ('19a51908-32c7-46d7-9b55-f350744ed583', 'qfx3q');
INSERT INTO `yanzhengma` VALUES ('1a7650ac-2245-41c1-9b16-7e025827ced1', 'h5ac5');
INSERT INTO `yanzhengma` VALUES ('1aba298f-05bd-4d01-b1fd-13e32a68703f', '5ag6t');
INSERT INTO `yanzhengma` VALUES ('1b987d6b-4d49-4791-95b4-f232a16464bc', 'l0fdv');
INSERT INTO `yanzhengma` VALUES ('1cb26dfe-0115-4682-b138-0e812f772507', 'asfms');
INSERT INTO `yanzhengma` VALUES ('1cd83504-add9-468c-b94a-1f827766c8d7', 'w6a3w');
INSERT INTO `yanzhengma` VALUES ('1d500cb8-5f84-47fb-a84c-43edf970b454', 'twhg4');
INSERT INTO `yanzhengma` VALUES ('1d5db666-a435-4796-b6c4-3758acbc9368', 'iueqn');
INSERT INTO `yanzhengma` VALUES ('1d99660c-c7dd-4596-91c3-11a23efb0ae7', 'ylks8');
INSERT INTO `yanzhengma` VALUES ('1db32d9f-c8e9-4100-ad5f-f3b4c370c9e4', 'rrpbg');
INSERT INTO `yanzhengma` VALUES ('1dd1c59a-ed39-4a56-843e-44d8547e0909', 'v9dve');
INSERT INTO `yanzhengma` VALUES ('1dd22b23-39c5-47bd-9737-d4684c5847bb', 'fh3mn');
INSERT INTO `yanzhengma` VALUES ('1f1f4eba-b662-45a8-9f10-401709a6944b', 'pgxml');
INSERT INTO `yanzhengma` VALUES ('1fd0d8dc-8873-4c41-8694-ec78ae27a4a3', '6agr8');
INSERT INTO `yanzhengma` VALUES ('20808368-5b59-4a65-80ce-782641b348e8', 'sekmj');
INSERT INTO `yanzhengma` VALUES ('20e24efe-8486-4811-a62d-2ebb415ae4b0', 'zy0ss');
INSERT INTO `yanzhengma` VALUES ('22cea20c-b24e-4728-88b4-a65b78ccdb4d', 'j7zxe');
INSERT INTO `yanzhengma` VALUES ('245fb901-99b9-44fa-8cf5-483722469826', 'j7tjc');
INSERT INTO `yanzhengma` VALUES ('2467f2c7-51ae-421c-bfb3-4a005d7342aa', '3euh7');
INSERT INTO `yanzhengma` VALUES ('26516c1d-bf7d-4e03-85e5-7980b1d12f91', '55s5r');
INSERT INTO `yanzhengma` VALUES ('26f47a84-a055-4314-9454-fa2889774a15', 'oct6h');
INSERT INTO `yanzhengma` VALUES ('26f7b6a9-5224-4b6b-9280-5311df4ca2b2', 'kwnsn');
INSERT INTO `yanzhengma` VALUES ('28e95ffd-0948-4de1-93a7-29bb4e9674bc', '6ltan');
INSERT INTO `yanzhengma` VALUES ('29395040-c4a1-41c2-9394-d5d08f9d1065', 'r0cxk');
INSERT INTO `yanzhengma` VALUES ('299df921-0a45-4848-a720-7e819b6526f5', 'x51td');
INSERT INTO `yanzhengma` VALUES ('2a66b193-f775-432f-8c19-4ca7f01ef193', '9lcpb');
INSERT INTO `yanzhengma` VALUES ('2ac6ece4-4ab8-4a62-bd2c-d17f67780efd', 'wf8yr');
INSERT INTO `yanzhengma` VALUES ('2cbf7d07-492e-423c-b0f5-32f810723003', 'qk4jo');
INSERT INTO `yanzhengma` VALUES ('2dad0c0c-1dbb-4611-ac5f-15e969049608', '6dg9d');
INSERT INTO `yanzhengma` VALUES ('303c1ee1-5788-40ac-947a-c849c05b13d8', 'w2ono');
INSERT INTO `yanzhengma` VALUES ('30907098-76a0-44e2-8dac-1644647601f8', '33hs7');
INSERT INTO `yanzhengma` VALUES ('31f91232-f706-4c88-9776-525cf002e8fb', 'h1tjn');
INSERT INTO `yanzhengma` VALUES ('32f28465-f0ce-41bd-b2c5-cb0c07223958', 'aaks3');
INSERT INTO `yanzhengma` VALUES ('360c351b-923a-4690-867a-5845a90273ee', 'xn21q');
INSERT INTO `yanzhengma` VALUES ('36599c11-2d3a-4bf8-94b7-02e823d82381', '4g0gm');
INSERT INTO `yanzhengma` VALUES ('36d268a8-3079-4fb9-8366-3192e5df9ed2', '4r27m');
INSERT INTO `yanzhengma` VALUES ('387989da-5fdb-4e40-883d-c588a3b9ab6a', 'o21k4');
INSERT INTO `yanzhengma` VALUES ('38c7a6b2-3774-4db1-8c2c-5c2cd362d5d9', 'i2boz');
INSERT INTO `yanzhengma` VALUES ('3d1a9e0f-a16b-4b43-b441-92d3db669bda', 'jbpmo');
INSERT INTO `yanzhengma` VALUES ('3d62ebdd-a314-4aac-804c-550a43c3bc66', 'qayst');
INSERT INTO `yanzhengma` VALUES ('402e8edf-e7b5-4f30-8121-aaf84f6d4e40', '5mbg9');
INSERT INTO `yanzhengma` VALUES ('40871736-4763-4aa4-b1e2-785fa939c876', 'fkpnu');
INSERT INTO `yanzhengma` VALUES ('409474b4-a4cd-4924-99e2-9bdf195c7ff5', 'dgssi');
INSERT INTO `yanzhengma` VALUES ('40a6603e-24f6-4347-832f-7831749cf260', 'fccxk');
INSERT INTO `yanzhengma` VALUES ('41ae6c58-f2c4-4aaa-bee7-7948ad4e6089', 'p3vwj');
INSERT INTO `yanzhengma` VALUES ('4214f194-ee07-4d6e-8434-c9449f841c04', 'sj7yf');
INSERT INTO `yanzhengma` VALUES ('44e0f34c-20b1-475b-a93e-6902be890cd1', 'w6i3u');
INSERT INTO `yanzhengma` VALUES ('45c5a72f-f85b-4fa9-9c64-d17e639f2bd9', '1etq0');
INSERT INTO `yanzhengma` VALUES ('463be529-f3ba-4471-b8e1-37e77b3381d7', 'kt9nb');
INSERT INTO `yanzhengma` VALUES ('4776f478-3376-4ef7-919c-61545e70dbdf', 'jug0a');
INSERT INTO `yanzhengma` VALUES ('4864ba91-0cfd-47e4-8f9b-7c5149d7f699', 'yub1v');
INSERT INTO `yanzhengma` VALUES ('486953d1-9f37-4ebc-bc2b-09296a3bb350', '0kef4');
INSERT INTO `yanzhengma` VALUES ('4d4aba36-bb07-49ae-8576-5ab98b7e0e55', 'av9mk');
INSERT INTO `yanzhengma` VALUES ('4d4bf5b5-cf57-4e1b-b6d3-5cfa583f7e4d', 'lb8pq');
INSERT INTO `yanzhengma` VALUES ('4e315e31-75ca-47b0-82a4-104fc8157b2c', 'alkh5');
INSERT INTO `yanzhengma` VALUES ('500d1e07-4d4f-483a-b951-85387a56627c', 'dj16o');
INSERT INTO `yanzhengma` VALUES ('50171567-8176-4d37-958b-3a203dc8b0d6', 'yj8jc');
INSERT INTO `yanzhengma` VALUES ('509bb874-2d27-43f7-89ae-42181aaaa16c', 'rrxnn');
INSERT INTO `yanzhengma` VALUES ('518aca66-bb4d-4147-9eba-a2e7d490836a', 'i8s4a');
INSERT INTO `yanzhengma` VALUES ('51ae1cfe-8e5a-44b6-b7fb-3a3394203efb', '3z2jb');
INSERT INTO `yanzhengma` VALUES ('52cc2066-953d-41ab-b807-6a92fc622f8f', 'nwett');
INSERT INTO `yanzhengma` VALUES ('52f23776-6f77-4764-a795-0a2937b35421', 'ye1t0');
INSERT INTO `yanzhengma` VALUES ('53597e30-b3a2-4fbb-b7c1-48daf67e48dd', '9taem');
INSERT INTO `yanzhengma` VALUES ('53cf117a-2d43-483b-adab-f02c941df57b', 'r6bye');
INSERT INTO `yanzhengma` VALUES ('54abcdba-6a0b-43a7-8284-9badc62c6f36', 'ggku8');
INSERT INTO `yanzhengma` VALUES ('56422418-f314-4a59-a6a5-a458d32e02de', 'g4zra');
INSERT INTO `yanzhengma` VALUES ('5653d7f2-1676-48f4-811d-a892b234049e', '60zj3');
INSERT INTO `yanzhengma` VALUES ('580e9ff3-c253-4319-9a60-2bd2ad49f87d', 'r9p0b');
INSERT INTO `yanzhengma` VALUES ('58a27dc8-fb53-432b-ad90-75fe9425134c', 'bxk1w');
INSERT INTO `yanzhengma` VALUES ('58c2c28d-a481-47b3-bb7c-f0d61245bf1d', '5rs1f');
INSERT INTO `yanzhengma` VALUES ('5da635e7-e716-4b37-bd05-1aec4cb76847', 'hjq8o');
INSERT INTO `yanzhengma` VALUES ('5ee5fefe-d9cf-49e4-9e7a-6b1feebb590d', 'vq5kd');
INSERT INTO `yanzhengma` VALUES ('5ee66205-7301-4472-b245-bdede4583d39', 'n7ljl');
INSERT INTO `yanzhengma` VALUES ('5f03beaf-13b8-40dc-81c1-8479295917f4', '9qnif');
INSERT INTO `yanzhengma` VALUES ('5f506ca5-7979-4b2c-b622-107b09e2e23c', 'o06p1');
INSERT INTO `yanzhengma` VALUES ('5f70e569-c2e1-4f27-bf7f-adabf4ae74c9', 'nm1pj');
INSERT INTO `yanzhengma` VALUES ('62fbbb93-a90f-45f4-b7e6-eb0b72f712f7', '2qmmj');
INSERT INTO `yanzhengma` VALUES ('630034c9-4a07-4f87-9463-e66a843270d7', 'fosms');
INSERT INTO `yanzhengma` VALUES ('63093129-42a2-44b5-a03c-dd52fbe8f91f', '0rrpk');
INSERT INTO `yanzhengma` VALUES ('63376eaf-3016-48fe-90b6-19bfbf95d31f', 'h6a6h');
INSERT INTO `yanzhengma` VALUES ('64cda974-75df-4a3f-bdc9-eef6111be213', '6ogu8');
INSERT INTO `yanzhengma` VALUES ('64f4953b-5232-48b8-8d7f-9d27a3e5c453', '1krq2');
INSERT INTO `yanzhengma` VALUES ('65f85535-ead2-4335-9e93-185612fdf5d8', 'n073x');
INSERT INTO `yanzhengma` VALUES ('663d0327-6bc6-46c0-b75e-92fc0814ecef', 'rdkj8');
INSERT INTO `yanzhengma` VALUES ('667d04ca-0be5-48f2-8dc4-d4f0e8b5a0b1', 'w5oe6');
INSERT INTO `yanzhengma` VALUES ('66b0515b-7a41-408e-8c4d-ec77ee60e1d9', 'l64g3');
INSERT INTO `yanzhengma` VALUES ('66f5ce9d-18f8-4410-b8bb-fde6ac88dc2b', '98h46');
INSERT INTO `yanzhengma` VALUES ('67a99d3b-b0b7-4dd2-84bc-9bf83089a5f0', '6hi6u');
INSERT INTO `yanzhengma` VALUES ('6914bc94-f4dc-44a8-a55e-55085bcb3a0f', '76zfs');
INSERT INTO `yanzhengma` VALUES ('691fa665-dfc2-4a9d-84ce-d1a0f887457a', '2c8gg');
INSERT INTO `yanzhengma` VALUES ('6920c2fc-0be0-4898-983d-30024cfeac28', '0eeay');
INSERT INTO `yanzhengma` VALUES ('69458e47-6d79-4973-949d-06e3373d47b9', 'kcxki');
INSERT INTO `yanzhengma` VALUES ('6a84c8df-c7c1-4432-acdc-709c2b596194', 'd6x7f');
INSERT INTO `yanzhengma` VALUES ('6f1cfc0d-8335-452c-8355-129a369965dc', 'jhgkk');
INSERT INTO `yanzhengma` VALUES ('6f38f000-81a6-45f0-8401-6a8d4894a74f', 'bly1q');
INSERT INTO `yanzhengma` VALUES ('6feaac88-4067-4e3d-82f0-a8ded5a439fe', '1mj96');
INSERT INTO `yanzhengma` VALUES ('6ff10c47-36f5-4568-a803-4bdf6634ef3a', 'jdnlm');
INSERT INTO `yanzhengma` VALUES ('706849a1-f976-40e2-b8f2-d4ce7810259c', 'urttw');
INSERT INTO `yanzhengma` VALUES ('71f3595e-ee32-403d-99fc-19821120aad2', 'awjz4');
INSERT INTO `yanzhengma` VALUES ('7250eb86-4214-4361-8e95-a4a13a5aae45', 'nz4yz');
INSERT INTO `yanzhengma` VALUES ('73a62336-d85b-4d80-af45-a29689945f20', 'a2kkg');
INSERT INTO `yanzhengma` VALUES ('77317ebc-8673-46a1-91c3-f8604dc8737f', '1x67l');
INSERT INTO `yanzhengma` VALUES ('77fd1e1c-8a07-463e-85aa-7894b8feadc1', 'lgn0k');
INSERT INTO `yanzhengma` VALUES ('785d1a23-0642-4e4f-9158-dd67a6c35936', 'xs5uy');
INSERT INTO `yanzhengma` VALUES ('7b14cf90-ad5f-4c0b-9231-7cd62713fc00', 'n4vec');
INSERT INTO `yanzhengma` VALUES ('7b9032ea-4fdd-4d33-9421-40bdabd700ed', 'tc3aa');
INSERT INTO `yanzhengma` VALUES ('7e0ed668-271d-4273-8528-4983056389a4', '6lb9s');
INSERT INTO `yanzhengma` VALUES ('7f80b5ce-4c6e-41b9-9b49-173a0e8bb365', 'pluum');
INSERT INTO `yanzhengma` VALUES ('805198a9-4f98-42fa-8540-fa01c3fb9b5a', 'txapt');
INSERT INTO `yanzhengma` VALUES ('81a4abda-4cba-4d2f-92c2-f9fe41f60080', 'oc99v');
INSERT INTO `yanzhengma` VALUES ('82b46f51-487e-4896-a926-d02bf3010bed', 'xfec5');
INSERT INTO `yanzhengma` VALUES ('82ce2f6a-67b3-40ff-a483-7093b64ce971', 'd1lmd');
INSERT INTO `yanzhengma` VALUES ('82f219f9-f380-4dce-a034-0623331a6da3', 'rh3s7');
INSERT INTO `yanzhengma` VALUES ('836a8ff3-7e24-4242-91c8-a5e802df919b', 'anxyw');
INSERT INTO `yanzhengma` VALUES ('8491efb7-74b6-438a-81fc-f3f62cae42d7', 'cfqzg');
INSERT INTO `yanzhengma` VALUES ('84bc0ed3-39ef-4d44-9f22-071402a7ab8f', 'iez4o');
INSERT INTO `yanzhengma` VALUES ('86d26285-83c2-453c-91af-0cb669761dc8', 'nq4pv');
INSERT INTO `yanzhengma` VALUES ('87e76b37-800c-4708-b740-d3eb8625373a', 'al0zv');
INSERT INTO `yanzhengma` VALUES ('8918139b-54bb-43ce-9266-88bd0ca5915b', 'iv6q1');
INSERT INTO `yanzhengma` VALUES ('8968c73a-3e15-49af-a98c-07a3f219e116', '9hw1i');
INSERT INTO `yanzhengma` VALUES ('89aaaf39-8177-4152-b8b6-62d4f4a8e82c', '7mo5g');
INSERT INTO `yanzhengma` VALUES ('8b0b4380-9a11-4ac5-a426-5da8e4165322', '9wao9');
INSERT INTO `yanzhengma` VALUES ('8d9f3e39-de43-4db1-a126-1c9d3b184053', 'yneyn');
INSERT INTO `yanzhengma` VALUES ('9001347b-cb21-44ef-a519-b623bc75b00d', 'o9uug');
INSERT INTO `yanzhengma` VALUES ('906defc7-e12d-48e6-a1bf-42e3220fe18f', 'syxvc');
INSERT INTO `yanzhengma` VALUES ('9234c23a-1b0d-45d7-b471-ecaa21e865c7', 'xc5ap');
INSERT INTO `yanzhengma` VALUES ('923ea26b-62a7-4672-a10e-8b42e910294a', 'i4s5v');
INSERT INTO `yanzhengma` VALUES ('9324f104-7c08-448a-95f7-e2127f1afa65', '9hzpf');
INSERT INTO `yanzhengma` VALUES ('95e0a106-5ecb-43e3-960a-a350df049e23', '1h2fw');
INSERT INTO `yanzhengma` VALUES ('960b9298-f9ee-408a-a6b5-a0c0f716a9f4', 'tr65h');
INSERT INTO `yanzhengma` VALUES ('972665fc-f5bb-4cb9-8690-2142d47ae2f9', 'nwq6z');
INSERT INTO `yanzhengma` VALUES ('9a03bf72-ee30-48ee-b9ed-d8893b991cd6', 'vevol');
INSERT INTO `yanzhengma` VALUES ('9a6cb915-fe34-4fe1-93b5-fa824e648b35', 'wsb6m');
INSERT INTO `yanzhengma` VALUES ('9b036958-6285-4011-9f66-58726d54694b', 'e7ojq');
INSERT INTO `yanzhengma` VALUES ('9ca57523-20ab-44d6-94fe-41fb4efa6e9b', 'jna60');
INSERT INTO `yanzhengma` VALUES ('9d54073e-2985-4d37-a85b-36fc924385a3', 'qmu4v');
INSERT INTO `yanzhengma` VALUES ('9e6e2ebb-21eb-4cde-9012-591782d03435', '9xxjl');
INSERT INTO `yanzhengma` VALUES ('9fc2914d-4fac-4e67-baf3-db0ca5f7ab73', 'ankyj');
INSERT INTO `yanzhengma` VALUES ('a2545a78-5a43-4fd0-900f-fee8d8f80464', 't2mvx');
INSERT INTO `yanzhengma` VALUES ('a5405e52-95ef-4ad1-bafa-8280f0186612', '25zaw');
INSERT INTO `yanzhengma` VALUES ('a5e292aa-dfc0-43cc-981e-92bc3a5ee142', 'atmbi');
INSERT INTO `yanzhengma` VALUES ('a6336b5d-d5a8-434d-a407-cbd7de8f7dcd', '6dehx');
INSERT INTO `yanzhengma` VALUES ('a7a1e7ba-368e-4fb1-8970-e98bde3ac649', 'lftlq');
INSERT INTO `yanzhengma` VALUES ('a7e5a322-f6db-4e8d-a981-05a1b1a9afe6', 'x8fr0');
INSERT INTO `yanzhengma` VALUES ('a81f030e-2395-441d-98b7-c6ec316c63fa', 'ceqq7');
INSERT INTO `yanzhengma` VALUES ('a8f2cb42-f444-4b4a-afcd-1c3103409b80', 'x97ss');
INSERT INTO `yanzhengma` VALUES ('a975c5bf-2e83-43f0-b756-3fc005da8174', 'ezzo3');
INSERT INTO `yanzhengma` VALUES ('a9d3cfc4-85d9-4913-afeb-e2473ef3c3f5', '7jve9');
INSERT INTO `yanzhengma` VALUES ('aad80433-9ef6-4d9c-a793-114e939e424c', '89xmr');
INSERT INTO `yanzhengma` VALUES ('ab29bf71-1a09-4c19-b0b9-bb309092331c', '07yy2');
INSERT INTO `yanzhengma` VALUES ('ac8232f6-74f8-4ac3-aeac-b27c5fd1f711', '9phha');
INSERT INTO `yanzhengma` VALUES ('ad863015-e402-4fb8-bc3b-57d7a1f871ed', 'ojukk');
INSERT INTO `yanzhengma` VALUES ('ad924754-1f97-4706-807f-ea1b8359a056', '99oka');
INSERT INTO `yanzhengma` VALUES ('add444fe-b436-4206-9766-1cb9ccf4711a', '3wrms');
INSERT INTO `yanzhengma` VALUES ('ae9b1842-429d-4e43-ac59-dcd0ce79800b', 'eaadz');
INSERT INTO `yanzhengma` VALUES ('b3227ca0-58c5-477d-9293-a2e1c5afc755', '4abjb');
INSERT INTO `yanzhengma` VALUES ('b40acd39-ba5d-4087-9e42-447fef8627b6', 'vyruy');
INSERT INTO `yanzhengma` VALUES ('b58fca5d-a7b1-4dd0-b625-9f5e33d3e508', 'd73f0');
INSERT INTO `yanzhengma` VALUES ('b65e9d56-4730-463c-93c6-fe19c12df91e', 'rq8xp');
INSERT INTO `yanzhengma` VALUES ('b7afb98a-395e-43fd-b550-8c4f27b9fe85', 'd1vks');
INSERT INTO `yanzhengma` VALUES ('b849b051-b824-4c6a-835e-a03b15e53a78', 'z3c5q');
INSERT INTO `yanzhengma` VALUES ('b8b77dcf-30c4-4acd-96db-1737368c7f54', 'm6xv8');
INSERT INTO `yanzhengma` VALUES ('bb7967b5-0ba1-4efd-9380-9258f0fae303', 'v1tgr');
INSERT INTO `yanzhengma` VALUES ('bc68cc06-fc9a-4ade-8a99-f54b64064e1a', '1qp3d');
INSERT INTO `yanzhengma` VALUES ('be070c9a-3db5-4450-8412-a57e41686e8c', 'e966a');
INSERT INTO `yanzhengma` VALUES ('bf6fa607-aa28-4aec-853b-30033babc864', 'vuta4');
INSERT INTO `yanzhengma` VALUES ('bfdb5f44-3340-4f66-9ed7-d25a29d2fc29', 'jh6gu');
INSERT INTO `yanzhengma` VALUES ('c02c710f-2e55-400b-bf3a-c08942a36ed8', '0bmgg');
INSERT INTO `yanzhengma` VALUES ('c051da42-9c04-4446-80be-10ea54f0880b', 'aop32');
INSERT INTO `yanzhengma` VALUES ('c174882c-d030-4751-b541-5d25eaea0ac6', '9hxbo');
INSERT INTO `yanzhengma` VALUES ('c20f4d21-fe93-4101-862a-3f120b1cb355', 'aiz1p');
INSERT INTO `yanzhengma` VALUES ('c2e70bc2-6b53-4c29-bfec-7b7158bf5d28', '0o5ou');
INSERT INTO `yanzhengma` VALUES ('c4d86a59-e7b7-4795-8705-0a88b570b016', 'ig0bh');
INSERT INTO `yanzhengma` VALUES ('c739ad4f-827a-4e28-a992-e2c12047883d', 'k8qwr');
INSERT INTO `yanzhengma` VALUES ('c7aefbd2-497a-4f03-a0d4-55c01ef1a645', 'crbyx');
INSERT INTO `yanzhengma` VALUES ('c95b1b11-3265-4ef9-8797-386d33d24c85', '3ptvz');
INSERT INTO `yanzhengma` VALUES ('caa8e7be-8e06-44ab-8e40-12e503327d14', '0r3gi');
INSERT INTO `yanzhengma` VALUES ('cc44805f-d29c-4f2d-aba8-2960dd086a7b', 'r7zg3');
INSERT INTO `yanzhengma` VALUES ('cc7b5416-be89-4550-96bd-8eeaa5c10240', 'vvb90');
INSERT INTO `yanzhengma` VALUES ('cc9f343a-fbae-40cd-928c-f860b54c744d', 'r3okj');
INSERT INTO `yanzhengma` VALUES ('cd40684b-342a-43c3-bf3b-65682ef91ed1', 'g5d9q');
INSERT INTO `yanzhengma` VALUES ('cffa5082-4c5c-4769-8a93-4d1e4958ecb0', 'dthym');
INSERT INTO `yanzhengma` VALUES ('d04d2baa-89c8-4361-8273-45f25a51ac4f', 'wl21e');
INSERT INTO `yanzhengma` VALUES ('d0d80e25-d073-4b34-a6c2-e1a211fc6ec7', 'rprcf');
INSERT INTO `yanzhengma` VALUES ('d1bf4584-ce39-4e77-891d-0b2e6ddd5874', '59xn9');
INSERT INTO `yanzhengma` VALUES ('d388905d-f7b4-4f53-a143-96ef4d7e6803', '6miwp');
INSERT INTO `yanzhengma` VALUES ('d4013319-00a6-44fa-9959-150b317276b2', '3p11c');
INSERT INTO `yanzhengma` VALUES ('d41889da-22fc-4699-b945-30eb7c5adf26', '79m1s');
INSERT INTO `yanzhengma` VALUES ('d59d2893-8803-4865-acd4-6688ddff2163', 'ebefy');
INSERT INTO `yanzhengma` VALUES ('d5ae07f2-d20c-4694-a4f5-b9773b9694b6', 'gz9o5');
INSERT INTO `yanzhengma` VALUES ('d785455d-05ba-4fc2-9edf-fac20f59ec2a', '87j4s');
INSERT INTO `yanzhengma` VALUES ('d7f1ab2b-2c56-41c0-b964-99dd6eb26970', 'iznjl');
INSERT INTO `yanzhengma` VALUES ('d915aeaa-d9a5-4e76-9376-24d2890668d4', 'jrpkh');
INSERT INTO `yanzhengma` VALUES ('db44237a-f285-4dd1-be54-4f31d8c9e51d', 'bi3v0');
INSERT INTO `yanzhengma` VALUES ('db75c95a-a015-479f-9e6e-ca5877e59bf5', 'voguc');
INSERT INTO `yanzhengma` VALUES ('dc9e14b2-094b-4cc0-8fc9-804f0790e35c', 'r6zeg');
INSERT INTO `yanzhengma` VALUES ('ddcc8390-bbce-4d11-8096-4b719992ede0', 'sk0rx');
INSERT INTO `yanzhengma` VALUES ('e02bdd2f-bb8f-4475-96f3-36fa2d7c6129', 'ixcqx');
INSERT INTO `yanzhengma` VALUES ('e077952b-446d-44e9-8001-c90e6528ceb9', 'eirn6');
INSERT INTO `yanzhengma` VALUES ('e131e5e0-dd17-4ee4-b268-f6d71c0927cb', 'ew7iy');
INSERT INTO `yanzhengma` VALUES ('e1dc0ae1-49f9-413e-a8e2-04e27a7b7a6d', 'ounbi');
INSERT INTO `yanzhengma` VALUES ('e7389a16-9d76-4a14-a4cd-fe7accf8b35e', 'hmekw');
INSERT INTO `yanzhengma` VALUES ('e7628aac-9759-44ba-9a94-40b9ca5e974c', '956yq');
INSERT INTO `yanzhengma` VALUES ('e8663dcf-7af6-47c3-b247-9e190fb2e6b9', '212g3');
INSERT INTO `yanzhengma` VALUES ('e960e8d7-8819-4cc6-b122-87c2e21bed19', 'p1bvs');
INSERT INTO `yanzhengma` VALUES ('e9d2b8b6-e2e5-400e-a8a6-b49bf8f3e2a1', 'm0m6l');
INSERT INTO `yanzhengma` VALUES ('ebbf17c2-c2c4-439d-b6f7-d4af31bac737', '539x8');
INSERT INTO `yanzhengma` VALUES ('ece64ccf-74f7-4d29-9a98-348f3f21e4f4', 'gidew');
INSERT INTO `yanzhengma` VALUES ('ef54578f-812f-4261-9c55-406b9db83c04', '207cj');
INSERT INTO `yanzhengma` VALUES ('f04ec84f-eae6-4b85-bdcb-1b46abdf2c63', 'n1x74');
INSERT INTO `yanzhengma` VALUES ('f097b3e0-911c-446f-8190-e3a32f4cbb34', '862tz');
INSERT INTO `yanzhengma` VALUES ('f16bdab7-3002-4e0c-a5c6-eb296e5a42a5', 'o68kp');
INSERT INTO `yanzhengma` VALUES ('f23235b7-0c02-4e75-86c9-3dcd6077ff0c', '8jvwx');
INSERT INTO `yanzhengma` VALUES ('f33ba0dd-94d8-4b8a-9ac4-03b10e376b95', 'mw5j4');
INSERT INTO `yanzhengma` VALUES ('f5a9df78-f0e7-4f96-8295-298cac522c43', 'wt9uh');
INSERT INTO `yanzhengma` VALUES ('f5b999ed-7297-4de0-904e-198c0b05eb22', '0zd6w');
INSERT INTO `yanzhengma` VALUES ('f6ea8f44-f343-497a-ad0b-0a8537184a8e', 'vvbod');
INSERT INTO `yanzhengma` VALUES ('fc05f10e-ddf8-44e7-b7d0-2713ffbe959d', 'vw3nb');
INSERT INTO `yanzhengma` VALUES ('fc967c4a-0ee8-4ca6-9ff9-a0c96d0d2de1', 'hjkna');
INSERT INTO `yanzhengma` VALUES ('fccb6638-fd03-4c84-8da3-76efa5714833', 'chkum');
INSERT INTO `yanzhengma` VALUES ('fddf9f07-f3fd-42f4-a0ef-436ae9afee15', 'p9030');
INSERT INTO `yanzhengma` VALUES ('fe45d31a-ad94-4276-bdda-7eb9780e04d4', 'kxxhs');

-- ----------------------------
-- Table structure for zxj
-- ----------------------------
DROP TABLE IF EXISTS `zxj`;
CREATE TABLE `zxj`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zxj_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `zxj_money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `zxj_tiaojian` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `work_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建助学金的辅导员工号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1206890504 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zxj
-- ----------------------------
INSERT INTO `zxj` VALUES (1206890499, '助学金1', '金额1', '条件1', '111111');
INSERT INTO `zxj` VALUES (1206890500, '助学金2', '金额2', '条件2', '111111');
INSERT INTO `zxj` VALUES (1206890501, '助学金3', '金额3', '条件3', '111111');
INSERT INTO `zxj` VALUES (1206890502, '助学金4', '金额4', '条件4', '111111');
INSERT INTO `zxj` VALUES (1206890503, '助学金5', '金额5', '条件5\n', '111111');

SET FOREIGN_KEY_CHECKS = 1;
