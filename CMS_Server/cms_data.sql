/*
 Navicat Premium Data Transfer

 Source Server         : cms
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : cms_data

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 05/09/2018 16:38:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `adminID` int(255) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`adminID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'administrator', 'admin');
INSERT INTO `administrator` VALUES (2, 'xby', 'yz20140508');

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `answerID` int(10) NOT NULL AUTO_INCREMENT,
  `questionID` int(10) NULL DEFAULT NULL,
  `answerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answerTicket` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`answerID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (7, 6, '已买', 0);
INSERT INTO `answer` VALUES (8, 6, '未买', 0);
INSERT INTO `answer` VALUES (9, 7, '单身', 0);
INSERT INTO `answer` VALUES (10, 7, '不单身', 0);
INSERT INTO `answer` VALUES (11, 8, '未婚', 0);
INSERT INTO `answer` VALUES (12, 8, '已婚', 0);
INSERT INTO `answer` VALUES (16, 12, '是', 0);
INSERT INTO `answer` VALUES (17, 12, '否', 4);
INSERT INTO `answer` VALUES (18, 13, '小学', 0);
INSERT INTO `answer` VALUES (19, 13, '初中', 0);
INSERT INTO `answer` VALUES (20, 13, '高中', 0);
INSERT INTO `answer` VALUES (21, 13, '本科', 4);
INSERT INTO `answer` VALUES (22, 13, '硕士', 0);
INSERT INTO `answer` VALUES (23, 14, '男', 4);
INSERT INTO `answer` VALUES (24, 14, '女', 0);
INSERT INTO `answer` VALUES (25, 15, '是', 4);
INSERT INTO `answer` VALUES (26, 15, '否', 0);

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`  (
  `applicationID` int(10) NOT NULL AUTO_INCREMENT,
  `applicationName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nowPower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `applicationPower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `why` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `applicationDate` datetime(6) NULL DEFAULT NULL,
  `applicationState` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`applicationID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES (1, 'xby', 'reporter', 'administrator', '一级栏目对应的二级栏目不符，希望申请权限修改', '2018-09-03 15:05:46.000000', 1);
INSERT INTO `application` VALUES (2, 'yz', 'user', 'reporter', '申请', '2018-09-04 15:50:34.000000', 2);
INSERT INTO `application` VALUES (3, '1111', 'user', 'administrator', 'qqqqqqqq', '2018-09-05 08:30:55.000000', 0);
INSERT INTO `application` VALUES (4, 'yz', 'user', 'administrator', '你是我的小苹果', '2018-09-05 09:09:25.000000', 2);
INSERT INTO `application` VALUES (5, 'yz', 'user', 'reporter', '我想要成为录入员', '2018-09-05 09:24:32.000000', 1);

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `conID` int(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `richText` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(6) NULL,
  `clicks` int(255) NULL DEFAULT 1,
  `annex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `top` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `twoLevelID` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`conID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES (6, '习近平会见安哥拉总统洛伦索', '习近平总理', '新华网', '佚名', 'administrator', '<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px 0px 15px; font-size: 18px; line-height: 36px; color: rgb(51, 51, 51); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 微软雅黑, &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, &quot;Helvetica Neue&quot;, &quot;Helvetica, Arial&quot;, STHeitiSC-Light, simsun, 宋体, &quot;WenQuanYi Zen Hei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; white-space: normal;\">新华社北京9月2日电（记者孙奕）国家主席习近平2日在人民大会堂会见安哥拉总统洛伦索。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px 0px 15px; font-size: 18px; line-height: 36px; color: rgb(51, 51, 51); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 微软雅黑, &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, &quot;Helvetica Neue&quot;, &quot;Helvetica, Arial&quot;, STHeitiSC-Light, simsun, 宋体, &quot;WenQuanYi Zen Hei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; white-space: normal;\"><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px 0px 15px; font-size: 18px; line-height: 36px; color: rgb(51, 51, 51); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 微软雅黑, &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, &quot;Helvetica Neue&quot;, &quot;Helvetica, Arial&quot;, STHeitiSC-Light, simsun, 宋体, &quot;WenQuanYi Zen Hei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; white-space: normal;\">　　习近平指出，中安建立战略伙伴关系8年来，双方坚持相互尊重、合作共赢，携手走出了一条独具特色的共同发展之路。今年是中安建交35周年，我们要共同推动中安战略伙伴关系不断迈上新台阶。中方愿同安方加强执政党交往和治国理政经验交流，深化各领域合作，就重大国际问题加强沟通协调。中方愿将“一带一路”倡议同安哥拉经济多元化战略紧密对接，继续为符合安哥拉国家发展战略的重大项目提供不附加政治条件的支持。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px 0px 15px; font-size: 18px; line-height: 36px; color: rgb(51, 51, 51); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 微软雅黑, &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, &quot;Helvetica Neue&quot;, &quot;Helvetica, Arial&quot;, STHeitiSC-Light, simsun, 宋体, &quot;WenQuanYi Zen Hei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; white-space: normal;\">洛伦索表示，安中关系紧密牢固。感谢中国为安哥拉重建和经济社会发展作出的贡献。安哥拉坚定支持一个中国原则，愿同中国深化政治互信和双边合作。中国总是在非洲困难时给予宝贵帮助，为非洲和平与发展发挥着非常重要的作用。非洲国家珍视同中国的友谊，期待积极参与中非合作论坛建设，共同举办好论坛北京峰会。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px 0px 15px; font-size: 18px; line-height: 36px; color: rgb(51, 51, 51); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 微软雅黑, &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, &quot;Helvetica Neue&quot;, &quot;Helvetica, Arial&quot;, STHeitiSC-Light, simsun, 宋体, &quot;WenQuanYi Zen Hei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; white-space: normal;\">　　会见后，两国元首共同见证了双边合作文件的签署。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px 0px 15px; font-size: 18px; line-height: 36px; color: rgb(51, 51, 51); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 微软雅黑, &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, &quot;Helvetica Neue&quot;, &quot;Helvetica, Arial&quot;, STHeitiSC-Light, simsun, 宋体, &quot;WenQuanYi Zen Hei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; white-space: normal;\"><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px 0px 15px; font-size: 18px; line-height: 36px; color: rgb(51, 51, 51); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 微软雅黑, &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, &quot;Helvetica Neue&quot;, &quot;Helvetica, Arial&quot;, STHeitiSC-Light, simsun, 宋体, &quot;WenQuanYi Zen Hei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; white-space: normal;\">　　丁薛祥、杨洁篪、王毅、何立峰等参加会见。</p><p><br/></p>', '习近平会见安哥拉总统洛伦索', '2018-09-02 22:18:09.000000', 1, './img/20180902465fc1b6eeff44cdb231434d855f7476.mp4', '是', 1);
INSERT INTO `content` VALUES (7, '世界期待中非合作论坛北京峰会', '北京峰会', '中华青年网', '杨飞', 'administrator', '<p style=\"text-align:justify;margin-top: 1em; margin-bottom: 1em; padding: 0px; font-family: 微软雅黑; color: rgb(86, 86, 86); white-space: normal; background-color: rgb(255, 255, 255);\">“我期待同非方领导人在北京共襄盛举，共商中非合作发展大计，为增进中非人民福祉、促进世界和平与发展贡献力量。”在致非盟第31届首脑会议的贺信中，习近平主席向非洲各国领导人发出诚挚邀请。9月3日－4日，全球瞩目的中非合作论坛北京峰会就将隆重举行。届时，中非领导人齐聚北京，围绕“合作共赢，携手构建更加紧密的中非命运共同体”这一主题，共叙友情，共商合作，共话未来。</p><p style=\"text-align:justify;margin-top: 1em; margin-bottom: 1em; padding: 0px; font-family: 微软雅黑; color: rgb(86, 86, 86); white-space: normal; background-color: rgb(255, 255, 255);\">　　自2000年成立以来，中非合作论坛已经成为了中非合作的响亮品牌，也是引领国际对非合作、提升南南合作的一面旗帜。2018年中非合作论坛北京峰会是中非合作论坛继2006年北京峰会和2015年约翰内斯堡峰会之后，中非友好大家庭的又一次大团圆，也是中国今年举办的规模最大、外国领导人出席最多的主场外交。适逢论坛成立18周年，迎来“成人礼”的北京峰会吸引了全球关注目光。</p><p style=\"text-align:justify;margin-top: 1em; margin-bottom: 1em; padding: 0px; font-family: 微软雅黑; color: rgb(86, 86, 86); white-space: normal; background-color: rgb(255, 255, 255);\">　　全球关注中非合作论坛北京峰会，背后是对中非共赢发展的期待。习近平主席访非后，非洲各界就尽皆表示期待北京峰会能够为进一步加强非中全方位合作推出新举措、创造新机遇。可见，举办论坛北京峰会已成中非双方全面深化中非友好合作、积极应对全球挑战的一致要求，非盟委员会社会事务委员阿米拉就表示：“中非合作论坛北京峰会有望将中非全面战略合作伙伴关系提升到一个新水平。”</p><p style=\"text-align:justify;margin-top: 1em; margin-bottom: 1em; padding: 0px; font-family: 微软雅黑; color: rgb(86, 86, 86); white-space: normal; background-color: rgb(255, 255, 255);\">　　贡献“中国方案”，擘画美好未来。中非合作论坛北京峰会将继续聚焦非洲的发展，包括基础设施建设、投融资、电力能源、工业园区建设等。在峰会上，中国也将全面阐述加强对非关系新理念、新主张。北京峰会还将发出构建更加紧密的中非命运共同体的新呼唤；谱写“一带一路”对接非洲发展的新乐章；制定中非合作朝着更高水平迈进的新路径；奏响中非人民心手相连、亲如一家的新旋律。</p><p style=\"text-align:justify;margin-top: 1em; margin-bottom: 1em; padding: 0px; font-family: 微软雅黑; color: rgb(86, 86, 86); white-space: normal; background-color: rgb(255, 255, 255);\">　　中非长期友好，命运休戚与共。同2000年相比，2017年中非贸易额增长17倍，中国对非投资增长100多倍。当前中国人民正致力于实现中华民族伟大复兴的中国梦，而非洲人民也正致力于实现联合自强、发展振兴的非洲梦。不负世界期待，峰会还将通过《宣言》和《行动计划》两大成果文件，签署一系列双边合作协议，全方位规划未来三年以及今后一个时期的中非合作的优先领域和重点方向。</p><p style=\"text-align:justify;margin-top: 1em; margin-bottom: 1em; padding: 0px; font-family: 微软雅黑; color: rgb(86, 86, 86); white-space: normal; background-color: rgb(255, 255, 255);\">　　中非携手，情真意切；中非合作，前景美好。即将拉开帷幕的2018年中非合作论坛北京峰会将充实中非命运共同体的时代内涵，开启中非携手圆梦、共创繁荣的新征程，对于提升中非关系，实现中非互利共赢、共同发展有着重要的里程碑意义。当然，2018年中非合作论坛北京峰会也将汇聚国际社会促进和平发展的正义力量，为推动构建人类命运共同体作出新的贡献，当然会为国际社会所期待。</p><p><br/></p>', '中非合作', '2018-09-03 16:24:18.000000', 1, './img/2018090363e8f040a2624e69b666703e46534ef6.mp4', '是', 2);

-- ----------------------------
-- Table structure for loginwater
-- ----------------------------
DROP TABLE IF EXISTS `loginwater`;
CREATE TABLE `loginwater`  (
  `loginID` int(10) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginDate` datetime(6) NULL DEFAULT NULL,
  `loginType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`loginID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 135 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for media
-- ----------------------------
DROP TABLE IF EXISTS `media`;
CREATE TABLE `media`  (
  `mediaID` int(255) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mediaID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of media
-- ----------------------------
INSERT INTO `media` VALUES (23, './img/20180902465fc1b6eeff44cdb231434d855f7476.mp4', 'E:\\eclipse-workspace\\CMS_Server\\WebContent\\img\\20180902465fc1b6eeff44cdb231434d855f7476.mp4');
INSERT INTO `media` VALUES (24, './img/2018090363e8f040a2624e69b666703e46534ef6.mp4', 'E:\\eclipse-workspace\\CMS_Server\\WebContent\\img\\2018090363e8f040a2624e69b666703e46534ef6.mp4');

-- ----------------------------
-- Table structure for onelevel
-- ----------------------------
DROP TABLE IF EXISTS `onelevel`;
CREATE TABLE `onelevel`  (
  `oneLevelID` int(255) NOT NULL AUTO_INCREMENT,
  `oneLevelName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`oneLevelID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of onelevel
-- ----------------------------
INSERT INTO `onelevel` VALUES (1, '新闻');
INSERT INTO `onelevel` VALUES (2, '娱乐');
INSERT INTO `onelevel` VALUES (3, '体育');
INSERT INTO `onelevel` VALUES (4, '汽车');
INSERT INTO `onelevel` VALUES (5, '游戏');
INSERT INTO `onelevel` VALUES (6, '股票');

-- ----------------------------
-- Table structure for qa
-- ----------------------------
DROP TABLE IF EXISTS `qa`;
CREATE TABLE `qa`  (
  `QAPersonID` int(10) NOT NULL AUTO_INCREMENT,
  `QAPersonName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `QAName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`QAPersonID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qa
-- ----------------------------
INSERT INTO `qa` VALUES (4, 'xiaoboyu', '是否内向');
INSERT INTO `qa` VALUES (5, 'xiaoboyu', '问卷调查1');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `questionID` int(10) NOT NULL AUTO_INCREMENT,
  `questionName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `questionnaireID` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`questionID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (6, '是否买房', 4);
INSERT INTO `question` VALUES (7, '是否单身', 4);
INSERT INTO `question` VALUES (8, '是否已婚', 4);
INSERT INTO `question` VALUES (12, '是否内向', 9);
INSERT INTO `question` VALUES (13, '学历', 9);
INSERT INTO `question` VALUES (14, '性别', 9);
INSERT INTO `question` VALUES (15, '是否独生子', 9);

-- ----------------------------
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire`  (
  `questionnaireID` int(255) NOT NULL AUTO_INCREMENT,
  `questionnaireName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`questionnaireID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES (4, '问卷调查');
INSERT INTO `questionnaire` VALUES (9, '问卷调查1');

-- ----------------------------
-- Table structure for reporter
-- ----------------------------
DROP TABLE IF EXISTS `reporter`;
CREATE TABLE `reporter`  (
  `reporterID` int(255) NOT NULL AUTO_INCREMENT,
  `reporterName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reporterPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`reporterID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reporter
-- ----------------------------
INSERT INTO `reporter` VALUES (2, 'yz', 'yz20140508');

-- ----------------------------
-- Table structure for twolevel
-- ----------------------------
DROP TABLE IF EXISTS `twolevel`;
CREATE TABLE `twolevel`  (
  `twoLevelID` int(255) NOT NULL AUTO_INCREMENT,
  `twoLevelName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `oneLevelID` int(255) NOT NULL,
  PRIMARY KEY (`twoLevelID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of twolevel
-- ----------------------------
INSERT INTO `twolevel` VALUES (1, '今日头条', 1);
INSERT INTO `twolevel` VALUES (2, '网易新闻', 1);
INSERT INTO `twolevel` VALUES (3, '百度新闻', 1);
INSERT INTO `twolevel` VALUES (4, '电影', 2);
INSERT INTO `twolevel` VALUES (5, '电视剧', 2);
INSERT INTO `twolevel` VALUES (6, '综艺', 2);
INSERT INTO `twolevel` VALUES (7, '中国足球', 3);
INSERT INTO `twolevel` VALUES (8, '国际足球', 3);
INSERT INTO `twolevel` VALUES (9, 'NBA', 3);
INSERT INTO `twolevel` VALUES (10, 'SUV', 4);
INSERT INTO `twolevel` VALUES (11, '新车', 4);
INSERT INTO `twolevel` VALUES (12, '奔驰C级', 4);
INSERT INTO `twolevel` VALUES (13, '王者荣耀', 5);
INSERT INTO `twolevel` VALUES (14, '荒野行动', 5);
INSERT INTO `twolevel` VALUES (15, '地下城与勇士', 5);
INSERT INTO `twolevel` VALUES (16, '期货', 6);
INSERT INTO `twolevel` VALUES (17, '黄金', 6);
INSERT INTO `twolevel` VALUES (18, '外汇2', 6);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userID` int(255) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userEmail` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 'xiaoboyu', 'yz20140508', '15021020041', '东软二期', '1059748080@qq.com');

-- ----------------------------
-- Table structure for website
-- ----------------------------
DROP TABLE IF EXISTS `website`;
CREATE TABLE `website`  (
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `seo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
