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
  `ryid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '��Աid��113��',
  `rymc` varchar(64) NOT NULL COMMENT '��Ա���ƣ����ģ�',
  `dlzh` varchar(32) NOT NULL COMMENT '��¼�˺ţ�90010,admin,gly��',
  `zhmm` varchar(64) NOT NULL COMMENT '�˺����루123456��',
  `csmmbz` tinyint(4) DEFAULT NULL COMMENT '��ʼ�����־����SFBZ����',
  `zzbm` varchar(20) NOT NULL COMMENT '��֯���루050130_��������ּ����Ʋ���',
  `gzbh` varchar(16) DEFAULT NULL COMMENT '���ţ�113��',
  `lxdh` varchar(32) DEFAULT NULL COMMENT '��ϵ�绰��087130112345��087130612345 [�����д�ٺŸ���]��',
  `lxsj` varchar(32) DEFAULT NULL COMMENT '��ϵ�ֻ���13012345678��13612345678 [�����д�ٺŸ���]��',
  `email` varchar(64) DEFAULT NULL COMMENT 'email��ַ��zhangsan@sina.com.cn��lisi@sina.com.cn [�����д�ٺŸ���]��',
  `xbbz` tinyint(4) DEFAULT NULL COMMENT '�Ա��־����XBBZ����',
  `yxbz` tinyint(4) NOT NULL COMMENT '��Ч��־����YXBZ����',
  `zzljmc` varchar(512) DEFAULT NULL COMMENT '��֯·�����ƣ��Ϸ�������˾/���ϵ�����˾/��Ʋ�/���һ�ƣ�',
  `jsid` int(10) unsigned DEFAULT NULL COMMENT '��ɫid��18_���һ�ƿƳ���',
  `dwbm` varchar(20) NOT NULL COMMENT '��λ���루0501_��������֣�',
  `czrid` int(10) unsigned NOT NULL COMMENT '������id��113_���ģ�',
  `cjsj` datetime NOT NULL COMMENT '����ʱ�䣨2010-1-1 13:01:08��',
  `czsj` datetime NOT NULL COMMENT '����ʱ�䣨2013-9-10 13:01:08��',
  `rygw` varchar(255) DEFAULT NULL COMMENT '��Ա��λ(�߼�������Ա,�м�������Ա,����������Ա,������Ա)',
  `iszjjgry` varchar(32) DEFAULT NULL COMMENT '�Ƿ����н������Ա(1�����н����������������)',
  PRIMARY KEY (`ryid`)
) ENGINE=InnoDB AUTO_INCREMENT=57005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_ry
-- ----------------------------
INSERT INTO `xt_ry` VALUES ('2', 'ϵͳ����Ա', 'admin', '4QrcOUm6Wau+VuBX8g+IPg==', '0', '50000', '002', '087130112345��087130612345', '13012345678��13612345678', 'admin@test.com', '1', '1', '1/10', '1', '50000', '2', '2015-12-17 16:15:17', '2016-10-24 14:07:20', null, null);
INSERT INTO `xt_ry` VALUES ('286', '��ӭϼ', 'chenyingxia', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1801', '', '', '', '', '0', '1', '1/10/11/643/797', '90', '50000', '2', '2016-07-18 14:10:15', '2016-09-02 10:07:15', null, null);
INSERT INTO `xt_ry` VALUES ('287', '���Z', 'liujing', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1704', '', '', '', '', '1', '1', '1/10/11/643/18537', '91', '50000', '2', '2016-07-18 14:31:48', '2016-09-02 17:02:14', null, null);
INSERT INTO `xt_ry` VALUES ('291', '������', 'sishuming', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-0100', '', '', '', '', '1', '1', '1/10/11/799', '87', '50000', '2', '2016-07-21 20:42:31', '2016-08-02 21:13:24', null, null);
INSERT INTO `xt_ry` VALUES ('292', '³����', 'luhuiyun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1801', '', '', '', '', '1', '1', '1/10/11/643/797', '90', '50000', '2', '2016-07-21 21:03:12', '2016-08-02 20:23:11', null, null);
INSERT INTO `xt_ry` VALUES ('293', '��ӭ��', 'wangyingfang', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050607-0605', '', '', '', '', '1', '1', '', '88', '50607', '2', '2016-07-30 17:06:28', '2016-08-02 20:15:25', null, null);
INSERT INTO `xt_ry` VALUES ('294', '��', 'majun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058500-1100', '', '', '', '', '1', '1', '', '88', '58500', '2', '2016-07-30 17:07:09', '2016-08-02 20:15:51', null, null);
INSERT INTO `xt_ry` VALUES ('295', 'test_zsk', 'test1', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '15562', '', '15678905431', '15674325642', '', '0', '1', '1/10/15560/15562', '90', '15562', '2', '2016-08-02 15:47:27', '2016-08-02 21:09:44', null, null);
INSERT INTO `xt_ry` VALUES ('296', 'test_add', 'test2', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '15562', '', '', '15786953342', '15786953342', '1', '1', '', '91', '15562', '2', '2016-08-02 15:49:10', '2016-08-02 21:10:01', null, null);
INSERT INTO `xt_ry` VALUES ('303', '����', 'cwb_test', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '790', '', '18787', '', '', '1', '1', '', '92', '11', '303', '2016-08-15 17:20:49', '2016-08-24 17:15:38', null, null);
INSERT INTO `xt_ry` VALUES ('304', 'ͬ���û�1', 'tongfang1', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '15579', '', '', '', '', '1', '1', '', '92', '15579', '2', '2016-08-19 10:11:26', '2016-08-19 10:11:26', null, null);
INSERT INTO `xt_ry` VALUES ('305', '��ҫ��', 'hongyaolong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1801', '', '', '', '', '1', '1', '', '90', '50000', '2', '2016-09-02 10:04:46', '2016-09-02 10:04:46', null, null);
INSERT INTO `xt_ry` VALUES ('306', 'ʩ��', 'shiyong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058100-3300', '', '', '', '', '1', '1', '', null, '58100', '2', '2016-09-02 16:01:22', '2016-09-02 16:05:16', null, null);
INSERT INTO `xt_ry` VALUES ('307', '������', 'wangmiqiong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '059300-0700', '', '', '', '', '1', '1', '', null, '59300', '2', '2016-09-02 17:18:48', '2016-09-02 17:18:48', null, null);
INSERT INTO `xt_ry` VALUES ('308', '��ƽ_����', 'kunmingTest1', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '10037', '', '', '', '', '1', '1', '', null, '678', '2', '2016-09-03 10:48:20', '2016-09-09 11:12:32', null, null);
INSERT INTO `xt_ry` VALUES ('309', '�', 'yangjun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058100-1300', '', '', '', '', '1', '1', '', null, '58100', '2', '2016-09-05 20:00:11', '2016-09-05 20:02:02', null, null);
INSERT INTO `xt_ry` VALUES ('310', '������', 'wangxiaodong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050600-2600', '', '', '', '', '1', '1', '', null, '50600', '2', '2016-10-21 10:16:38', '2016-10-21 10:17:25', null, null);
INSERT INTO `xt_ry` VALUES ('311', '������', 'wxy', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '052200-0900', '', '', '', '', '1', '1', '', null, '52200', '2', '2016-11-25 15:27:16', '2016-11-25 15:27:16', null, null);
INSERT INTO `xt_ry` VALUES ('312', '����', 'chenyong', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058103-1500', null, null, null, null, '1', '1', null, null, '58103', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('313', '������', 'yangyongkun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050100-0308', null, null, null, null, '1', '1', null, null, '50100', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('314', '�Խ���', 'zhaojianbing', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1002', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('315', 'Ƚ����', 'ranqipeng', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1002', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('316', '����', 'hujun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '051303-1000', null, null, null, null, '1', '1', null, null, '51303', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('317', '������', 'sunyazhou', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-0905', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('318', '����', 'yangqing', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050702-3000', null, null, null, null, '1', '1', null, null, '50702', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('319', 'Ī����', 'mohaifeng', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-0905', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('320', '������', 'laidenan', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('321', '������', 'wangjunli', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('322', '�����', 'wangjianjuan', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('323', '���', 'huangwei', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050200-7300', null, null, null, null, '1', '1', null, null, '50200', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('324', '����', 'yuelin', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('325', '���', 'zhanglan', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058500-1000', null, null, null, null, '1', '1', null, null, '58500', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('326', '������', 'jiaoyangkun', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-2801', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('327', '������', 'chenshizhao', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('328', '���', 'zhubin', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '058102-0900', null, null, null, null, '1', '1', null, null, '58102', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('329', '���', 'yangchen', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('330', '����', 'qiuling', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('331', '����ΰ', 'wuxianwei', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('332', '��ΰ', 'yanwei', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1903', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('333', '��Ծ��', 'wangyuehui', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050300-1500', null, null, null, null, '1', '1', null, null, '50300', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('334', '����', 'wangtao', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '057600-2702-01', null, null, null, null, '1', '1', null, null, '57600', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('335', '�����', 'zhangwanci', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050000-1006', null, null, null, null, '1', '1', null, null, '50000', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('336', '������', 'wangxiaobo', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '050405-2700', null, null, null, null, '1', '1', null, null, '50405', '2', '2016-12-07 09:37:04', '2016-12-07 09:37:04', null, null);
INSERT INTO `xt_ry` VALUES ('56985', '����', 'wangjun_wbgs04', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs04', null, null, null, null, '1', '1', null, '93', 'wbgs04', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56986', '��ǿ', 'wangqiang_wbgs04', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs04', null, null, null, null, '1', '1', null, '93', 'wbgs04', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '�߼�������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56987', '��ǿ��', 'liqiangjing_wbgs04', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs04', null, null, null, null, '1', '1', null, '93', 'wbgs04', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56988', '����', 'liming_wbgs04', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs04', null, null, null, null, '1', '1', null, '93', 'wbgs04', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '�м�������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56989', '������', 'zhouxiulan_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56990', '����÷', 'liuyumei_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '�߼�������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56991', '��˼��', 'chengsihan_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '�߼�������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56992', 'Ǯ�꺭', 'quanyuhan_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56993', '�ﲩ��', 'suanbowen_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '�м�������Ա', '1');
INSERT INTO `xt_ry` VALUES ('56994', '���', 'chengyuhang_wbgs05', '4QrcOUm6Wau+VuBX8g+IPg==', '1', 'wbgs05', null, null, null, null, '1', '1', null, '93', 'wbgs05', '2', '2017-01-18 10:44:05', '2017-01-18 10:44:08', '�߼�������Ա', '1');
