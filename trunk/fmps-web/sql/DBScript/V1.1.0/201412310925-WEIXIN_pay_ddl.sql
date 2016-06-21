-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.20 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.3.0.4814
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 fmps.weixin_offline_orderinfo 结构
CREATE TABLE IF NOT EXISTS `weixin_offline_orderinfo` (
  `ID` varchar(32) NOT NULL COMMENT 'uuid',
  `PayCode` varchar(10) NOT NULL COMMENT '支付码',
  `CoreOrderNo` varchar(22) DEFAULT NULL COMMENT '核心订单号',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单时间',
  `PayStatus` int(3) NOT NULL DEFAULT '0' COMMENT '订单状态0未支付 1支付成功 2支付失败',
  `TransactionId` varchar(32) DEFAULT NULL COMMENT '微信支付订单号',
  `ClassCode` char(2) NOT NULL COMMENT '订单类别CX代表车险，FC代表非车险',
  `PayCodeStatus` char(3) NOT NULL COMMENT '支付码状态001：验证码不存在002：验证码过期003：验证码无效-人工置失败004：已完成支付005：验证码可用',
  `InsuredName` varchar(120) NOT NULL COMMENT '被保险人名称',
  `SumPremium` double(20,2) unsigned DEFAULT NULL COMMENT '总保费',
  `PolicyStartDate` date NOT NULL COMMENT '保单起保日期',
  `LicenseNo` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `IdentifyNumber` varchar(20) DEFAULT NULL COMMENT '被保险人证件号码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下订单表';

-- 正在导出表  fmps.weixin_offline_orderinfo 的数据：~3 rows (大约)
DELETE FROM `weixin_offline_orderinfo`;
/*!40000 ALTER TABLE `weixin_offline_orderinfo` DISABLE KEYS */;
INSERT INTO `weixin_offline_orderinfo` (`ID`, `PayCode`, `CoreOrderNo`, `CreateTime`, `PayStatus`, `TransactionId`, `ClassCode`, `PayCodeStatus`, `InsuredName`, `SumPremium`, `PolicyStartDate`, `LicenseNo`, `IdentifyNumber`) VALUES
	('402889f657666ae401476670bb74000b', '123456', NULL, '2014-12-23 15:09:12', 0, NULL, 'cx', '001', '张三', 4560.00, '2014-12-23', '123456123', '123456786453'),
	('402889f657666ae401476670bb74000c', '123457', NULL, '2014-12-23 15:09:12', 0, NULL, 'fc', '005', '王二', 1520.00, '2014-12-10', '4567845', '451256786453'),
	('8a828e4f4a98dd01014a98eb89a80000', 'EjjNgN', NULL, '2014-12-30 09:59:40', 0, NULL, 'CX', '005', 'TEST3', 4563.65, '2015-01-14', '闽DC2350', '');
/*!40000 ALTER TABLE `weixin_offline_orderinfo` ENABLE KEYS */;


-- 导出  表 fmps.weixin_offline_order_detail 结构
CREATE TABLE IF NOT EXISTS `weixin_offline_order_detail` (
  `ID` varchar(32) NOT NULL,
  `orderinfo_id` varchar(32) NOT NULL COMMENT '关联orderinfo',
  `KindName` varchar(50) NOT NULL COMMENT '险种名称',
  `Amount` double(20,2) DEFAULT NULL COMMENT '保额',
  `Premium` double(20,2) DEFAULT NULL COMMENT '保费',
  `Nondeductible` char(50) NOT NULL COMMENT '不计免赔N否 Y 是',
  `RiskKind` int(3) NOT NULL COMMENT '险种类别1：商业险，2：交强险，3：车船税，4：交通守护保险，5：非车险',
  PRIMARY KEY (`ID`),
  KEY `FK_weixin_orderinfo_detail_weixin_orderinfo` (`orderinfo_id`),
  CONSTRAINT `FK_weixin_orderinfo_detail_weixin_orderinfo` FOREIGN KEY (`orderinfo_id`) REFERENCES `weixin_offline_orderinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下订单详细表';

-- 正在导出表  fmps.weixin_offline_order_detail 的数据：~8 rows (大约)
DELETE FROM `weixin_offline_order_detail`;
/*!40000 ALTER TABLE `weixin_offline_order_detail` DISABLE KEYS */;
INSERT INTO `weixin_offline_order_detail` (`ID`, `orderinfo_id`, `KindName`, `Amount`, `Premium`, `Nondeductible`, `RiskKind`) VALUES
	('402889f657666ae401476670bb74000x', '402889f657666ae401476670bb74000b', '车辆损失险', 150000.00, 1325.00, 'N', 1),
	('402889f657666ae401476670bb74000y', '402889f657666ae401476670bb74000b', '商业险', 50000.00, 1235.00, 'Y', 2),
	('402889f657666ae401476670bb74000z', '402889f657666ae401476670bb74000c', '家庭财产险', 150000.00, 1520.00, 'N', 5),
	('402889f657666ae401476670bb74001a', '402889f657666ae401476670bb74000b', '三者险', 8000.00, 2000.00, 'Y', 11),
	('8a828e4f4a98dd01014a98eb89e20001', '8a828e4f4a98dd01014a98eb89a80000', '机动车损失保险', 197100.00, 2747.65, 'N', 2),
	('8a828e4f4a98dd01014a98eb89e50002', '8a828e4f4a98dd01014a98eb89a80000', '第三者责任保险', 50000.00, 566.00, 'N', 2),
	('8a828e4f4a98dd01014a98eb89e60003', '8a828e4f4a98dd01014a98eb89a80000', '机动车交通事故责任强制险', 122000.00, 950.00, 'N', 1),
	('8a828e4f4a98dd01014a98eb89e80004', '8a828e4f4a98dd01014a98eb89a80000', '车船税', 0.00, 300.00, '', 3);
/*!40000 ALTER TABLE `weixin_offline_order_detail` ENABLE KEYS */;


-- 导出  表 fmps.weixin_offline_order_log 结构
CREATE TABLE IF NOT EXISTS `weixin_offline_order_log` (
  `ID` varchar(32) NOT NULL,
  `orderinfo_id` varchar(32) NOT NULL COMMENT '外联orderinfo',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `Remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `PayStatus` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态0未支付 1支付成功 2支付失败',
  `Reason` varchar(200) DEFAULT '0' COMMENT '异常原因',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下订单日志表';

-- 正在导出表  fmps.weixin_offline_order_log 的数据：~9 rows (大约)
DELETE FROM `weixin_offline_order_log`;
/*!40000 ALTER TABLE `weixin_offline_order_log` DISABLE KEYS */;
INSERT INTO `weixin_offline_order_log` (`ID`, `orderinfo_id`, `CreateTime`, `Remark`, `PayStatus`, `Reason`) VALUES
	('8a828e4f4a7aeedc014a7aef45b20001', '123456', '2014-12-24 14:15:08', '支付成功！', 1, 'ok'),
	('8a828e4f4a85e8d0014a85ea6b720007', '8a828e4f4a85cb8d014a85d3a30e0004', '2014-12-26 17:29:39', '支付成功！', 1, 'undefined'),
	('8a828e4f4a948de4014a94917db20004', '402889f657666ae401476670bb74000b', '2014-12-29 13:42:50', '支付成功！', 1, 'æä½æå'),
	('8a828e4f4a949e45014a949e5a210001', '402889f657666ae401476670bb74000b', '2014-12-29 13:56:53', '支付成功！', 1, 'æä½æå'),
	('8a828e4f4a949e45014a94a03d720002', '402889f657666ae401476670bb74000b', '2014-12-29 13:58:57', '支付失败！', 2, 'æä½æå'),
	('8a828e4f4a949e45014a94a2c0c90003', '402889f657666ae401476670bb74000b', '2014-12-29 14:01:41', '支付失败！', 2, 'æä½æå'),
	('8a828e4f4a949e45014a94adb1370004', '402889f657666ae401476670bb74000b', '2014-12-29 14:13:38', '支付成功！', 1, 'æä½æå'),
	('8a828e4f4a94bbaf014a94c7bd30000d', '8a828e4f4a94bb9e014a94c1f7f50001', '2014-12-29 14:42:05', '支付成功！', 1, 'get_brand_wcpay_request:ok'),
	('8a828e4f4a952f78014a953229c30004', '8a828e4f4a94bb9e014a94c1f7f50001', '2014-12-29 16:38:20', '支付成功！', 1, 'get_brand_wcpay_request:ok');
/*!40000 ALTER TABLE `weixin_offline_order_log` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
