/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : localhost:3306
 Source Schema         : sims

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 28/05/2020 00:12:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `a_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `a_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for college_department_class
-- ----------------------------
DROP TABLE IF EXISTS `college_department_class`;
CREATE TABLE `college_department_class`  (
  `college` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cclass` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`college`, `department`, `cclass`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of college_department_class
-- ----------------------------
INSERT INTO `college_department_class` VALUES ('应用数学学院', '数学', '数学1');
INSERT INTO `college_department_class` VALUES ('应用数学学院', '数学', '数学2');
INSERT INTO `college_department_class` VALUES ('应用数学学院', '数理基础科学', '数理基础1');
INSERT INTO `college_department_class` VALUES ('应用数学学院', '数理基础科学', '数理基础2');
INSERT INTO `college_department_class` VALUES ('软件工程学院', '新媒体', '18新媒体1');
INSERT INTO `college_department_class` VALUES ('软件工程学院', '新媒体', '18新媒体2');
INSERT INTO `college_department_class` VALUES ('软件工程学院', '软件工程', '18软件(理软)1');
INSERT INTO `college_department_class` VALUES ('软件工程学院', '软件工程', '18软件(理软)2');
INSERT INTO `college_department_class` VALUES ('软件工程学院', '软件工程', '19软件(理软)1');
INSERT INTO `college_department_class` VALUES ('软件工程学院', '软件工程', '19软件(理软)2');

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cdate` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of complaint
-- ----------------------------
INSERT INTO `complaint` VALUES (1, '2020-05-02 17:40:17', '这是第一条小吐槽哦');
INSERT INTO `complaint` VALUES (2, '2020-05-02 18:07:51', '哈哈哈，界面不错');
INSERT INTO `complaint` VALUES (3, '2020-05-02 18:09:33', '可以的兄弟');
INSERT INTO `complaint` VALUES (4, '2020-05-02 18:16:24', '我测试下');
INSERT INTO `complaint` VALUES (31, '2020-05-02 21:05:26', 'input');
INSERT INTO `complaint` VALUES (32, '2020-05-20 19:07:45', '我我我我');
INSERT INTO `complaint` VALUES (33, '2020-05-26 22:41:34', 'input/');
INSERT INTO `complaint` VALUES (36, '2020-05-27 17:59:14', '<h1 style=\"font-style: italic;\"><ins>灌灌灌灌灌过过fffffdsfljhidldf</ins></h1>\r\n\r\n<ul>\r\n	<li>\r\n	<h1 style=\"font-style: italic;\"><ins>sFFDSFS</ins></h1>\r\n	</li>\r\n	<li><ins>23234234asd</ins></li>\r\n</ul>\r\n');
INSERT INTO `complaint` VALUES (45, '2020-05-27 20:36:37', '<h2><s>做个测试啊</s></h2>\r\n\r\n<p><s><img alt=\"t\" src=\"https://cdn.yoyling.com/2020/05/github-speed/github-speed.jpg\" style=\"height:111px; width:200px\" /></s></p>\r\n');
INSERT INTO `complaint` VALUES (47, '2020-05-27 20:42:28', '<p><img alt=\"smiley\" src=\"https://cdn.ckeditor.com/4.14.0/full/plugins/smiley/images/regular_smile.png\" style=\"height:23px; width:23px\" title=\"smiley\" /><img alt=\"laugh\" src=\"https://cdn.ckeditor.com/4.14.0/full/plugins/smiley/images/teeth_smile.png\" style=\"height:23px; width:23px\" title=\"laugh\" /><img alt=\"yes\" src=\"https://cdn.ckeditor.com/4.14.0/full/plugins/smiley/images/thumbs_up.png\" style=\"height:23px; width:23px\" title=\"yes\" />Nice</p>\r\n');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `c_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_info` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `t_id`(`t_id`) USING BTREE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('c1111', 'java进阶', '9912123206', '关于java进阶的故事啊啊啊啊');
INSERT INTO `course` VALUES ('c1113', '软件测试', '9912123206', '软件测试课程');
INSERT INTO `course` VALUES ('cccc', 'as撒大大', '9912123206', '第三方爽肤水发顺丰所ddd');
INSERT INTO `course` VALUES ('ye_course_124', 'JVM虚拟机性能优化', '9912123205', '巴拉巴拉巴拉巴拉巴拉巴拉巴拉巴拉巴拉巴拉');

-- ----------------------------
-- Table structure for notify
-- ----------------------------
DROP TABLE IF EXISTS `notify`;
CREATE TABLE `notify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notifyDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `notifyInfo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notify
-- ----------------------------
INSERT INTO `notify` VALUES (3, '2020-04-24 15:36:22', '222222222222222222');
INSERT INTO `notify` VALUES (4, '2020-04-24 15:36:22', '奥术大师所所所所所所所所所所所所所所所所所所所所所所所');
INSERT INTO `notify` VALUES (5, '2020-04-24 15:36:22', '这是一条测试文本啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊');
INSERT INTO `notify` VALUES (16, '2020-04-24 18:51:15', '这是4.24最新公告，仅供测试');
INSERT INTO `notify` VALUES (17, '2020-04-24 19:40:45', '测试发布公告');
INSERT INTO `notify` VALUES (18, '2020-04-24 19:42:40', '敖德萨大萨达大所多');
INSERT INTO `notify` VALUES (22, '2020-04-24 20:34:00', '2111111111111');
INSERT INTO `notify` VALUES (23, '2020-04-24 20:42:31', '4.24最新公告');
INSERT INTO `notify` VALUES (24, '2020-04-24 20:44:30', '2020.4.24最新公告哈哈哈哈还好哈哈哈哈还好哈哈哈哈还好或或或或');
INSERT INTO `notify` VALUES (25, '2020-04-24 20:49:35', '增加几个查询模块');
INSERT INTO `notify` VALUES (26, '2020-04-24 21:00:14', '增加管理员公告发布');
INSERT INTO `notify` VALUES (28, '2020-05-01 22:06:35', '增加学生端选课系统，增加修改用户信息，修改密码功能');
INSERT INTO `notify` VALUES (29, '2020-05-13 12:20:10', '增加学生分页功能，管理端添加学生选中列表删除，添加全选');
INSERT INTO `notify` VALUES (30, '2020-05-18 23:39:16', '增加文件传输服务，管理上传，全员可下载，任意大小类型');
INSERT INTO `notify` VALUES (31, '2020-05-27 18:29:16', '小吐槽增加富文本编辑器，开源CKEditor 4');

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `photo_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0.jpg',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `photo_id`(`photo_id`) USING BTREE,
  CONSTRAINT `photo_ibfk_1` FOREIGN KEY (`photo_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES (10, '1812123206', '1812123206.jpg');
INSERT INTO `photo` VALUES (11, '1812123205', '1812123205.jpg');

-- ----------------------------
-- Table structure for select_course
-- ----------------------------
DROP TABLE IF EXISTS `select_course`;
CREATE TABLE `select_course`  (
  `s_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`s_id`, `c_id`) USING BTREE,
  INDEX `s_id`(`s_id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE,
  CONSTRAINT `select_course_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `select_course_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of select_course
-- ----------------------------
INSERT INTO `select_course` VALUES ('1812123205', 'c1111', '70');
INSERT INTO `select_course` VALUES ('1812123205', 'c1113', NULL);
INSERT INTO `select_course` VALUES ('1812123205', 'cccc', NULL);
INSERT INTO `select_course` VALUES ('1812123206', 'c1111', '10');
INSERT INTO `select_course` VALUES ('1812123206', 'c1113', NULL);
INSERT INTO `select_course` VALUES ('1812123206', 'cccc', NULL);
INSERT INTO `select_course` VALUES ('5555555555', 'ye_course_124', '60');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `s_college` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '待分配',
  `s_department` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '待分配',
  `s_class` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '待分配',
  `s_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_age` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_address` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1111111111', '软件工程学院', '软件工程', '18软件(理软)1', '陈毅', '男', '19', '福建', '12131231', '22@qq.com', '123');
INSERT INTO `student` VALUES ('1111111112', '待分配', '待分配', '待分配', '哈哈哈', '女', '19', '敖德萨', '23136456', '123@qq.com', '123');
INSERT INTO `student` VALUES ('1111111113', '待分配', '待分配', '待分配', '大大大', '男', '19', '福建', '231335353', '123@qq.com', '123');
INSERT INTO `student` VALUES ('1111111114', '待分配', '待分配', '待分配', '仍然让', '男', '19', '福建', '2313124325', '123@qq.com', '123');
INSERT INTO `student` VALUES ('1231231231', '待分配', '待分配', '待分配', '上官怡蓝', '女', '20', '西藏', '233245', '1@icloud.com', '123');
INSERT INTO `student` VALUES ('1231238768', '应用数学学院', '数学', '数学1', '陈欣', '女', '19', '福建', '23136457', '123@qq.com', '123');
INSERT INTO `student` VALUES ('1234567890', '软件工程学院', '软件工程', '18软件(理软)2', 'csq', '男', '20', '福建', '2313213', '123@qq.com', '123');
INSERT INTO `student` VALUES ('1812123205', '软件工程学院', '软件工程', '18软件(理软)1', '陈善涛', '男', '20', '福建', '110', 'cst@qq.com', '123');
INSERT INTO `student` VALUES ('1812123206', '软件工程学院', '软件工程', '18软件(理软)1', '陈双全', '男', '21', '福建省厦门市', '18259234126', '2221999792@qq.com', '123');
INSERT INTO `student` VALUES ('1812123238', '软件工程学院', '软件工程', '18软件(理软)1', '张怀洲', '男', '23', '福建', '120', 'zhz@qq.com', '123');
INSERT INTO `student` VALUES ('1812123299', '软件工程学院', '软件工程', '18新媒体1', '陈双全2', '女', '88', '福建省龙岩市', '18259234999', '888@qq.com', '123');
INSERT INTO `student` VALUES ('1812123405', '软件工程学院', '软件工程', '18软件(理软)2', '王五', '男', '20', '福建省厦门市', '18323847123', '123972@qq.com', '123');
INSERT INTO `student` VALUES ('2222222222', '软件工程学院', '软件工程', '18新媒体1', '碧华', '男', '21', '福建', '4231323', '213@qq.com', '123');
INSERT INTO `student` VALUES ('5555555555', '待分配', '待分配', '待分配', '打发打', '女', '', '', '', '', '555');
INSERT INTO `student` VALUES ('7777777777', '待分配', '待分配', '待分配', '李子柒', '女', '26', '福建', '124123132', '123@qq.com', '123');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_education` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123',
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('9912123205', '叶老师', '女', '硕士', '助教', '123');
INSERT INTO `teacher` VALUES ('9912123206', '陈老师', '男', '博士', '讲师', '123');

SET FOREIGN_KEY_CHECKS = 1;
