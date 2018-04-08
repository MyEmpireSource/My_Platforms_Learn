/*
Navicat MySQL Data Transfer

Source Server         : 10.111.43.237
Source Server Version : 50621
Source Host           : 10.111.43.237:3306
Source Database       : dwmkdb

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-15 15:34:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `xt_ry`
-- ----------------------------
DROP TABLE IF EXISTS `xt_ry`;
CREATE TABLE `xt_ry` (
  `ryid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '人员id（113）',
  `rymc` varchar(64) NOT NULL COMMENT '人员名称（李四）',
  `dlzh` varchar(32) NOT NULL COMMENT '登录账号（90010,admin,gly）',
  `zhmm` varchar(64) NOT NULL COMMENT '账号密码（123456）',
  `csmmbz` tinyint(4) DEFAULT NULL COMMENT '初始密码标志（【SFBZ】）',
  `zzbm` varchar(20) NOT NULL COMMENT '组织编码（050130_昆明供电局监察审计部）',
  `gzbh` varchar(16) DEFAULT NULL COMMENT '工号（113）',
  `lxdh` varchar(32) DEFAULT NULL COMMENT '联系电话（087130112345、087130612345 [多个大写顿号隔开]）',
  `lxsj` varchar(32) DEFAULT NULL COMMENT '联系手机（13012345678、13612345678 [多个大写顿号隔开]）',
  `email` varchar(64) DEFAULT NULL COMMENT 'email地址（zhangsan@sina.com.cn、lisi@sina.com.cn [多个大写顿号隔开]）',
  `xbbz` tinyint(4) DEFAULT NULL COMMENT '性别标志（【XBBZ】）',
  `yxbz` tinyint(4) NOT NULL COMMENT '有效标志（【YXBZ】）',
  `zzljmc` varchar(512) DEFAULT NULL COMMENT '组织路径名称（南方电网公司/云南电网公司/审计部/审计一科）',
  `jsid` int(10) unsigned DEFAULT NULL COMMENT '角色id（18_审计一科科长）',
  `dwbm` varchar(20) NOT NULL COMMENT '单位编码（0501_昆明供电局）',
  `czrid` int(10) unsigned NOT NULL COMMENT '操作人id（113_李四）',
  `cjsj` datetime NOT NULL COMMENT '创建时间（2010-1-1 13:01:08）',
  `czsj` datetime NOT NULL COMMENT '操作时间（2013-9-10 13:01:08）',
  `rygw` varchar(255) DEFAULT NULL COMMENT '人员岗位(高级技术人员,中级技术人员,初级技术人员,基层人员)',
  `iszjjgry` varchar(32) DEFAULT NULL COMMENT '是否是中介机构人员(1代表中介机构，其他代表不是)',
  PRIMARY KEY (`ryid`)
) ENGINE=InnoDB AUTO_INCREMENT=57005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_ry
-- ----------------------------
INSERT INTO `xt_ry` VALUES ('2', '系统管理员', 'admin', '4QrcOUm6Wau+VuBX8g+IPg==', '0', '50000', '002', '087130112345、087130612345', '13012345678、13612345678', 'admin@test.com', '1', '1', '1/10', '1', '50000', '2', '2015-12-17 16:15:17', '2016-10-24 14:07:20', null, null);
INSERT INTO `xt_ry` VALUES ('286', '陈迎霞', 'chenyingxia', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1801', '', '', '', '', '0', '1', '1/10/11/643/797', '90', '50000', '2', '2016-07-18 14:10:15', '2016-09-02 10:07:15', null, null);
INSERT INTO `xt_ry` VALUES ('287', '刘璟', 'liujing', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1704', '', '', '', '', '1', '1', '1/10/11/643/18537', '91', '50000', '2', '2016-07-18 14:31:48', '2016-09-02 17:02:14', null, null);
INSERT INTO `xt_ry` VALUES ('291', '佀蜀明', 'sishuming', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-0100', '', '', '', '', '1', '1', '1/10/11/799', '87', '50000', '2', '2016-07-21 20:42:31', '2016-08-02 21:13:24', null, null);
INSERT INTO `xt_ry` VALUES ('292', '鲁辉云', 'luhuiyun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1801', '', '', '', '', '1', '1', '1/10/11/643/797', '90', '50000', '2', '2016-07-21 21:03:12', '2016-08-02 20:23:11', null, null);
INSERT INTO `xt_ry` VALUES ('293', '王迎芳', 'wangyingfang', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050607-0605', '', '', '', '', '1', '1', '', '88', '50607', '2', '2016-07-30 17:06:28', '2016-08-02 20:15:25', null, null);
INSERT INTO `xt_ry` VALUES ('294', '马俊', 'majun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058500-1100', '', '', '', '', '1', '1', '', '88', '58500', '2', '2016-07-30 17:07:09', '2016-08-02 20:15:51', null, null);
INSERT INTO `xt_ry` VALUES ('295', 'test_zsk', 'test1', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '15562', '', '15678905431', '15674325642', '', '0', '1', '1/10/15560/15562', '90', '15562', '2', '2016-08-02 15:47:27', '2016-08-02 21:09:44', null, null);
INSERT INTO `xt_ry` VALUES ('296', 'test_add', 'test2', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '15562', '', '', '15786953342', '15786953342', '1', '1', '', '91', '15562', '2', '2016-08-02 15:49:10', '2016-08-02 21:10:01', null, null);
INSERT INTO `xt_ry` VALUES ('303', '财务部', 'cwb_test', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '790', '', '18787', '', '', '1', '1', '', '92', '11', '303', '2016-08-15 17:20:49', '2016-08-24 17:15:38', null, null);
INSERT INTO `xt_ry` VALUES ('304', '同方用户1', 'tongfang1', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '15579', '', '', '', '', '1', '1', '', '92', '15579', '2', '2016-08-19 10:11:26', '2016-08-19 10:11:26', null, null);
INSERT INTO `xt_ry` VALUES ('305', '洪耀龙', 'hongyaolong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1801', '', '', '', '', '1', '1', '', '90', '50000', '2', '2016-09-02 10:04:46', '2016-09-02 10:04:46', null, null);
INSERT INTO `xt_ry` VALUES ('306', '施勇', 'shiyong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058100-3300', '', '', '', '', '1', '1', '', null, '58100', '2', '2016-09-02 16:01:22', '2016-09-02 16:05:16', null, null);
INSERT INTO `xt_ry` VALUES ('307', '王米琼', 'wangmiqiong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '059300-0700', '', '', '', '', '1', '1', '', null, '59300', '2', '2016-09-02 17:18:48', '2016-09-02 17:18:48', null, null);
INSERT INTO `xt_ry` VALUES ('308', '李平_昆明', 'kunmingTest1', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '10037', '', '', '', '', '1', '1', '', null, '678', '2', '2016-09-03 10:48:20', '2016-09-09 11:12:32', null, null);
INSERT INTO `xt_ry` VALUES ('309', '杨俊', 'yangjun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058100-1300', '', '', '', '', '1', '1', '', null, '58100', '2', '2016-09-05 20:00:11', '2016-09-05 20:02:02', null, null);
INSERT INTO `xt_ry` VALUES ('310', '王晓东', 'wangxiaodong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050600-2600', '', '', '', '', '1', '1', '', null, '50600', '2', '2016-10-21 10:16:38', '2016-10-21 10:17:25', null, null);
INSERT INTO `xt_ry` VALUES ('311', '王晓燕', 'wxy', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '052200-0900', '', '', '', '', '1', '1', '', null, '52200', '2', '2016-11-25 15:27:16', '2016-11-25 15:27:16', null, null);
INSERT INTO `xt_ry` VALUES ('312', '陈勇', 'chenyong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058103-1500', null, null, null, null, '1', '1', null, null, '58103', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('313', '杨永昆', 'yangyongkun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050100-0308', null, null, null, null, '1', '1', null, null, '50100', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('314', '赵建兵', 'zhaojianbing', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1002', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('315', '冉启鹏', 'ranqipeng', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1002', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('316', '胡军', 'hujun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '051303-1000', null, null, null, null, '1', '1', null, null, '51303', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('317', '孙亚洲', 'sunyazhou', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-0905', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('318', '杨清', 'yangqing', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050702-3000', null, null, null, null, '1', '1', null, null, '50702', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('319', '莫海峰', 'mohaifeng', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-0905', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('320', '赖德南', 'laidenan', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('321', '王军丽', 'wangjunli', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('322', '王坚娟', 'wangjianjuan', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('323', '黄炜', 'huangwei', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050200-7300', null, null, null, null, '1', '1', null, null, '50200', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('324', '岳琳', 'yuelin', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('325', '张岚', 'zhanglan', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058500-1000', null, null, null, null, '1', '1', null, null, '58500', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('326', '焦阳坤', 'jiaoyangkun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('327', '陈世钊', 'chenshizhao', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('328', '朱斌', 'zhubin', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058102-0900', null, null, null, null, '1', '1', null, null, '58102', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('329', '杨宸', 'yangchen', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('330', '邱灵', 'qiuling', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('331', '吴贤伟', 'wuxianwei', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('332', '严伟', 'yanwei', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('333', '王跃辉', 'wangyuehui', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050300-1500', null, null, null, null, '1', '1', null, null, '50300', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('334', '王涛', 'wangtao', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '057600-2702-01', null, null, null, null, '1', '1', null, null, '57600', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('335', '张万辞', 'zhangwanci', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1006', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('336', '王晓波', 'wangxiaobo', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050405-2700', null, null, null, null, '1', '1', null, null, '50405', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('56985', '王军', 'wangjun_wbgs04', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs04', null, null, null, null, '1', '1', null, '93', 'wbgs04', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '基层人员', '1');
INSERT INTO `xt_ry` VALUES ('56986', '王强', 'wangqiang_wbgs04', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs04', null, null, null, null, '1', '1', null, '93', 'wbgs04', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '高级技术人员', '1');
INSERT INTO `xt_ry` VALUES ('56987', '李强静', 'liqiangjing_wbgs04', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs04', null, null, null, null, '1', '1', null, '93', 'wbgs04', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '基层人员', '1');
INSERT INTO `xt_ry` VALUES ('56988', '李铭', 'liming_wbgs04', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs04', null, null, null, null, '1', '1', null, '93', 'wbgs04', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '中级技术人员', '1');
INSERT INTO `xt_ry` VALUES ('56989', '周秀兰', 'zhouxiulan_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '基层人员', '1');
INSERT INTO `xt_ry` VALUES ('56990', '刘玉梅', 'liuyumei_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '高级技术人员', '1');
INSERT INTO `xt_ry` VALUES ('56991', '陈思涵', 'chengsihan_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '高级技术人员', '1');
INSERT INTO `xt_ry` VALUES ('56992', '钱雨涵', 'quanyuhan_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '基层人员', '1');
INSERT INTO `xt_ry` VALUES ('56993', '孙博文', 'suanbowen_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '中级技术人员', '1');
INSERT INTO `xt_ry` VALUES ('56994', '陈宇航', 'chengyuhang_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '高级技术人员', '1');
