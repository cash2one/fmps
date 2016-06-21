-- --------------------------------------------------------
-- 主机:                           10.1.21.52
-- 服务器版本:                        5.6.20-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  8.3.0.4814
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 fmps.weixin_plan 结构
CREATE TABLE IF NOT EXISTS `weixin_plan` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `serialno` int(6) NOT NULL COMMENT '计划序号',
  `planname` varchar(20) NOT NULL COMMENT '计划名称',
  `productid` varchar(32) NOT NULL COMMENT '产品ID',
  `codeproductcode` varchar(20) NOT NULL COMMENT '核心产品代码',
  `period` int(6) NOT NULL COMMENT '保险期限',
  `periodtype` varchar(5) NOT NULL COMMENT '保险期限类型(年、月、日)',
  `premium` int(6) NOT NULL COMMENT '保费',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `state` varchar(5) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品计划表';

-- 正在导出表  fmps.weixin_plan 的数据：~10 rows (大约)
DELETE FROM `weixin_plan`;
/*!40000 ALTER TABLE `weixin_plan` DISABLE KEYS */;
INSERT INTO `weixin_plan` (`id`, `serialno`, `planname`, `productid`, `codeproductcode`, `period`, `periodtype`, `premium`, `createtime`, `state`) VALUES
	('ff8080814d8fd53d014d8fedbb510001', 1122, 'sadfasdf', 'ff8080814d8fd559014d8fec1b6f0002', '0313000100000000', 1, '年', 100, '2015-05-26 19:13:51', '有效'),
	('ff8080814d9405fe014d940faecf0002', 1111, 'aijiaka', 'ff8080814d9405fe014d940e34d30001', '0312000100000000', 6, '月', 0, '2015-05-27 14:29:25', '有效'),
	('ff8080814d9405fe014d94277d8a0007', 222, '交通守护卡', 'ff8080814d940613014d94260e3d0008', '2716000100000000', 6, '月', 0, '2015-05-27 14:55:25', '有效'),
	('ff8080814d9405fe014d94576c8a0013', 444, '安心卡B', 'ff8080814d940613014d9456c3cf0018', '2719000100000000', 1, '年', 199, '2015-05-27 15:47:46', '有效'),
	('ff8080814d9405fe014d94695512001c', 555, '骨折卡', 'ff8080814d9405fe014d9464d93f001b', '2733000100010000', 1, '年', 0, '2015-05-27 16:07:20', '有效'),
	('ff8080814d9405fe014d947603f7001f', 666, '长盛卡', 'ff8080814d9405fe014d9474b5f3001e', '2749000100000000', 1, '年', 100, '2015-05-27 16:21:11', '有效'),
	('ff8080814d940613014d9431b1b5000c', 333, '安心卡A', 'ff8080814d940613014d94310f09000b', '2718000100000000', 1, '年', 199, '2015-05-27 15:06:34', '有效'),
	('ff8080814d940613014d947c4abe0027', 777, '悠游天下卡', 'ff8080814d940613014d947b91dd0026', '2754000100000000', 8, '日', 0, '2015-05-27 16:28:03', '有效'),
	('ff8080814d940613014d9481ca140030', 888, '关爱卡', 'ff8080814d9405fe014d94810fe6002a', '2764000100000000', 1, '年', 200, '2015-05-27 16:34:03', '有效'),
	('ff8080814d9ee366014dacc71403000f', 999, '住宅守护卡', 'ff8080814d9ee364014dacbdb98b0008', '0315000100000000', 1, '年', 50, '2015-06-01 09:40:37', '有效');
/*!40000 ALTER TABLE `weixin_plan` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
