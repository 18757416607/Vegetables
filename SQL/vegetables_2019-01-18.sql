/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50137
Source Host           : 127.0.0.1:3306
Source Database       : vegetables

Target Server Type    : MYSQL
Target Server Version : 50137
File Encoding         : 65001

Date: 2019-01-18 16:44:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for baseuser
-- ----------------------------
DROP TABLE IF EXISTS `baseuser`;
CREATE TABLE `baseuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of baseuser
-- ----------------------------
INSERT INTO `baseuser` VALUES ('1', 'admin', 'C4CA4238A0B923820DCC509A6F75849B');

-- ----------------------------
-- Table structure for base_receiving_address
-- ----------------------------
DROP TABLE IF EXISTS `base_receiving_address`;
CREATE TABLE `base_receiving_address` (
  `ra_id` int(11) NOT NULL COMMENT '用户收货地址表id',
  `ra_name` varchar(255) NOT NULL COMMENT '用户收货地址名称',
  `ra_loc` point NOT NULL COMMENT '用户收货地址经纬度',
  `ra_phone` char(11) NOT NULL COMMENT '用户手机号',
  `ra_remark` varchar(255) NOT NULL COMMENT '备注',
  `ra_updatetime` datetime NOT NULL COMMENT '修改时间',
  `ra_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ra_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of base_receiving_address
-- ----------------------------

-- ----------------------------
-- Table structure for base_vegetables_brand
-- ----------------------------
DROP TABLE IF EXISTS `base_vegetables_brand`;
CREATE TABLE `base_vegetables_brand` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蔬菜品牌表(brand)',
  `b_name` varchar(255) NOT NULL DEFAULT '0' COMMENT '品牌名称',
  `b_phone` varchar(255) NOT NULL DEFAULT '0' COMMENT '品牌联系人  多个用逗号分隔',
  `b_address` varchar(255) NOT NULL DEFAULT '0' COMMENT '品牌商家所在地',
  `b_address_loc` point NOT NULL COMMENT '品牌所在地经纬度',
  `b_remark` varchar(255) NOT NULL DEFAULT '0' COMMENT '备注',
  `b_del` char(2) NOT NULL DEFAULT '0' COMMENT '是否逻辑删除 00:可用  01:已删除',
  `b_updatetime` datetime NOT NULL COMMENT '修改时间',
  `b_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`b_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_vegetables_brand
-- ----------------------------
INSERT INTO `base_vegetables_brand` VALUES ('1', '我是品牌', '18757416607', '竹林', GeomFromText('POINT(29.86209268 121.59348249)'), '123', '00', '2019-01-18 16:22:48', '2019-01-18 16:22:50');
INSERT INTO `base_vegetables_brand` VALUES ('2', '222', '18757416607', '竹林', GeomFromText('POINT(29.86209268 121.59348249)'), '222', '00', '2019-01-18 16:24:39', '2019-01-18 16:24:42');

-- ----------------------------
-- Table structure for base_vegetables_category
-- ----------------------------
DROP TABLE IF EXISTS `base_vegetables_category`;
CREATE TABLE `base_vegetables_category` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蔬菜类别表(category)',
  `c_name` varchar(100) NOT NULL COMMENT '类别名称',
  `c_remark` varchar(255) NOT NULL DEFAULT '0' COMMENT '备注',
  `c_del` char(2) NOT NULL COMMENT '是否逻辑删除 00:可用  01:已删除',
  `c_updatetime` datetime NOT NULL COMMENT '修改时间',
  `c_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of base_vegetables_category
-- ----------------------------
INSERT INTO `base_vegetables_category` VALUES ('1', '暂无分类', '111', '00', '2018-11-05 22:45:35', '2018-11-05 22:45:37');
INSERT INTO `base_vegetables_category` VALUES ('2', '1111111', '222222', '01', '2018-12-12 23:14:36', '2018-12-12 23:08:09');
INSERT INTO `base_vegetables_category` VALUES ('3', '222', '22', '00', '2019-01-16 22:04:49', '2019-01-16 22:04:49');

-- ----------------------------
-- Table structure for base_vegetables_orders
-- ----------------------------
DROP TABLE IF EXISTS `base_vegetables_orders`;
CREATE TABLE `base_vegetables_orders` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单表 ',
  `o_phone` varchar(11) NOT NULL COMMENT '下单者手机号',
  `o_num` int(11) NOT NULL COMMENT '下单总数量',
  `o_price` int(11) NOT NULL COMMENT '下单总价',
  `o_ra_id` int(11) NOT NULL COMMENT '用户收货地址表id  逻辑外键  base_receiving_address',
  `o_is_discount` char(2) NOT NULL COMMENT '是否优惠  00:是  01:否',
  `o_coupon_id` int(11) NOT NULL COMMENT '优惠券id 逻辑外键  base_coupon',
  `o_discount_price` int(11) NOT NULL COMMENT '优惠券价格',
  `o_getway` char(2) NOT NULL DEFAULT '0' COMMENT '取货方式  00:配送  01:自提',
  `o_is_freight` char(2) NOT NULL COMMENT '是否免配送费  00:是  01:否',
  `o_freight` int(11) NOT NULL COMMENT '配送费',
  `o_status` char(2) NOT NULL COMMENT '订单状态  00:已下单  01:已支付',
  `o_is_cancel` char(2) NOT NULL COMMENT '是否取消  00:是  01:否',
  `o_cancel_reason` varchar(255) NOT NULL COMMENT '取消原因',
  `o_remark` varchar(255) NOT NULL COMMENT '备注',
  `o_updatetime` datetime NOT NULL COMMENT '修改时间',
  `o_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`o_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of base_vegetables_orders
-- ----------------------------

-- ----------------------------
-- Table structure for base_vegetables_orders_detail
-- ----------------------------
DROP TABLE IF EXISTS `base_vegetables_orders_detail`;
CREATE TABLE `base_vegetables_orders_detail` (
  `od_id` int(11) NOT NULL COMMENT '订单详细表id',
  `v_id` int(11) NOT NULL COMMENT '蔬菜品种编号 逻辑外键  base_vegetables_varieties',
  `o_id` int(11) NOT NULL COMMENT '订单表外键id 逻辑外键 base_vegetables_orders',
  `od_phone` varchar(11) NOT NULL COMMENT '下单者手机号',
  `od_num` int(11) NOT NULL COMMENT '数量',
  `od_price` int(11) NOT NULL COMMENT '价格',
  `od_remark` varchar(255) NOT NULL COMMENT '备注',
  `od_updatetime` datetime NOT NULL COMMENT '修改时间',
  `od_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`od_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of base_vegetables_orders_detail
-- ----------------------------

-- ----------------------------
-- Table structure for base_vegetables_purchase_source
-- ----------------------------
DROP TABLE IF EXISTS `base_vegetables_purchase_source`;
CREATE TABLE `base_vegetables_purchase_source` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蔬菜进货来源表(purchase_source)',
  `s_name` varchar(255) NOT NULL COMMENT '进货来源名称  如:龙海市场',
  `s_color` varchar(50) NOT NULL DEFAULT '0' COMMENT '颜色标识',
  `s_is_purchase` char(2) NOT NULL COMMENT '是否在此进货 00:是  01:否',
  `s_remark` varchar(255) NOT NULL DEFAULT '0' COMMENT '备注',
  `s_del` char(2) NOT NULL COMMENT '是否逻辑删除 00:可用  01:已删除',
  `s_updatetime` datetime NOT NULL COMMENT '修改时间',
  `s_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of base_vegetables_purchase_source
-- ----------------------------
INSERT INTO `base_vegetables_purchase_source` VALUES ('1', '龙海市场', '0', '00', '1', '00', '2018-11-05 22:46:05', '2018-11-05 22:46:07');
INSERT INTO `base_vegetables_purchase_source` VALUES ('2', '竹口菜场', '0', '00', '2', '00', '2018-11-05 22:46:05', '2018-11-05 22:46:07');
INSERT INTO `base_vegetables_purchase_source` VALUES ('3', '岭里菜场', '0', '00', '3', '00', '2018-11-05 22:46:05', '2018-11-05 22:46:07');
INSERT INTO `base_vegetables_purchase_source` VALUES ('4', 'tttbb', '0', '01', 'tbb11', '01', '2018-12-27 21:38:03', '2018-12-27 19:56:54');
INSERT INTO `base_vegetables_purchase_source` VALUES ('5', 'vvvv', '0', '00', '无', '00', '2019-01-16 22:04:56', '2019-01-16 22:04:56');

-- ----------------------------
-- Table structure for base_vegetables_purchase_source_merchant
-- ----------------------------
DROP TABLE IF EXISTS `base_vegetables_purchase_source_merchant`;
CREATE TABLE `base_vegetables_purchase_source_merchant` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进货来源商户表(purchase_source_merchant)',
  `s_id` int(11) NOT NULL COMMENT '蔬菜进货来源id  逻辑外键 base_vegetables_purchase_source',
  `m_name` varchar(255) NOT NULL COMMENT '商户店铺名称',
  `m_gender` char(1) NOT NULL COMMENT '性别 0:男  1:女',
  `m_boss_name` varchar(255) NOT NULL COMMENT '商户老板名字',
  `m_boss_phone` varchar(255) NOT NULL COMMENT '商户老板手机号 多个用逗号分隔',
  `m_is_cooperation` char(2) NOT NULL COMMENT '是否合作 00:合作  01:不合作',
  `m_remark` varchar(255) NOT NULL DEFAULT '0' COMMENT '备注',
  `m_del` char(2) NOT NULL COMMENT '是否逻辑删除 00:可用  01:已删除',
  `m_updatetime` datetime NOT NULL COMMENT '修改时间',
  `m_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of base_vegetables_purchase_source_merchant
-- ----------------------------
INSERT INTO `base_vegetables_purchase_source_merchant` VALUES ('1', '1', '龙海杂货铺', '0', '王qs', '18757416607', '00', '0', '00', '2018-11-13 15:42:56', '2018-11-13 15:42:58');
INSERT INTO `base_vegetables_purchase_source_merchant` VALUES ('2', '2', '竹口杂货铺', '0', 'www', '18757416608', '00', '0', '00', '2018-11-13 15:42:56', '2018-11-13 15:42:58');
INSERT INTO `base_vegetables_purchase_source_merchant` VALUES ('3', '4', '1111', '1', '111', '11', '01', '无', '00', '2018-12-27 21:52:16', '2018-12-27 21:34:10');
INSERT INTO `base_vegetables_purchase_source_merchant` VALUES ('4', '4', '1118', '1', '2228', '33338', '01', '无8', '01', '2018-12-27 21:54:15', '2018-12-27 21:36:41');
INSERT INTO `base_vegetables_purchase_source_merchant` VALUES ('7', '3', 'vvvvv', '0', 'vv', 'vv', '00', 'v', '00', '2019-01-16 22:05:04', '2019-01-16 22:05:04');

-- ----------------------------
-- Table structure for base_vegetables_quotation
-- ----------------------------
DROP TABLE IF EXISTS `base_vegetables_quotation`;
CREATE TABLE `base_vegetables_quotation` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蔬菜行情表（quotation）',
  `v_id` int(11) NOT NULL COMMENT '蔬菜品种表id  逻辑外检 base_vegetables_category',
  `s_id` int(11) NOT NULL COMMENT '蔬菜进货来源id  逻辑外键 base_vegetables_purchase_source',
  `q_investigation_date` datetime NOT NULL COMMENT '调查时间',
  `q_investigation_price` decimal(10,2) NOT NULL COMMENT '调查价格  单位(分)',
  `q_price_increase` decimal(11,2) NOT NULL COMMENT '价格涨幅,同一菜场的价格区别或卖家叫价便宜后 单位(分)',
  `q_del` char(2) NOT NULL COMMENT '是否逻辑删除 00:可用  01:已删除',
  `q_remark` varchar(100) NOT NULL DEFAULT '0' COMMENT '蔬菜行情备注信息',
  `q_updatetime` datetime NOT NULL COMMENT '修改时间',
  `q_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`q_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of base_vegetables_quotation
-- ----------------------------
INSERT INTO `base_vegetables_quotation` VALUES ('1', '1', '1', '2018-10-21 05:24:04', '3.50', '0.00', '00', '无', '2018-11-17 00:23:56', '2018-11-05 22:29:01');
INSERT INTO `base_vegetables_quotation` VALUES ('2', '2', '1', '2018-10-21 05:24:04', '4.00', '0.00', '00', '无', '2018-11-17 00:23:51', '2018-11-12 23:01:21');
INSERT INTO `base_vegetables_quotation` VALUES ('3', '3', '1', '2018-10-21 05:24:04', '2.00', '0.00', '00', '无', '2018-11-17 00:24:30', '2018-11-17 00:24:30');
INSERT INTO `base_vegetables_quotation` VALUES ('4', '4', '1', '2018-10-21 05:24:04', '16.00', '0.00', '00', '无', '2018-11-17 00:24:47', '2018-11-17 00:24:47');
INSERT INTO `base_vegetables_quotation` VALUES ('5', '5', '1', '2018-10-21 05:24:04', '2.50', '0.00', '00', '无', '2018-11-17 00:25:02', '2018-11-17 00:25:02');
INSERT INTO `base_vegetables_quotation` VALUES ('6', '6', '1', '2018-10-21 05:24:04', '4.00', '0.00', '00', '无', '2018-11-17 00:25:29', '2018-11-17 00:25:29');
INSERT INTO `base_vegetables_quotation` VALUES ('7', '7', '1', '2018-10-21 05:24:04', '15.00', '0.00', '00', '无', '2018-11-17 00:25:47', '2018-11-17 00:25:47');
INSERT INTO `base_vegetables_quotation` VALUES ('8', '8', '1', '2018-10-21 05:24:04', '12.00', '0.00', '00', '无', '2018-11-17 00:25:56', '2018-11-17 00:25:56');
INSERT INTO `base_vegetables_quotation` VALUES ('9', '9', '1', '2018-10-21 05:24:04', '2.50', '0.00', '00', '无', '2018-11-17 00:26:11', '2018-11-17 00:26:11');
INSERT INTO `base_vegetables_quotation` VALUES ('10', '10', '1', '2018-10-21 05:24:04', '2.50', '0.00', '00', '无', '2018-11-17 00:26:21', '2018-11-17 00:26:21');
INSERT INTO `base_vegetables_quotation` VALUES ('11', '11', '1', '2018-10-21 05:24:04', '1.00', '0.00', '00', '无', '2018-11-17 00:26:40', '2018-11-17 00:26:40');
INSERT INTO `base_vegetables_quotation` VALUES ('12', '12', '1', '2018-10-21 05:24:04', '4.00', '0.00', '00', '无', '2018-11-17 00:26:50', '2018-11-17 00:26:50');
INSERT INTO `base_vegetables_quotation` VALUES ('13', '13', '1', '2018-10-21 05:24:04', '4.00', '0.00', '00', '无', '2018-11-17 00:27:01', '2018-11-17 00:27:01');
INSERT INTO `base_vegetables_quotation` VALUES ('14', '12', '2', '2018-10-21 00:24:04', '7.50', '0.00', '00', '无', '2018-11-17 00:31:54', '2018-11-17 00:31:54');
INSERT INTO `base_vegetables_quotation` VALUES ('15', '1', '2', '2018-10-21 00:24:04', '5.00', '0.00', '00', '无', '2018-11-17 00:32:21', '2018-11-17 00:32:21');
INSERT INTO `base_vegetables_quotation` VALUES ('16', '11', '2', '2018-10-21 00:24:04', '3.00', '0.00', '00', '无', '2018-11-17 00:32:56', '2018-11-17 00:32:56');
INSERT INTO `base_vegetables_quotation` VALUES ('17', '14', '2', '2018-10-21 05:34:33', '2.50', '0.00', '00', '无', '2018-11-17 00:34:59', '2018-11-17 00:34:59');
INSERT INTO `base_vegetables_quotation` VALUES ('18', '15', '2', '2018-10-21 00:36:49', '2.50', '0.00', '00', '无', '2018-11-17 00:37:12', '2018-11-17 00:37:12');
INSERT INTO `base_vegetables_quotation` VALUES ('19', '16', '2', '2018-10-21 00:36:49', '4.00', '0.00', '00', '无', '2018-11-17 00:37:38', '2018-11-17 00:37:38');
INSERT INTO `base_vegetables_quotation` VALUES ('20', '5', '2', '2018-10-21 00:36:49', '3.00', '0.00', '00', '无', '2018-11-17 00:37:55', '2018-11-17 00:37:55');
INSERT INTO `base_vegetables_quotation` VALUES ('21', '17', '2', '2018-10-21 00:36:49', '10.00', '0.00', '00', '无', '2018-11-17 00:38:06', '2018-11-17 00:38:06');
INSERT INTO `base_vegetables_quotation` VALUES ('22', '18', '2', '2018-10-21 00:36:49', '4.00', '0.00', '00', '无', '2018-11-17 00:38:16', '2018-11-17 00:38:16');
INSERT INTO `base_vegetables_quotation` VALUES ('23', '13', '1', '2018-11-30 10:23:16', '3.50', '0.00', '00', '无', '2018-11-30 10:23:31', '2018-11-30 10:23:31');
INSERT INTO `base_vegetables_quotation` VALUES ('24', '13', '1', '2018-11-30 10:23:16', '2.00', '0.00', '00', '无', '2018-11-30 10:24:01', '2018-11-30 10:24:01');
INSERT INTO `base_vegetables_quotation` VALUES ('25', '1', '1', '2018-11-30 10:23:16', '1.50', '0.00', '00', '无', '2018-11-30 10:24:19', '2018-11-30 10:24:19');
INSERT INTO `base_vegetables_quotation` VALUES ('26', '5', '1', '2018-11-30 10:23:16', '2.50', '0.00', '00', '无', '2018-11-30 10:24:32', '2018-11-30 10:24:32');
INSERT INTO `base_vegetables_quotation` VALUES ('27', '2', '1', '2018-11-30 10:23:16', '4.50', '0.00', '00', '无', '2018-11-30 10:24:48', '2018-11-30 10:24:48');
INSERT INTO `base_vegetables_quotation` VALUES ('28', '20', '1', '2018-11-30 10:26:18', '5.00', '0.00', '00', '无', '2018-11-30 10:26:26', '2018-11-30 10:26:26');
INSERT INTO `base_vegetables_quotation` VALUES ('29', '6', '1', '2018-11-30 10:26:18', '4.00', '0.00', '00', '无', '2018-11-30 10:26:37', '2018-11-30 10:26:37');
INSERT INTO `base_vegetables_quotation` VALUES ('30', '21', '1', '2018-11-30 10:27:57', '9.00', '0.00', '00', '无', '2018-11-30 10:28:03', '2018-11-30 10:28:03');
INSERT INTO `base_vegetables_quotation` VALUES ('31', '22', '1', '2018-11-30 10:27:57', '8.00', '0.00', '00', '无', '2018-11-30 10:28:15', '2018-11-30 10:28:15');
INSERT INTO `base_vegetables_quotation` VALUES ('32', '17', '1', '2018-11-30 10:29:33', '11.00', '0.00', '00', '无', '2018-11-30 10:29:38', '2018-11-30 10:29:38');
INSERT INTO `base_vegetables_quotation` VALUES ('33', '3', '1', '2018-11-30 10:29:33', '6.00', '0.00', '00', '无', '2018-11-30 10:29:53', '2018-11-30 10:29:53');
INSERT INTO `base_vegetables_quotation` VALUES ('34', '21', '3', '2018-11-30 10:29:33', '13.00', '0.00', '00', '无', '2018-11-30 10:30:06', '2018-11-30 10:30:06');
INSERT INTO `base_vegetables_quotation` VALUES ('35', '22', '3', '2018-11-30 10:29:33', '13.00', '0.00', '00', '无', '2018-11-30 10:30:14', '2018-11-30 10:30:14');
INSERT INTO `base_vegetables_quotation` VALUES ('36', '17', '3', '2018-11-30 10:29:33', '12.00', '0.00', '00', '无', '2018-11-30 10:30:23', '2018-11-30 10:30:23');
INSERT INTO `base_vegetables_quotation` VALUES ('37', '1', '3', '2018-11-30 10:29:33', '3.00', '0.00', '00', '无', '2018-11-30 10:30:39', '2018-11-30 10:30:39');
INSERT INTO `base_vegetables_quotation` VALUES ('38', '13', '3', '2018-11-30 10:29:33', '5.00', '0.00', '00', '无', '2018-11-30 10:30:49', '2018-11-30 10:30:49');
INSERT INTO `base_vegetables_quotation` VALUES ('39', '11', '3', '2018-11-30 10:29:33', '2.50', '0.00', '00', '无', '2018-11-30 10:31:00', '2018-11-30 10:31:00');
INSERT INTO `base_vegetables_quotation` VALUES ('40', '19', '2', '2018-11-30 10:59:43', '111.00', '11.00', '00', '无', '2018-11-30 10:59:54', '2018-11-30 10:59:54');
INSERT INTO `base_vegetables_quotation` VALUES ('41', '19', '1', '2018-11-30 13:38:33', '11.00', '11.00', '00', '无', '2018-11-30 13:39:17', '2018-11-30 13:39:17');
INSERT INTO `base_vegetables_quotation` VALUES ('42', '19', '1', '2018-11-30 13:40:07', '2531.00', '551.00', '01', '沙发了倒计时1', '2018-11-30 13:43:14', '2018-11-30 13:40:15');
INSERT INTO `base_vegetables_quotation` VALUES ('43', '19', '1', '2018-11-30 15:07:02', '12344.00', '45644.00', '00', '445644', '2018-11-30 15:07:23', '2018-11-30 15:07:11');

-- ----------------------------
-- Table structure for base_vegetables_varieties
-- ----------------------------
DROP TABLE IF EXISTS `base_vegetables_varieties`;
CREATE TABLE `base_vegetables_varieties` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蔬菜品种表(varieties)',
  `c_id` int(11) NOT NULL COMMENT '蔬菜类别编号 逻辑外键  base_vegetables_category',
  `m_id` int(11) NOT NULL COMMENT '蔬菜进货来源商户id  逻辑外键 base_vegetables_purchase_source',
  `b_id` int(11) NOT NULL COMMENT '蔬菜品牌id  逻辑外键  base_vegetables_brand',
  `v_name` varchar(50) NOT NULL COMMENT '蔬菜名称',
  `v_img_url` varchar(255) NOT NULL DEFAULT '0' COMMENT '蔬菜图片url',
  `v_price` decimal(10,2) NOT NULL COMMENT '蔬菜价格',
  `v_unit` varchar(20) NOT NULL COMMENT '单位 (份，克，千克)',
  `v_place_origin` varchar(50) NOT NULL DEFAULT '0' COMMENT '产地',
  `v_mature_season` int(2) NOT NULL COMMENT '蔬菜上市季节',
  `v_mature_end_season` int(2) NOT NULL COMMENT '蔬菜下市季节',
  `v_is_back_season` char(2) NOT NULL COMMENT '该蔬菜是否反季节  00:否  01:是',
  `v_del` char(2) NOT NULL COMMENT '是否逻辑删除 00:可用  01:已删除',
  `v_sellout` char(2) NOT NULL DEFAULT '0' COMMENT '是否售完 00:未售完  01:已售完',
  `v_remark` varchar(100) NOT NULL DEFAULT '0' COMMENT '蔬菜品种备注信息',
  `v_updatetime` datetime NOT NULL COMMENT '修改时间',
  `v_createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`v_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of base_vegetables_varieties
-- ----------------------------
INSERT INTO `base_vegetables_varieties` VALUES ('1', '1', '1', '1', '花菜', '', '3.50', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('2', '1', '1', '1', '花生', '', '4.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('3', '1', '1', '2', '高笋', '', '2.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('4', '1', '1', '1', '虾', '', '16.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('5', '1', '1', '1', '娃娃菜', '', '2.50', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('6', '1', '1', '1', '茄子', '', '4.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('7', '1', '1', '1', '鲳鱼', '', '15.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('8', '1', '1', '1', '小黄鱼', '', '12.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('9', '1', '1', '1', '毛芋', '', '2.50', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('10', '1', '1', '1', '南瓜', '', '2.50', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('11', '1', '1', '1', '青菜', '', '1.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('12', '1', '1', '1', '青椒', '', '4.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('13', '1', '1', '1', '芹菜', '', '4.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('14', '1', '1', '1', '包菜', '', '2.50', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('15', '1', '1', '1', '大白菜', '', '2.50', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('16', '1', '1', '1', '本地茄子', '', '4.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('17', '1', '1', '1', '韭黄', '', '10.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('18', '1', '1', '1', '番茄', '', '4.00', '', '', '1', '0', '00', '00', '00', '无', '2018-10-21 04:48:38', '2018-10-21 04:48:38');
INSERT INTO `base_vegetables_varieties` VALUES ('19', '1', '2', '1', 'Test', '', '10.10', '', '', '1', '1', '01', '00', '00', '无', '2018-11-22 22:45:08', '2018-11-22 22:45:08');
INSERT INTO `base_vegetables_varieties` VALUES ('20', '1', '1', '1', '蚝菜', '', '5.00', '', '', '1', '1', '00', '00', '00', '无', '2018-11-22 22:45:08', '2018-11-22 22:45:08');
INSERT INTO `base_vegetables_varieties` VALUES ('21', '1', '1', '1', '香菇', '', '9.00', '', '', '1', '1', '00', '00', '00', '无', '2018-11-22 22:45:08', '2018-11-22 22:45:08');
INSERT INTO `base_vegetables_varieties` VALUES ('22', '1', '1', '1', '蘑菇', '', '8.00', '', '', '1', '1', '00', '00', '00', '无', '2018-11-22 22:45:08', '2018-11-22 22:45:08');
INSERT INTO `base_vegetables_varieties` VALUES ('23', '1', '1', '1', '77712', '', '77712.00', '', '', '8', '2', '01', '01', '00', 'dfgf', '2018-11-30 16:00:15', '2018-11-30 13:56:42');
INSERT INTO `base_vegetables_varieties` VALUES ('24', '1', '1', '1', '111111111111', '', '1111.00', '', '', '1', '1', '01', '00', '01', '1111', '2018-12-27 22:22:01', '2018-12-27 22:21:52');
INSERT INTO `base_vegetables_varieties` VALUES ('25', '2', '2', '2', '22222333', '22', '2233.00', '1', '1', '1', '1', '01', '00', '00', '22', '2019-01-16 22:00:52', '2019-01-15 18:19:06');
INSERT INTO `base_vegetables_varieties` VALUES ('26', '1', '3', '1', '555', '55', '55.00', '55', '55', '1', '1', '01', '00', '00', '5', '2019-01-16 22:01:15', '2019-01-16 22:01:15');
