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

-- 导出  表 fmps.weixin_product_rule 结构
CREATE TABLE IF NOT EXISTS `weixin_product_rule` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `productid` varchar(32) NOT NULL COMMENT '产品ID',
  `maxage` int(6) NOT NULL COMMENT '投保最大年龄',
  `minage` int(6) NOT NULL COMMENT '投保最小年龄',
  `unit` int(3) DEFAULT NULL COMMENT '最大份数',
  `rulename` varchar(100) NOT NULL COMMENT '规则名称',
  `ruletype` varchar(20) NOT NULL COMMENT '规则类型',
  `ruleclass` varchar(50) NOT NULL COMMENT '规则分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品投保规则';

-- 正在导出表  fmps.weixin_product_rule 的数据：~19 rows (大约)
DELETE FROM `weixin_product_rule`;
/*!40000 ALTER TABLE `weixin_product_rule` DISABLE KEYS */;
INSERT INTO `weixin_product_rule` (`id`, `productid`, `maxage`, `minage`, `unit`, `rulename`, `ruletype`, `ruleclass`) VALUES
	('ff8080814d8fd559014d8fee311e0003', 'ff8080814d8fd559014d8fec1b6f0002', 106, 18, 0, 'asd', '投保人', '年龄规则'),
	('ff8080814d9405fe014d942800080008', 'ff8080814d940613014d94260e3d0008', 106, 18, 0, '交通守护卡', '投保人', '年龄规则'),
	('ff8080814d9405fe014d94779c5b0021', 'ff8080814d9405fe014d9474b5f3001e', 106, 18, 0, '长盛卡', '投保人', '年龄规则'),
	('ff8080814d940613014d94490713000f', 'ff8080814d940613014d94310f09000b', 65, 18, 0, '安心卡A', '被保人', '年龄规则'),
	('ff8080814d940613014d9461d0f0001c', 'ff8080814d940613014d9456c3cf0018', 106, 18, 0, '安心卡B', '投保人', '年龄规则'),
	('ff8080814d940613014d9469f54e001f', 'ff8080814d9405fe014d9464d93f001b', 106, 18, 0, '骨折卡', '投保人', '年龄规则'),
	('ff8080814d940613014d947d90e40028', 'ff8080814d940613014d947b91dd0026', 106, 18, 0, '悠游天下卡', '投保人', '年龄规则'),
	('ff8080814d940613014d9482daee003b', 'ff8080814d9405fe014d94810fe6002a', 106, 18, 0, '关爱卡', '投保人', '年龄规则'),
	('ff8080814dd2b4d9014dd2fbfe65000f', 'ff8080814d8fd559014d8fec1b6f0002', 65, 18, 0, '投保人', '被保人', '年龄规则'),
	('ff8080814dd2b4dd014dd30fef180027', 'ff8080814d940613014d94260e3d0008', 65, 18, 0, 'ss', '被保人', '年龄规则'),
	('ff8080814dd7c4c6014dd7cbfca20001', 'ff8080814d940613014d94310f09000b', 106, 18, 0, 'baxr', '投保人', '年龄规则'),
	('ff8080814dd7c4c6014dd7e403d20024', 'ff8080814d940613014d947b91dd0026', 65, 18, 0, '被保人规则', '被保人', '年龄规则'),
	('ff8080814dd7c4c6014dd7f2f9110041', 'ff8080814d9ee364014dacbdb98b0008', 106, 18, 0, '11', '投保人', '年龄规则'),
	('ff8080814ddaf49f014ddb5f9b900068', 'ff8080814d9405fe014d940e34d30001', 106, 18, 0, '投保人', '投保人', '年龄规则'),
	('ff8080814ddaf49f014ddb7459f10069', 'ff8080814d9405fe014d9474b5f3001e', 65, 18, 0, 'bax', '被保人', '年龄规则'),
	('ff8080814ddaf4ba014ddb5fcbfe0058', 'ff8080814d9405fe014d940e34d30001', 65, 18, 0, '被保险人', '被保人', '年龄规则'),
	('ff8080814ddaf4ba014ddb6ff7de005a', 'ff8080814d940613014d9456c3cf0018', 65, 18, 0, 'baxr', '被保人', '年龄规则'),
	('ff8080814ddaf4ba014ddb709f9c005b', 'ff8080814d9405fe014d9464d93f001b', 65, 20, 0, 'bba', '被保人', '年龄规则'),
	('ff8080814ddaf4ba014ddb7e02d5005d', 'ff8080814d9405fe014d94810fe6002a', 65, 18, 0, 'bax', '被保人', '年龄规则');
/*!40000 ALTER TABLE `weixin_product_rule` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
